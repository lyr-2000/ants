package com.ants.controller.chat;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ants.entity.chat.ChatContactor;
import com.ants.entity.chat.ChatOffline;
import com.ants.entity.chat.ChatUtil;
import com.ants.impl.chat.ChatOfflineServiceImpl;
import com.ants.impl.chat.ChatServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;
import org.springframework.web.socket.messaging.SessionConnectedEvent;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author 晨边#CB
 * @Date:created in  2019/9/15 23:47
 * @Version V1.0
 **/
@Controller
@Transactional
public class SystemWebSocketHandler  extends AbstractWebSocketHandler implements ApplicationListener<SessionConnectedEvent> {

    private static  ChatServiceImpl chatService;
    @Autowired
    public void setChatServiceImpl(ChatServiceImpl chatService) {
        SystemWebSocketHandler.chatService = chatService;
    }

    private static  ChatOfflineServiceImpl chatOfficelineService;
    @Autowired
    public void setChatOfflineServiceImpl(ChatOfflineServiceImpl chatOfficelineService) {
        SystemWebSocketHandler.chatOfficelineService = chatOfficelineService;
    }

    SimpleDateFormat sdf =new SimpleDateFormat("yyyy/MM/dd" );
    Date date ;

    public final static Map<Integer, WebSocketSession> sessionMap = Collections.synchronizedMap(new HashMap<Integer, WebSocketSession>());
    SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    FileOutputStream output;
    Boolean flag = true;


    //当刚刚连接上之后
    @Override
    public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {
        int id = (int)webSocketSession.getAttributes().get("id");
        System.out.println("Connection established..."+webSocketSession.getRemoteAddress());
        System.out.println(webSocketSession.getAttributes().get("user")+" Login");
        List<ChatContactor> list = chatService.queryContactor(id);//获得联系人列表
        for (ChatContactor chatContactorDTO : list) {
            if(sessionMap.get(chatContactorDTO.getContactor())!=null){
                chatContactorDTO.setIfonline(true);
            }else {
                chatContactorDTO.setIfonline(false);
            }
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("type",5);
        jsonObject.put("contactorlist",list);
        System.out.println("消息:"+jsonObject.toJSONString());
        webSocketSession.sendMessage(new TextMessage(jsonObject.toJSONString()));
        sessionMap.put(id,webSocketSession);
    }

    //在连接关闭之后
    @Override
    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus status) throws Exception {
        System.out.println("Connection closed..."+webSocketSession.getRemoteAddress()+" "+status);
        System.out.println(webSocketSession.getAttributes().get("user")+" Logout");
        int id = (int)webSocketSession.getAttributes().get("id");
        List<ChatContactor> list = chatService.queryContactor(id);//获得联系人列
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("type",0);
        jsonObject.put("offlineid",id);
        jsonObject.put("offlinename",webSocketSession.getAttributes().get("user"));
        for (ChatContactor chatContactorDTO : list) {
            if(sessionMap.containsKey(chatContactorDTO.getContactor())){
                sessionMap.get(chatContactorDTO.getContactor()).sendMessage(new TextMessage(jsonObject.toJSONString()));
            }
        }
        //保存对应的消息
        sessionMap.remove(id);
    }

    //发送消息的时候
    @Override
    public void handleTextMessage(WebSocketSession websocketsession, TextMessage message)
    {
        String payload=message.getPayload();
        System.out.println(payload);

        JSONObject jsonObject = JSONObject.parseObject(payload);
        int type = jsonObject.getInteger("type");
        int id = jsonObject.getInteger("id");
        int business = jsonObject.getInteger("business");

        try {
            if(type==0){
                ChatUtil chatUtilDTO = new ChatUtil();
                chatUtilDTO.setStudentId(id);
                chatUtilDTO.setContactor(business);
                List<ChatContactor> chatContactor = chatService.queryInformation(chatUtilDTO);
                JSONObject json = new JSONObject();
                json.put("type",4);
                List list = new ArrayList();
                for (ChatContactor contactor : chatContactor) {
                    JSONObject js = new JSONObject();
                    js.put("id",contactor.getContactor());
                    js.put("information",contactor.getInformation());
                    js.put("type","0");
                    list.add(js);
                }
                json.put("from",list);
//                json.put("latestTime",chatContactor.getLatestTime());
                System.out.println("历史消息在这了："+json.toJSONString());
                websocketsession.sendMessage(new TextMessage(json.toJSONString()));
            }
            else  if(type==1){
                WebSocketSession socketSession = sessionMap.get(business);
                if(socketSession!=null) {
                    JSONObject json = new JSONObject();
                    json.put("msg",jsonObject.getString("msg"));
                    json.put("time",format.format(new Date()));
                    json.put("type",1);
                    json.put("from",id);
                    json.put("fromname",chatService.userQuery(id).getUsername());
                    socketSession.sendMessage(new TextMessage(json.toJSONString()));
                    //把消息存入历史消息里面
                    ChatContactor chatContactor = new ChatContactor();
                    chatContactor.setInformation(jsonObject.getString("msg"));
                    chatContactor.setStudentId(jsonObject.getInteger("id"));
                    chatContactor.setContactor(jsonObject.getInteger("business"));
                    date = new Date();
                    String time = sdf.format(date);

                    chatContactor.setLatestTime(time);
                    chatService.appendmsg(chatContactor);
                    //更新联系人最后一次聊天时间
                    chatService.updateTime(chatContactor);
                }else {
                    //用户为在线发送离线消息,存入数据库
                    String time = sdf.format( new Date());
                    ChatOffline chatOfflineDTO = new ChatOffline();
                    chatOfflineDTO.setStudentId(id);
                    chatOfflineDTO.setTo(business);
                    chatOfflineDTO.setOfflinemessage(jsonObject.getString("msg"));
                    chatOfflineDTO.setLatestTime(time);
                    chatOfficelineService.insertOfficelineMessage(chatOfflineDTO);
                }


            }
            else if(type==2){
                String filename = jsonObject.getString("filename");
                output=new FileOutputStream(new File("D:\\images\\"+filename));
                websocketsession.getAttributes().put("filename",filename);
                websocketsession.getAttributes().put("to",business);
                flag = true;
            }else if (type==3){
                tosendfile(websocketsession);
                sendPicture(websocketsession);
            }else if(type==4){
                String msg = jsonObject.getString("information");
                ChatContactor chatContactorDTO = new ChatContactor();
                chatContactorDTO.setInformation(msg);
                chatContactorDTO.setContactor(business);
                chatContactorDTO.setStudentId(id);
                chatContactorDTO.setLatestTime(sdf.format( new Date()));
                chatService.appendmsg(chatContactorDTO);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void handleBinaryMessage(WebSocketSession session, BinaryMessage message)
    {
        ByteBuffer buffer= message.getPayload();
        try {
            output.write(buffer.array());
            //存入文件之后把文件发给对应的人

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void tosendfile(WebSocketSession session) {
        try {
            System.out.println("文件名字："+session.getAttributes().get("filename"));
            String textString;
            textString=" I ("+format.format(new Date())+")<br>"+ session.getAttributes().get("filename").toString()+"<br>";
//			textString+="<img src="+"D:\\images\\"+session.getAttributes().get("filename")+">";
            TextMessage textMessage = new TextMessage(textString);
            sessionMap.get(session.getAttributes().get("to")).sendMessage(textMessage);
            System.out.println("文件发送成功！！！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {
        if(webSocketSession.isOpen()){
            webSocketSession.close();
        }
        System.out.println(throwable.toString());
        System.out.println("WS connection error,close..."+webSocketSession.getRemoteAddress());
    }

    @Override
    public boolean supportsPartialMessages() {
        return true;
    }

    public void sendPicture(WebSocketSession session){
        FileInputStream input;
        try {
            File file=new File("D:\\images\\"+session.getAttributes().get("filename"));
            input = new FileInputStream(file);
            byte bytes[] = new byte[(int) file.length()];
            input.read(bytes);
            BinaryMessage byteMessage=new BinaryMessage(bytes);
            sessionMap.get(session.getAttributes().get("to")).sendMessage(byteMessage);
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onApplicationEvent(SessionConnectedEvent sessionConnectedEvent) {
//		String sessionId = (String) sessionConnectedEvent.getMessage().getHeaders().get("simpSessionId");

    }
}


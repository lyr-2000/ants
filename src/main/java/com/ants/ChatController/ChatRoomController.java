package com.ants.ChatController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ants.entity.ChatContactor;
import com.ants.entity.ChatOffline;
import com.ants.entity.ChatUtil;
import com.ants.impl.ChatOfflineServiceImpl;
import com.ants.impl.ChatServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;
import org.springframework.web.socket.messaging.SessionConnectedEvent;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
@Controller
public class ChatRoomController extends AbstractWebSocketHandler implements ApplicationListener<SessionConnectedEvent> {

	@Autowired
	private ChatServiceImpl chatService;

	@Autowired
	private ChatOfflineServiceImpl chatOfficelineService;


	public final static Map<Integer, WebSocketSession> sessionMap = Collections.synchronizedMap(new HashMap<Integer, WebSocketSession>());
	SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	FileOutputStream output;
	Boolean flag = true;


	//���ո�������֮��
	@Override
    public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {
		int id = (int)webSocketSession.getAttributes().get("id");
		System.out.println("Connection established..."+webSocketSession.getRemoteAddress());
		System.out.println(webSocketSession.getAttributes().get("user")+" Login");
		List<ChatContactor> list = chatService.queryContactor(id);//�����ϵ���б�
		for (ChatContactor chatContactorDTO : list) {
			if(sessionMap.get(chatContactorDTO.getContactor())!=null){
				chatContactorDTO.setIfonline(true);
			}else {
				chatContactorDTO.setIfonline(false);
			}
		}
		String jsonObject = JSON.toJSONString(list);
		webSocketSession.sendMessage(new TextMessage(jsonObject));
		sessionMap.put(id,webSocketSession);
    }



    //�����ӹر�֮��
	@Override
    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus status) throws Exception {
        System.out.println("Connection closed..."+webSocketSession.getRemoteAddress()+" "+status);
        System.out.println(webSocketSession.getAttributes().get("user")+" Logout");
        int id = (int)webSocketSession.getAttributes().get("id");
		List<ChatContactor> list = chatService.queryContactor(id);//�����ϵ����
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("type",0);
		jsonObject.put("offlineid",id);
		jsonObject.put("offlinename",webSocketSession.getAttributes().get("user"));
		for (ChatContactor chatContactorDTO : list) {
			if(sessionMap.containsKey(chatContactorDTO.getContactor())){
				sessionMap.get(chatContactorDTO.getContactor()).sendMessage(new TextMessage(jsonObject.toJSONString()));
			}
		}
		//�����Ӧ����Ϣ
        sessionMap.remove(id);
    }

    //������Ϣ��ʱ��
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
				String information = chatService.queryInformation(chatUtilDTO);
				JSONObject json = new JSONObject();
				json.put("type",4);
				json.put("business",business);
				json.put("information",information);
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

				}else {
						//�û�Ϊ���߷���������Ϣ,�������ݿ�
						ChatOffline chatOfflineDTO = new ChatOffline();
						chatOfflineDTO.setStudentId(id);
						chatOfflineDTO.setTo(business);
						chatOfflineDTO.setOfflinemessage(jsonObject.getString("msg"));
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
			//�����ļ�֮����ļ�������Ӧ����

		} catch (IOException e) {
			e.printStackTrace();
		}
    }

	private void tosendfile(WebSocketSession session) {
		try {
			System.out.println("�ļ����֣�"+session.getAttributes().get("filename"));
			String textString;
			textString=" I ("+format.format(new Date())+")<br>"+ session.getAttributes().get("filename").toString()+"<br>";
//			textString+="<img src="+"D:\\images\\"+session.getAttributes().get("filename")+">";
			TextMessage textMessage = new TextMessage(textString);
			sessionMap.get(session.getAttributes().get("to")).sendMessage(textMessage);
			System.out.println("�ļ����ͳɹ�������");
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

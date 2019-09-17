package com.ants.controller.chat;

import com.ants.entity.chat.ChatUserBase;
import com.ants.entity.chat.ChatUtil;
import com.ants.impl.chat.ChatServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import java.util.Map;
import java.util.Random;

/**
 * @Author 晨边#CB
 * @Date:created in  2019/9/15 23:46
 * @Version V1.0
 **/
@Controller
@RequestMapping
public class SpringWebSocketHandlerInterceptor extends HttpSessionHandshakeInterceptor {

    private static ChatServiceImpl chatService;
    @Autowired
    public void setChatService(ChatServiceImpl chatService) {
        SpringWebSocketHandlerInterceptor.chatService = chatService;
    }

    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler handler, Map<String, Object> attributes) throws Exception {
        //attributes是session里面的所有属性的map表示
        int id = Integer.parseInt(((ServletServerHttpRequest) request).getServletRequest().getParameter("id"));
        System.out.println(id+"11");
        System.out.println(((ServletServerHttpRequest) request).getServletRequest().getParameter("business")+"1111111");
        if(((ServletServerHttpRequest) request).getServletRequest().getParameter("business")!=null){
            int business = Integer.parseInt(((ServletServerHttpRequest) request).getServletRequest().getParameter("business"));
            //获取对应联系人信息
            attributes.put("business",business);
            obtaincontactor(id,business);
        }

        //查询数据库中对应的姓名并赋值给socket里面的session
        ChatUserBase chatUserBaseDTO = chatService.userQuery(id);
        attributes.put("id",id);
        attributes.put("user", chatUserBaseDTO.getUsername());

        return super.beforeHandshake(request, response, handler, attributes);
    }

    //查询此id对应的联系人是否为空，是的话添加id对应的联系人，否则不做任何事情
    private void obtaincontactor(int id, int business) {
        ChatUtil chatUtilDTO = new ChatUtil();
        chatUtilDTO.setContactor(business);
        chatUtilDTO.setStudentId(id);
        chatService.obtaincontactor(chatUtilDTO);
    }

    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception ex) {
        super.afterHandshake(request, response, wsHandler, ex);
    }

    //这里没做控制，所以聊天室内的人物名称可能发生重复，这个函数先没用
    public String getRandomNickName(){
        String[] nickNameArray={"Captain America","Deadpool","Hawkeye","Hulk","Iron Man","Spider Man","Thor","Wolverine","Black Panther","Colossus"};
        Random random=new Random();
        return nickNameArray[random.nextInt(10)];
    }

}

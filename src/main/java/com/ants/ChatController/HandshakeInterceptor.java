package com.ants.ChatController;

import com.ants.entity.ChatUserBase;
import com.ants.entity.ChatUtil;
import com.ants.impl.ChatServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import java.util.Map;
import java.util.Random;

/**
 * @Author 晨边#CB
 * @Date:created in  2019/8/21 3:33
 * @Version V1.0
 **/
@Controller
@Transactional
public class HandshakeInterceptor extends HttpSessionHandshakeInterceptor {


    @Autowired
    private ChatServiceImpl chatServic;

    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler handler, Map<String, Object> attributes) throws Exception {
        //attributes是session里面的所有属性的map表示
        int id = Integer.parseInt(((ServletServerHttpRequest) request).getServletRequest().getParameter("sid"));
        if(((ServletServerHttpRequest) request).getServletRequest().getParameter("business")!=null){
            int business = Integer.parseInt(((ServletServerHttpRequest) request).getServletRequest().getParameter("business"));
            //获取对应联系人信息
            attributes.put("business",business);
            obtaincontactor(id,business);
        }

        //查询数据库中对应的姓名并赋值给socket里面的session
        ChatUserBase chatUserBaseDTO = chatServic.userQuery(id);
        attributes.put("id",id);
        attributes.put("user", chatUserBaseDTO.getUsername());

        return super.beforeHandshake(request, response, handler, attributes);
    }

    //查询此id对应的联系人是否为空，是的话添加id对应的联系人，否则不做任何事情
    private void obtaincontactor(int id, int business) {
        ChatUtil chatUtilDTO = new ChatUtil();
        chatUtilDTO.setContactor(business);
        chatUtilDTO.setStudentId(id);
        chatServic.obtaincontactor(chatUtilDTO);
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

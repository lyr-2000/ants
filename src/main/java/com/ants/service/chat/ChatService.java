package com.ants.service.chat;

import com.ants.entity.chat.ChatContactor;
import com.ants.entity.chat.ChatUserBase;
import com.ants.entity.chat.ChatUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ChatService  {

    //获取id对应的人员信息
    public ChatUserBase userQuery(int id);

    public void obtaincontactor(ChatUtil chatUtilDTO) ;

    //查询id对应的联系人
    public List<ChatContactor> queryContactor(int id);


    public ChatContactor queryInformation(ChatUtil chatUtilDTO) ;

    //保存单个历史聊天消息，添加
    void appendmsg(ChatContactor chatContactorDTO);
}

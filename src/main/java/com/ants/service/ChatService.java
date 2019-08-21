package com.ants.service;

import com.ants.entity.ChatContactor;
import com.ants.entity.ChatUserBase;
import com.ants.entity.ChatUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ChatService  {

    //获取id对应的人员信息
    public ChatUserBase userQuery(int id);

    public void obtaincontactor(ChatUtil chatUtilDTO) ;

    //查询id对应的联系人
    public List<ChatContactor> queryContactor(int id);


    public String queryInformation(ChatUtil chatUtilDTO) ;

    //保存单个历史聊天消息，添加
    void appendmsg(ChatContactor chatContactorDTO);
}

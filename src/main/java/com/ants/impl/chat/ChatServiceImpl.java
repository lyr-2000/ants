package com.ants.impl.chat;

import com.ants.dao.chat.ChatDao;
import com.ants.entity.chat.ChatContactor;
import com.ants.entity.chat.ChatUserBase;
import com.ants.entity.chat.ChatUtil;
import com.ants.service.chat.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author 晨边#CB
 * @Date:created in  2019/8/21 3:14
 * @Version V1.0
 **/
@Service
public class ChatServiceImpl implements ChatService {

    private static  ChatDao chatDao;
    @Autowired
    public void setChatDao(ChatDao chatDao) {
        ChatServiceImpl.chatDao = chatDao;
    }


    //获取id对应的人员信息
    public ChatUserBase userQuery(int id) {
        ChatUserBase chatDTO = chatDao.userQuery(id);
        return  chatDTO;
    }

    public void obtaincontactor(ChatUtil chatUtilDTO) {
        ChatUtil chat = chatDao.queryContactor(chatUtilDTO);
        if(chat==null){
            ChatUserBase chatUserBaseDTO = userQuery(chatUtilDTO.getContactor());
            chatUtilDTO.setContactorName(chatUserBaseDTO.getUsername());
            chatUtilDTO.setContactorAvatar(chatUserBaseDTO.getPortrait());
            if(chatDao.insertcontactor(chatUtilDTO)>0){
                System.out.println("插入联系人成功");
            }else {
                System.out.println("插入联系人失败");
            }
        }else {
            System.out.println("联系人已经存在");
        }
    }

    //查询id对应的联系人
    public List<ChatContactor> queryContactor(int id) {
        List<ChatContactor> chatContactorDTO  = chatDao.queryAllContactor(id);
        return chatContactorDTO;
    }



    public List<ChatContactor> queryInformation(ChatUtil chatUtilDTO) {
        List<ChatContactor> chatContactor = chatDao.queryInformation(chatUtilDTO);
        return chatContactor;
    }

    //保存当个历史聊天消息,添加
    @Override
    public void appendmsg(ChatContactor chatContactorDTO) {
        int count = chatDao.appendmsg(chatContactorDTO);
        if(count>0){
            System.out.println("插入历史消息成功");
        }else {
            System.out.println("插入历史消息失败");
        }
    }

    public void updateTime(ChatContactor chatContactor) {
        int count = chatDao.updateTime(chatContactor);
        if(count>0){
            System.out.println("更新联系人成功");
        }else{
            System.out.println("更新联系人时间失败");
        }
    }
}

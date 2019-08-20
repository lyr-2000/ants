package com.ants.impl;

import com.ants.dao.ChatDao;
import com.ants.entity.ChatContactor;
import com.ants.entity.ChatUserBase;
import com.ants.entity.ChatUtil;
import com.ants.service.ChatService;
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

    @Autowired
    private ChatDao chatDao;


    //获取id对应的人员信息
    @Override
    public ChatUserBase userQuery(int id) {
        ChatUserBase chatDTO = chatDao.userQuery(id);
        return  chatDTO;
    }

    public void obtaincontactor(ChatUtil chatUtilDTO) {
        ChatUtil chat = chatDao.queryContactor(chatUtilDTO);
        if(chat==null){
            ChatUserBase chatUserBaseDTO = userQuery(chatUtilDTO.getContactor());
            chatUtilDTO.setContactorName(chatUserBaseDTO.getUsername());
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



    public String queryInformation(ChatUtil chatUtilDTO) {
        String information = chatDao.queryInformation(chatUtilDTO);
        return information;
    }

}

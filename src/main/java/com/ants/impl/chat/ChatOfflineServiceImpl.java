package com.ants.impl.chat;

import com.ants.dao.chat.ChatOfflineDao;
import com.ants.entity.chat.ChatOffline;
import com.ants.service.chat.ChatOfficelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author 晨边#CB
 * @Date:created in  2019/8/21 3:14
 * @Version V1.0
 **/
@Service
public class ChatOfflineServiceImpl implements ChatOfficelineService {

    @Autowired
    private ChatOfflineDao chatOfficelineMapper;

    public int insertOfficelineMessage(ChatOffline chatOfflineDTO){
        int flag = chatOfficelineMapper.insertOfficelineMessage(chatOfflineDTO);
        if(flag>0){
            System.out.println("离线消息插入成功了！！！");
        }else {
            System.out.println("离线消息插入失败!!");
        }
        return flag;
    }
}

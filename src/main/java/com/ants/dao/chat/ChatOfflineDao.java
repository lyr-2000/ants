package com.ants.dao.chat;

import com.ants.entity.chat.ChatOffline;
import org.springframework.stereotype.Repository;

/**
 * @Author 晨边#CB
 * @Date:created in  2019/8/21 2:59
 * @Version V1.0
 **/
@Repository
public interface ChatOfflineDao {

    //插入离线消息
    int insertOfficelineMessage(ChatOffline chatOfflineDTO);

}

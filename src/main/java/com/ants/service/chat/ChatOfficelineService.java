package com.ants.service.chat;

import com.ants.entity.chat.ChatOffline;
import org.springframework.stereotype.Service;

@Service
public interface ChatOfficelineService{

    public int insertOfficelineMessage(ChatOffline chatOfflineDTO);


}

package com.ants.service;

import com.ants.dao.ChatOfflineDao;
import com.ants.entity.ChatOffline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface ChatOfficelineService{

    public int insertOfficelineMessage(ChatOffline chatOfflineDTO);


}

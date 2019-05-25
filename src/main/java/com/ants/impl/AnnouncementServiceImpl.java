package com.ants.impl;

import com.ants.dao.AnnouncementDao;
import com.ants.entity.Announcement;
import com.ants.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author czd
 */
@Service
public class AnnouncementServiceImpl implements AnnouncementService {
    @Autowired
    private AnnouncementDao announcementDao;

    @Override
    public Announcement latestAnnouncement() {
        return announcementDao.latestAnnouncement();
    }
}

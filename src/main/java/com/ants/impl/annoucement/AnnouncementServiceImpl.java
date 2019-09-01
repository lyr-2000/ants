package com.ants.impl.annoucement;

import com.ants.dao.announcement.AnnouncementDao;
import com.ants.entity.announcement.Announcement;
import com.ants.service.announcement.AnnouncementService;
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

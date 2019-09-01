package com.ants.service.announcement;

import com.ants.entity.announcement.Announcement;
import org.springframework.stereotype.Service;

/**
 * @author czd
 */
@Service
public interface AnnouncementService {
    public Announcement latestAnnouncement();
}

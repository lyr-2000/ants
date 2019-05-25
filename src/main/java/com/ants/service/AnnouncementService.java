package com.ants.service;

import com.ants.entity.Announcement;
import org.springframework.stereotype.Service;

/**
 * @author czd
 */
@Service
public interface AnnouncementService {
    public Announcement latestAnnouncement();
}

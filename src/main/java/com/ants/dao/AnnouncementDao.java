package com.ants.dao;

import com.ants.entity.Announcement;
import org.springframework.stereotype.Repository;

/**
 * @author czd
 */
@Repository
public interface AnnouncementDao {
    public Announcement latestAnnouncement();
}

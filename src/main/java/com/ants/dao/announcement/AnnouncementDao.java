package com.ants.dao.announcement;

import com.ants.entity.announcement.Announcement;
import org.springframework.stereotype.Repository;

/**
 * @author czd
 */
@Repository
public interface AnnouncementDao {
    public Announcement latestAnnouncement();
}

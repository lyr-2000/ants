package com.ants.dao.announcement;

import com.ants.entity.announcement.Announcement;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author czd
 */
@Repository
public interface AnnouncementDao {
    /**
     * 获取一条最新的公告的数据信息
     * @return
     */
    public Announcement latestAnnouncement(Map<String,Integer> map);

    /**
     * 根据页面数获取公告列表的数据
     * @return
     */
    public List<Announcement> getAnnouncementList(Map<String,Integer> map);

    /**
     * 根据公告的id获取此公告的详细信息
     * @param annId
     * @return
     */
    public Announcement getAnnDetail(Integer annId);


}

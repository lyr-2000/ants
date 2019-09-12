package com.ants.dao.announcement;

import com.ants.entity.announcement.Announcement;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Author czd
 * @Date:created in 2019/10/11
 * @Version: V1.0
 */
@Repository
public interface AnnouncementDao {
    /**
     * 获取一条最新的公告的数据信息
     * @return
     */
     Announcement latestAnnouncement(Map<String,Integer> map);

    /**
     * 根据页面数获取公告列表的数据
     * @return
     */
     List<Announcement> getAnnouncementList(Map<String,Integer> map);

    /**
     * 根据公告的id获取此公告的详细信息
     * @param annId
     * @return
     */
     Announcement getAnnDetail(Integer annId);

    /**
     * 获取公告的数量
     * @return
     */
     Integer getAnnNum();


}

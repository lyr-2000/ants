package com.ants.entity.announcement;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * 公告实体类
 * @Author czd
 * @Date:created in 2019/10/11
 * @Version: V1.0
 */
@Component
@Data
public class Announcement {
    /**公告id，标识 */
    private int annId;
    /** 公告标题 */
    private String annTitle;
    /** 公告内容 */
    private String annContent;
    /** 公告发布时间 */
    private String annTime;

}

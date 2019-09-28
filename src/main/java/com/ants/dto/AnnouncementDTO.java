package com.ants.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * 公告栏信息的数据传输对象
 *
 * @Author czd
 * @Date:createed in
 * @Version: V1.0
 */
@Data
public class AnnouncementDTO {
    /** 公告编号 */
    private Integer annId;
    /** 公告标题 */
    private String annTitle;
    /** 公告内容 */
    private String annContent;
    /** 公告发布时间 */
    private String annTime;
}

package com.ants.entity.announcement;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * 公告实体类
 * @author czd
 */
@Component
@Data
public class Announcement {
    private int annId;
    private String annTitle;
    private String annContent;
    private String annTime;

}

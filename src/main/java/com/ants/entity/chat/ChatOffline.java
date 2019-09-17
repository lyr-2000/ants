package com.ants.entity.chat;

import lombok.Data;

/**
 * @Author 晨边#CB
 * @Date:created in  2019/8/21 2:50
 * @Version V1.0
 **/
@Data
public class ChatOffline {
    private Integer studentId;
    private Integer to;
    private String offlinemessage;
    private String latestTime;
}

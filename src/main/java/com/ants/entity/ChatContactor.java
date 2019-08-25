package com.ants.entity;

import lombok.Data;

/**
 * @Author 晨边#CB
 * @Date:created in  2019/8/21 2:49
 * @Version V1.0
 **/

@Data
public class ChatContactor {
    private Integer studentId ;
    private Integer contactor;
    private String contactorName;
    private String contactorAvatar;
    private String latestTime;
    private String information;
    private boolean ifonline;
}

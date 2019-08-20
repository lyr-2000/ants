package com.ants.entity;

import lombok.Data;

/**
 * @Author 晨边#CB
 * @Date:created in  2019/8/21 2:51
 * @Version V1.0
 **/

@Data
public class ChatUtil {
    //此个bean对应的ants_chat_user表
    private Integer id;
    private Integer studentId;
    private Integer contactor;
    private String contactorName;
    private String information;
    private String latestTime;
}

package com.ants.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * 反馈用户的反馈信息的数据传输对象
 * 作用：一是能提高数据传输的速度(减少了传输字段)，二能隐藏后端表结构
 * @Author czd
 * @Date:createed in
 * @Version: V1.0
 */
@Data
public class FeedBackDTO {
    /** 反馈内容 */
    private String fbContent;
    /** 反馈时间 */
    private String fbTime;
    /** 反馈满意度 */
    private Integer fbSatisfaction;
    /** 反馈用户的手机号码 */
    private String userMobile;
    /** 反馈用户的名称 */
    private String userName;
}

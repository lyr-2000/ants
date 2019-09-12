package com.ants.entity.personal;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @Author: CB#
 * @Date: 2019/5/22
 * @Description: com.ants.entity
 * @version: 1.0
 */
@Component
@Data
public class Student {
    /** 学生学号  */
    private int studentId;
    /**  学生名称 */
    private String userName;
    /**  学生性别：0 -> 男   1 -> 女 */
    private int userSex;
    /**  学生登录时的密码 */
    private String passWord;
    /** 存放的是一起加密过后的密码  */
    private String unpw;
    /** 学生手机号 */
    private String mobilePhone;
    /** 交易地址 */
    private String address;
    /** 头像图片 */
    private String portrait;
    /** 学生微信号 */
    private String userWechat;
    /** 学生QQ号 */
    private String userQQ;
    /** 注册时间 */
    private String registTime;
    /** 是否隐藏QQ:0:隐藏 1:不隐藏 */
    private int qqHidden;
    /** 是否隐藏微信:0:隐藏 1:不隐藏 */
    private int wechatHidden;


}

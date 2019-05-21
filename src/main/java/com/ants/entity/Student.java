package com.ants.entity;

import org.springframework.stereotype.Component;

/**
 * @Author: CB#
 * @Date: 2019/5/22
 * @Description: com.ants.entity
 * @version: 1.0
 */
@Component
public class Student {

        private int studentId;
        private String userName;
        private String password;
        private String uNpD ;//存放的是一起加密过后的密码
        private int sex;        //0:男   1：女
        private String mobilePhone;
        private String userWechat;
        private String userQQ;
        private String registTime;//注册时间
        private int Hidden ;//是否隐藏微信:0:隐藏 1:不隐藏

    public String getuNpD() {
        return uNpD;
    }

    public void setuNpD(String uNpD) {
        this.uNpD = uNpD;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getUserWechat() {
        return userWechat;
    }

    public void setUserWechat(String userWechat) {
        this.userWechat = userWechat;
    }

    public String getUserQQ() {
        return userQQ;
    }

    public void setUserQQ(String userQQ) {
        this.userQQ = userQQ;
    }

    public String getRegistTime() {
        return registTime;
    }

    public void setRegistTime(String registTime) {
        this.registTime = registTime;
    }

    public int getHidden() {
        return Hidden;
    }

    public void setHidden(int hidden) {
        Hidden = hidden;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", sex=" + sex +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", userWechat='" + userWechat + '\'' +
                ", userQQ='" + userQQ + '\'' +
                ", registTime='" + registTime + '\'' +
                ", Hidden=" + Hidden +
                '}';
    }
}

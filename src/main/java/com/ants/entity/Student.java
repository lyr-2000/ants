package com.ants.entity;

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
        private int studentId;
        private String userName;
        private int userSex; //0:男   1：女
        private String passWord;
//        private String uNpD ;//存放的是一起加密过后的密码
        private String mobilePhone;
        private String userWechat;
        private String userQQ;
        private String registTime;//注册时间
        private int hidden ;//是否隐藏微信:0:隐藏 1:不隐藏

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

        public int getUserSex() {
                return userSex;
        }

        public void setUserSex(int userSex) {
                this.userSex = userSex;
        }

        public String getPassWord() {
                return passWord;
        }

        public void setPassWord(String passWord) {
                this.passWord = passWord;
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
                return hidden;
        }

        public void setHidden(int hidden) {
                this.hidden = hidden;
        }
}

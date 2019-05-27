package com.ants.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.util.Random;

/**
 * @Author: CB#
 * @Date: 2019/5/27
 * @Description: com.ants.util
 * @version: 1.0
 */
//获取Token对象
public class TokenProccessor {
    /*
    单例模式（在类的对象中只存储一个）
     */
    private TokenProccessor(){}

    private static final TokenProccessor instance = new TokenProccessor();
    /*
    返回类的对象
     */
    public static TokenProccessor getInstance(){
        return instance;
    }

    /*
    生成Token
     */
    public String makeToken(){
        String token = (System.currentTimeMillis()+new Random().nextInt(999999999))+"";
        try{
            MessageDigest md = MessageDigest.getInstance("md5");
            byte md5[] = md.digest(token.getBytes());
            BASE64Encoder encoder = new BASE64Encoder();
            return encoder.encode(md5);
        }catch (Exception e){
           throw new RuntimeException(e);
        }
    }






}

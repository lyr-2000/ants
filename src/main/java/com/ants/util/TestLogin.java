package com.ants.util;

import com.alibaba.fastjson.JSONObject;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 * @Author 晨边啊啊#CB
 * @Date:created in  2019/8/22 20:49
 * @Version V1.0
 **/

public class TestLogin {
    //登录教务系统的验证
    public static JSONObject login(String studentId ,String passWord) throws IOException {

        String requestUrl = "http://jwxt.gduf.edu.cn/app.do?method=authUser&xh="+studentId+"&pwd="+passWord;
        //params用于存储请求数据的参数
        URL restURL = new URL(requestUrl);

        HttpURLConnection conn = (HttpURLConnection) restURL.openConnection();

        conn.setRequestMethod("GET"); // POST GET PUT DELETE
        conn.setRequestProperty("Accept", "application/json");

        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line = br.readLine();
        JSONObject jsonObject = JSONObject.parseObject(new String(line));
        br.close();
       return jsonObject;

    }


    }



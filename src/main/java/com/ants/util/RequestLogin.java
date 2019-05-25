package com.ants.util;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * @Author: cb
 * @Date: 2019/5/22
 * @Description: com.ants.util
 * @version: 1.0
 */
public class RequestLogin {
    public static int askForLogin(String param) throws IOException {
        String all = "encoded=" + URLEncoder.encode(param);
        PrintWriter out = null;
        BufferedReader in = null;
        HttpURLConnection conn = null;
        StringBuilder result = new StringBuilder();
        try {
            URL realUrl = new URL("http://jwxt.gduf.edu.cn/jsxsd/xk/LoginToXk");
            // 打开和URL之间的连接
            HttpURLConnection.setFollowRedirects(false);
            HttpURLConnection.setDefaultAllowUserInteraction(false);
            conn = (HttpURLConnection) realUrl.openConnection();

            // 设置通用的请求属性
            conn.setRequestProperty("Accept", "*/*");
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setRequestProperty("User-Agent",
                    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.10 Safari/537.36");
            conn.setRequestProperty("Accept-Charset", "UTF-8");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Host", "jwxt.gduf.edu.cn");
            conn.setRequestMethod("POST");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);


            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(all);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result.append(line);
            }

            out.flush();
            out.close();

        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！" + e);
            result = new StringBuilder("{\"resCode\":\"1\",\"errCode\":\"1001\",\"resData\":\"\"}");
            //log.error("远程服务未开启", e);
        }
        // 使用finally块来关闭输出流、输入流
        finally {
            out.close();
//                    in.close();
        }
        return conn.getResponseCode();
    }

}

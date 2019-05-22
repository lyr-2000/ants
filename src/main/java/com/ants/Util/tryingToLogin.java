package com.ants.util;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * @Author: http://www.baidu.com
 * @Date: 2019/5/22
 * @Description: com.ants.Util
 * @version: 1.0
 */
public class TryingToLogin {
    public static int sendPost( String param) throws IOException {
        //存防cookies的值
        String cookieVal;
        PrintWriter out = null;
        BufferedReader in = null;
        HttpURLConnection conn = null;
        StringBuilder result = new StringBuilder();
        try {
            //学校登录界面的链接
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
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result.append(line);
            }
            //获取cookies的值
            cookieVal = conn.getHeaderField("Set-Cookie");
            out.flush();
            out.close();
            /*
            登录之后的界面
             */
//            String s = "http://jwxt.gduf.edu.cn/jsxsd/framework/xsMain.jsp";


            /*
            课表的界面
             */
            String s = "http://jwxt.gduf.edu.cn/jsxsd/xskb/xskb_list.do";
            URL url  = new URL(s);
            HttpURLConnection resumeConnection = (HttpURLConnection) url.openConnection();
            if(cookieVal!=null){
                resumeConnection.setRequestProperty("Cookie",cookieVal);
            }
            resumeConnection.connect();
            InputStream urlStream = resumeConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlStream));
            String ss = null;
            String total = "";
            //存放文件到D盘下面的目录里
            File dest = new File("D:/学校.html");
            FileOutputStream fileOutputStream = new FileOutputStream(dest);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream,"gb2312");
            while((ss = bufferedReader.readLine()) != null){
                total +=ss;
                outputStreamWriter.write(ss);
            }


        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！" + e);
            result = new StringBuilder("{\"resCode\":\"1\",\"errCode\":\"1001\",\"resData\":\"\"}");
            //log.error("远程服务未开启", e);
        }
        // 使用finally块来关闭输出流、输入流
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return conn.getResponseCode();
    }
    public static void main(String[] args) throws IOException {

        int str = sendPost("encoded="+URLEncoder.encode("MTcxNTQzMTM3%%%em16ejA1MjI=") );
//           String str = sendPost("https://www.baidu.com","encoded=MTcxNTQzMTM3%%%em16ejA1MjI=" );
        System.out.println(str);
    }

}

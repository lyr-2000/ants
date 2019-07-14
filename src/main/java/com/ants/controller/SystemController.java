package com.ants.controller;

import com.alibaba.fastjson.JSON;
import com.ants.entity.Student;
import com.ants.service.StudentService;
import com.ants.util.SlideCode;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialStruct;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author czd
 * 登录和注销功能的Controller
 */
@Controller
@RequestMapping(value = "/ants/user")
public class SystemController  {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> studentsLogin(Student student, String cpacha, HttpServletRequest request) {
        Map<String, String> ants = new HashMap<String, String>();
        if (student == null) {
            ants.put("type", "false");
            ants.put("message", "请填写用户名");
            return ants;
        }
        if (StringUtils.isEmpty(cpacha)) {
            ants.put("type", "false");
            ants.put("message", "请填写验证码！");
            return ants;
        }
        if (StringUtils.isEmpty(student.getStudentId())) {
            ants.put("type", "error");
            ants.put("message", "请填写学号！");
            return ants;
        }
        if (StringUtils.isEmpty(student.getPassWord())) {
            ants.put("type", "error");
            ants.put("message", "请填写密码！");
            return ants;
        }
//        Object loginCpacha = request.getSession().getAttribute("loginCpacha");
        Object loginCpacha = "1234";
        if (loginCpacha == null) {
            ants.put("type", "error");
            ants.put("message", "未获取到验证码，请重新刷新下界面");
            return ants;
        }
        try {
            Map map = com.ants.util.TryingToLogin.sendPost(student.getUnpw(), student.getStudentId() + "");
            String statusCode = map.get("statusCode").toString();
            String studentName = map.get("studentName").toString();
            System.out.println("名字是:" + studentName);
            System.out.println("状态码是:" + statusCode);
            if (!"302".equals(statusCode)) {
                System.out.println("你输入的错误哦");
                ants.put("type", "error");
                ants.put("message", "该用户不存在");
                return ants;
            } else {
                System.out.println("你输入的正确");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.getSession().setAttribute("userId", student.getStudentId());
        return ants;//登录成功
    }






    @RequestMapping(value = "/testStudent", method = RequestMethod.GET)
    @ResponseBody
    public void doToken(HttpServletRequest request, HttpServletResponse response) {
        boolean b = isRepeatSubmit(request);//判断用户是否是重复提交
        if (b == true) {
            System.out.println("请不要重复提交");
            return;
        }
        request.getSession().removeAttribute("token");//移除session中的token
        System.out.println("处理用户提交请求！！");
    }

    /*
    判断有没有重复提交表单
     */
    private boolean isRepeatSubmit(HttpServletRequest request) {
        String client_token = request.getParameter("token");
        //1、如果用户提交的表单数据中没有token，则用户是重复提交了表单
        if (client_token == null) {
            return true;
        }
        //取出存储在Session中的token
        String server_token = (String) request.getSession().getAttribute("token");
        //2、如果当前用户的Session中不存在Token(令牌)，则用户是重复提交了表单
        if (server_token == null) {
            return true;
        }
        //3、存储在Session中的Token(令牌)与表单提交的Token(令牌)不同，则用户是重复提交了表单
        if (!client_token.equals(server_token)) {
            return true;
        }

        return false;
    }




}

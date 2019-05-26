package com.ants.controller;

import com.alibaba.fastjson.JSON;
import com.ants.entity.Student;
import com.ants.service.StudentService;
import com.ants.util.SlideCode;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletConfig;
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
public class SystemController {


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
            Map map = com.ants.util.TryingToLogin.sendPost(student.getUnpw(),student.getStudentId()+"");
            String statusCode = map.get("statusCode").toString();
            String studentName = map.get("studentName").toString();
            System.out.println("名字是:"+studentName);
            System.out.println("状态码是:"+statusCode);
            if (!"302".equals(statusCode)) {
                System.out.println("你输入的错误哦");
                ants.put("type", "error");
                ants.put("message", "该用户不存在");
                return ants;
            }else{
                System.out.println("你输入的正确");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.getSession().setAttribute("userId", student.getStudentId());
        return ants;//登录成功
    }

    /*
    登录获取首页的验证码
     */
    @RequestMapping(value = "/SlideCode", method = RequestMethod.POST)
    @ResponseBody
    protected void getSlideCode(HttpServletRequest request, HttpServletResponse response) {
        String imgname = request.getParameter("imgname");
        if (!StringUtils.isEmpty(imgname)) {
            imgname = imgname.substring(imgname.lastIndexOf("/") + 1, imgname.lastIndexOf("png") + 3);
        }
        PrintWriter out = null;
        try {
            SlideCode resourceImg = new SlideCode();
            Map<String, String> result = resourceImg.create(request, imgname);
            out = response.getWriter();
            response.setContentType("application/json-rpc;charset=UTF-8");
            out.println(JSON.toJSONString(result));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }


    /*
      判断验证码是否正确
     */
    @RequestMapping(value = "/JudgeCode", method = RequestMethod.POST)
    @ResponseBody
    protected void JudgeCode(HttpServletRequest request, HttpServletResponse response) {
        String point = request.getParameter("point");
        Integer location_x = (Integer) request.getSession().getAttribute("location_x");
        if ((Integer.valueOf(point) < location_x + 4) && (Integer.valueOf(point) > location_x - 4)) {
            //说明验证通过，
//            outData(response, "success");
            System.out.println("验证通过");
        } else {
//            outData(response, "error");
            System.out.println("验证失败");
        }
    }


    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/testStudent", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, String> addStudent() {
        Student student = new Student();
        student.setStudentId(1);
        student.setUserName("user");
        student.setUserSex(0);
        student.setPassWord("123456");
        student.setMobilePhone("13106617928");
        student.setUserWechat("weiXing");
        student.setUserQQ("1783209601");
        student.setRegistTime("2019-06-06");
        student.setHidden(0);
        int result = studentService.add(student);
        System.out.println("result: " + result);
        Map<String, String> map = new HashMap<>();
        map.put("1", "hello");
        return map;
    }

}

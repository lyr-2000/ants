package com.ants.controller;

import com.ants.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author czd
 */
@Controller
@RequestMapping(value = "/ants/user")
public class StudentController {


    @RequestMapping(value = "/login",method=RequestMethod.POST)
    @ResponseBody
    public Map<String ,String> studentsLogin(Student student, String cpacha, HttpServletRequest request){
        Map<String ,String> ants = new HashMap<String,String>();
        if(student ==null){
            ants.put("type","false");
            ants.put("message","请填写用户名");
            return ants;
        }
        if(StringUtils.isEmpty(cpacha)){
            ants.put("type", "false");
            ants.put("message", "请填写验证码！");
            return ants;
        }
        if(StringUtils.isEmpty(student.getUserName())){
            ants.put("type", "error");
            ants.put("message", "请填写用户名！");
            return ants;
        }
        if(StringUtils.isEmpty(student.getPassword())){
            ants.put("type", "error");
            ants.put("message", "请填写密码！");
            return ants;
        }
        Object loginCpacha = request.getSession().getAttribute("loginCpacha");
        if(loginCpacha == null){
            ants.put("type", "error");
            ants.put("message", "未获取到验证码，请重新刷新下界面");
            return ants;
        }
        try{
            if(com.ants.util.RequestLogin.askForLogin(student.getUNpD())!=303){
                ants.put("type","error");
                ants.put("message","改用户不存在");
                return ants;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;//登录成功
    }

//    @RequestMapping(value = "/testStudent",method = RequestMethod.GET)
//    @ResponseBody
//    public Map<String,String> testStudent(){
//        Student student = new Student();
//        student.setStudentId(1);
//        student.setUserName("user");
//        student.setPassword("123");
//        student
//
//        Map<String,String> map = new HashMap<>();
//        map.put("1","hello");
//        return map;
//    }

}

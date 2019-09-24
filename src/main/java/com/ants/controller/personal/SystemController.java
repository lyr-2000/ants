package com.ants.controller.personal;

import com.alibaba.fastjson.JSONObject;
import com.ants.entity.personal.Student;
import com.ants.service.personal.StudentService;
import com.ants.util.TestLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
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
        //滑动验证码校验
        HttpSession session = request.getSession();
        if (!"1".equals(session.getAttribute("slide"))) {
            ants.put("type", "error");
            ants.put("message", "未获取到验证码，请重新刷新下界面");
            return ants;
        }

        if (StringUtils.isEmpty(student.getStudentId())||student.getStudentId()==0) {
            ants.put("type", "error");
            ants.put("message", "请填写学号！");
            return ants;
        }
        if (StringUtils.isEmpty(student.getPassWord())) {
            System.out.println(student.getStudentId()+"!!!!!");
            ants.put("type", "error");
            ants.put("message", "请填写密码！");
            return ants;
        }


        try {
            JSONObject jsonObject = TestLogin.login(student.getUnpw(),student.getStudentId()+"");
            Map map = new HashMap();
            //登录成功
            if(jsonObject.getString("flag").equals("1")){
                    map.put("state",1);
                    map.put("message","登录成功");
                    map.put("userdwmc",jsonObject.getString("userdwmc"));
                    map.put("username",jsonObject.getString("userrealname"));
            }else {
                //登录失败
                map.put("state",0);
                map.put("message","登录失败");
                map.put("userdwmc",jsonObject.getString("userdwmc"));
                map.put("username",jsonObject.getString("userrealname"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        request.getSession().setAttribute("userId", student.getStudentId());
        return ants;
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

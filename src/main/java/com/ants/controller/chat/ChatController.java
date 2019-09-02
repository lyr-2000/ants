package com.ants.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author 晨边#CB
 * @Date:created in  2019/8/21 2:47
 * @Version V1.0
 **/
//访问聊天界面的controller
@Controller
public class ChatController {

    @RequestMapping("/hello")
    public String getString(HttpServletRequest request){
        System.out.println("11111");
        request.getSession().setAttribute("user","陈彬");
        return "index.html";
    }


}

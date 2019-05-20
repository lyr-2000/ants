package com.ants.controller;

import com.ants.entity.User;
import com.ants.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author czd
 */
@Controller
@RequestMapping(value = "/log")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/helloUser")
    public String helloUser() {

        return "log";
    }
}

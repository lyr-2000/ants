package com.ants.controller;

import com.ants.entity.User;
import com.ants.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author czd
 */
@Controller
@RequestMapping(value = "/log")
public class UserController {

    @RequestMapping(value = "/helloUser")
    @ResponseBody
    public Map<String, Object> helloUser() {
        Map<String, Object> ret = new HashMap<>();
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("content", 1);
        queryMap.put("offset", 2);
        queryMap.put("pageSize", 3);
        ret.put("rows", 4);
        ret.put("total", 4);
        return ret;
    }
}

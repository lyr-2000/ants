package com.ants.controller;

import com.ants.service.ClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author czd
 */
@Controller
@RequestMapping(value = "/ants/class")
public class HomePageController {

    @Autowired
    private ClassifyService classifyService;

    /**
     * 首页的商品大分类，导航栏的六个大分类那里
     * @return
     */
    @RequestMapping(value = "/classifyTest",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, String> classify(){
        Map<String,String> map = new HashMap<>();
        String classifyList = classifyService.findClassify();
        map.put("classification",classifyList);
        return map;
    }

}

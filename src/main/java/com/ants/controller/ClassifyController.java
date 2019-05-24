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
 * 大分类、小分类的Controller
 */
@Controller
@RequestMapping(value = "/ants/class")
public class ClassifyController {

    @Autowired
    private ClassifyService classifyService;

    /**
     * 首页的商品大分类，导航栏的六个大分类
     * @return
     */
    @RequestMapping(value = "/parentClassify",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, List<String>> parentClassify(){
        Map<String,List<String>> map = new HashMap<>();
        List<String> classifyList = classifyService.parentClassification();
        map.put("classification",classifyList);
        return map;
    }

}

package com.ants.controller;

import com.ants.service.ClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

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
     * 首页的点击所有分类功能的数据
     *
     * @return
     */
    @RequestMapping(value = "/allClassify", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, List<String>> childClassify() {
        Map allMap = new HashMap<>();
        //存放小分类的数组的列表
        List<List<String>> childList = new ArrayList<>();
        //获取大分类的ID
        List<Integer> parentClass = classifyService.parentClassId();
        //获取所有的大分类的数据信息
        List<String> parentClassification = classifyService.parentClassification();

        //根据大分类的ID获取对应的小分类的数据信息列表
        for (Integer parentId : parentClass) {
            List<String> childClassification = classifyService.childClassification(parentId);
            childList.add(childClassification);
        }
        allMap.put("parentClassification", parentClassification);
        allMap.put("childClassification", childList);

        return allMap;
    }

}

package com.ants.controller;

import com.ants.entity.Student;
import com.ants.service.ClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * @author czd
 * 这个Controller主要是存放一些与数据渲染有关的功能
 */
@Controller
@RequestMapping(value = "/ants/dataRendering")
public class DataRenderController {

    @Autowired
    private ClassifyService classifyService;

    /**
     * 首页的数据渲染
     *
     * @return
     */
    @RequestMapping(value = "/homePage", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, List<String>> homePage() {
        Map dataMap = new HashMap();

        //首页大分类的数据信息存放的列表
        List<String> parentClassification = classifyService.parentClassification();
        dataMap.put("parentClassification", parentClassification);

        //猜你喜欢商品信息存放列表
        List<Student> guessLikeList = new ArrayList<>();
        //最热闲置存放列表
        List<Student> hottestList = new ArrayList<>();
        //最新闲置存放列表
        List<Student> latestList = new ArrayList<>();
        //测试数据格式
        for (int i = 0; i < 2; i++) {
            Student student = new Student();
            student.setStudentId(i);
            student.setUserName("你好：" + i);
            guessLikeList.add(student);
            hottestList.add(student);
            latestList.add(student);
        }
        dataMap.put("guessLike", guessLikeList);
        dataMap.put("hottest",hottestList);
        dataMap.put("latest",latestList);
        return dataMap;
    }
}

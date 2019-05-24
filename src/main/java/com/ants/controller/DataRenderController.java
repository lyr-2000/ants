package com.ants.controller;

import com.ants.entity.Goods;
import com.ants.service.ClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        List<Goods> guessLikeList = new ArrayList<>();
        //最热闲置存放列表
        List<Goods> hottestList = new ArrayList<>();
        //最新闲置存放列表
        List<Goods> latestList = new ArrayList<>();
        //测试数据格式
        for (int i = 0; i < 2; i++) {
            Goods goods = new Goods();
            goods.setGoodsId(123456);
            goods.setGoodsName("helloWorld");
            goods.setGoodsPicture("1.jpg");
            goods.setGoodsPrice(43.5);

            guessLikeList.add(goods);
            hottestList.add(goods);
            latestList.add(goods);
        }
        dataMap.put("guessLike", guessLikeList);
        dataMap.put("hottest",hottestList);
        dataMap.put("latest",latestList);
        return dataMap;
    }
}

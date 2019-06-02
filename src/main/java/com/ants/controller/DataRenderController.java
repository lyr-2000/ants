package com.ants.controller;

import com.ants.entity.Announcement;
import com.ants.entity.ChildClass;
import com.ants.entity.Goods;
import com.ants.entity.ParentClass;
import com.ants.service.AnnouncementService;
import com.ants.service.ClassifyService;
import com.ants.service.GoodsService;
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

    @Autowired
    private AnnouncementService announcementService;

    @Autowired
    private GoodsService goodsService;

    /**
     * 跳转到首页一开始显示的数据渲染
     *
     * @return
     */
    @RequestMapping(value = "/homePage", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, List<String>> homePage() {
        Map dataMap = new HashMap();

        //首页大分类的数据信息存放的列表
        List<ParentClass> parentClassification = classifyService.parentClassification();
        dataMap.put("parentClassification", parentClassification);

        //最新的公告的数据渲染
        Announcement announcement = announcementService.latestAnnouncement();
        dataMap.put("announcement", announcement);

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
        dataMap.put("hottest", hottestList);
        dataMap.put("latest", latestList);
        return dataMap;
    }


    /**
     * 跳转到副页面的一开始显示的数据渲染
     *
     * @return
     */
    @RequestMapping(value = "/deputyPage", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, List<String>> deputyPage() {
        Map dataMap = new HashMap();

        //获取所有大分类名称，放在第一行的综合按钮的那一行
        List<ParentClass> parentClassificationHasOthers = classifyService.parentClassificationHasOthers();
        dataMap.put("synthesis", parentClassificationHasOthers);

        //获取所有的小分类的名称，放在第二行的综合按钮那一行
        List<ChildClass> allChildClassification = classifyService.allChildClassification();
        dataMap.put("composite", allChildClassification);

        //纵向全部大分类的数据
        List<ParentClass> allParentClassification = classifyService.parentClassificationHasOthers();
        dataMap.put("allClassification", allParentClassification);

        //随机获取16个商品的案例到副页面进行数据渲染
        Map<String, Integer> map = new HashMap<>();
        //获取所有商品的总数，拿来进行数据限制
        Integer goodsNumbers = goodsService.getGoodsNumbers();
        //获取16个随机商品的下标定位
        int head = (int) (Math.random() * goodsNumbers);
        int tail = head + 16;
        //将获取的限制数据的头和尾放进map中打包
        map.put("head", head);
        map.put("tail", tail);
        //获取16个随机商品数据信息
        List<Goods> goodsExample = goodsService.chooseExampleGoods(map);
        dataMap.put("goodsExample", goodsExample);

        //获取商品页面的页数
        int page = (goodsNumbers / 16) + 1;
        dataMap.put("page", page);

        return dataMap;
    }
}

package com.ants.controller.page;

import com.ants.constant.PageConsts;
import com.ants.entity.announcement.Announcement;
import com.ants.entity.classification.ChildClass;
import com.ants.entity.page.Goods;
import com.ants.entity.classification.ParentClass;
import com.ants.service.announcement.AnnouncementService;
import com.ants.service.classification.ClassifyService;
import com.ants.service.page.GoodsService;
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
 * 这个Controller主要是存放一些与数据渲染有关的功能
 * @Author czd
 * @Date:created in 2019/10/11
 * @Version: V1.0
 *
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

        Map<String,Integer> parameterMap =new HashMap<>();

        //首页大分类的数据信息存放的列表
        List<ParentClass> parentClassification = classifyService.listParentClassification();
        dataMap.put("parentClassification", parentClassification);

        parameterMap.put("head",0);
        parameterMap.put("tail",1);

        //最新的公告的数据渲染
        Announcement announcement = announcementService.getLatestAnnouncement(parameterMap);
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
        List<ParentClass> parentClassificationHasOthers = classifyService.listParentClassificationHasOthers();
        dataMap.put("synthesis", parentClassificationHasOthers);

        //获取所有的小分类的名称，放在第二行的综合按钮那一行
        List<ChildClass> allChildClassification = new ArrayList<>();//classifyService.allChildClassification();
        dataMap.put("composite", allChildClassification);

        //纵向全部大分类的数据
        List<ParentClass> allParentClassification = classifyService.listParentClassificationHasOthers();
        dataMap.put("allClassification", allParentClassification);

        //随机获取16个商品的案例到副页面进行数据渲染
        Map<String, Integer> map = new HashMap<>();
        //获取所有商品的总数，拿来进行数据限制
        Integer goodsNumbers = goodsService.countGoodsNumbers();
        //获取16个随机商品的下标定位
        int head = (int) (Math.random() * goodsNumbers);
//        int tail = head + 16;
        //将获取的限制数据的头和尾放进map中打包
        map.put("head", head);
        map.put("tail", PageConsts.CLASSIFY_PAGE_NUMBER);
        //获取16个随机商品数据信息
        List<Goods> goodsExample = goodsService.listExampleGoods(map);
        dataMap.put("goodsExample", goodsExample);

        //获取商品页面的页数
        int page = (goodsNumbers / PageConsts.CLASSIFY_PAGE_NUMBER) + 1;
        dataMap.put("page", page);

        return dataMap;
    }
}

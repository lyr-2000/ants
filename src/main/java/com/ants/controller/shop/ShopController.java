package com.ants.controller.shop;

import com.ants.entity.shop.Shop;
import com.ants.service.shop.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author czd
 * 存放交易箱相关操作的业务代码
 * 在Service、Dao、ServiceImpl对应着ShopService、ShopServiceDao、ShopServiceImpl
 */
@Controller
@RequestMapping(value = "/ants/tradeCase")
public class ShopController {
    //设置数据库每次获取数据的长度，即每个页面的数据量是多少条
    private final static Integer PAGENUMBERS = 8;

    @Autowired
    private ShopService shopService;


    /**
     * 根据此学生账号获取交易箱内的“我想买”和“我想卖”的商品的内容列表信息
     * @param request
     * @param type 查看状态,0 为我想买，1 为我想卖
     * @return
     */
    @RequestMapping(value = "/myCaseGoods",method = RequestMethod.GET)
    @ResponseBody
    public Map tradingCase(HttpServletRequest request,
                                               Integer type,
                                               Integer currentPage
    ){
        //存放最后返回给前端数据信息的map
        Map shopGoods = new HashMap<>();

        //用来保存tradingCase函数的参数的map
        Map<String,Integer> parameterMap = new HashMap<>();

        //设置map用来保存myShopGoodsNums方法中的参数信息
        Map<String, Integer> paramMap = new HashMap();

        //获取卖家ID
        Integer userId = 1;//(Integer) request.getSession().getAttribute("studentId");

        //保存tradingCase参数信息
        parameterMap.put("userId",userId);
        //保存myShopGoodsNums参数信息
        paramMap.put("userId", userId);


        //获取当前页数对应的数据库limit的head的值，以便获取对应数据库的限制输出的数据
        int head = (currentPage - 1) * 8;

        //获取当前页数对应的数据库limit的tail的值，以便获取对应数据库的限制输出的数据
//        int tail = head + 8;

        parameterMap.put("head",head);
        parameterMap.put("tail",PAGENUMBERS);


        /**
         * 根据前端传过来的shop获取status，判断是属于"想买"还是"想卖"，
         * 然后根据session获取卖家ID将status和卖家ID获取对应数据库交易箱的商品的信息
         */
        //保存此账号下我想买的所有物品信息
        List<Shop> buyList = null;

        //保存此账号下我想卖的所有物品信息
        List<Shop> sellList = null;

        //获取正在交易中的商品数量
        int goodsNumbers = 0;

        switch (type){
            case 0:
                //设置商品为我想买商品
                parameterMap.put("status",0);
                paramMap.put("status", 0);

                //获取此账号下我想买的所有物品信息
                buyList = shopService.tradingCase(parameterMap);

                //获取此账号下的我想买的商品的全部数量
                goodsNumbers = shopService.myShopGoodsNums(paramMap);
            break;

            case 1:
                //设置商品为我想卖商品
                parameterMap.put("status",1);
                paramMap.put("status", 1);

                //获取此账号下我想买的所有物品信息
                sellList = shopService.tradingCase(parameterMap);

                //获取此账号下的我想卖的商品的全部数量
                goodsNumbers = shopService.myShopGoodsNums(paramMap);
        }

        //获取总页数
        int allPage = (goodsNumbers / PAGENUMBERS) + 1;

        shopGoods.put("allPage",allPage);
        shopGoods.put("buyList",buyList);
        shopGoods.put("sellList",sellList);

        return shopGoods;
    }

}

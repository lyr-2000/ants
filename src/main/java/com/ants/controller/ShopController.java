package com.ants.controller;

import com.ants.entity.Shop;
import com.ants.service.ShopService;
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

    @Autowired
    private ShopService shopService;


    /**
     * 根据此学生账号获取交易箱内的“我想买”和“我想卖”的商品的内容列表信息
     * @param request
     * @param shop
     * @param status 查看状态,0 为我想买，1 为我想卖
     * @return
     */
    @RequestMapping(value = "/myCaseGoods",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, List<Shop>> tradingCase(HttpServletRequest request,
                                               Shop shop //,Integer status
    ){
        Map<String,List<Shop>> shopGoods = new HashMap<>();

        //获取卖家ID
        Integer userId = 1;//(Integer) request.getSession().getAttribute("studentId");
        //设置商品所属卖家的ID
        shop.setUserId(userId);

        /**
         * 根据前端传过来的shop获取status，判断是属于"想买"还是"想卖"，
         * 然后根据session获取卖家ID将status和卖家ID获取对应数据库交易箱的商品的信息
         */
        List<Shop> shopList = shopService.tradingCase(shop);

        shopGoods.put("shopList",shopList);

        return shopGoods;
    }

}

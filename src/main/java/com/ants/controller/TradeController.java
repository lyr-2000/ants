package com.ants.controller;

import com.ants.entity.Sell;
import com.ants.entity.Trade;
import com.ants.service.TradeService;
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
 * 正在交易中相关的代码均在此控制器
 */
@Controller
@RequestMapping(value = "/ants/trade")
public class TradeController {
    @Autowired
    private TradeService tradeService;

    /**
     * 根据学生学号获取此账号下正在交易的商品，包括闲置，租赁和赠送
     * @param request
     * @return
     */
    @RequestMapping(value = "/myTradeGoods",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, List<Trade>> myTradeGoods(HttpServletRequest request){
        Map<String,List<Trade>> tradeGoods = new HashMap<>();

        //获取学生的学号，即登录此账户的用户
        Integer studentId = 2;//(Integer)request.getSession().getAttribute("studentId");

        //获取此账号下所有正在交易中的所有的闲置，租赁和赠送的商品
        List<Trade> listTrade = tradeService.myTradeGoods(studentId);

        tradeGoods.put("listSell",listTrade);

        return tradeGoods;
    }
}

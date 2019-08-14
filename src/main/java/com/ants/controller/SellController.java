package com.ants.controller;

import com.ants.entity.Sell;
import com.ants.service.SellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.swing.event.ListDataEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author czd
 * 交易完成后相关的代码均在此控制器
 */
@Controller
@RequestMapping(value = "/ants/sell")
public class SellController {

    @Autowired
    private SellService sellService;

    /**
     * 根据学生学号获取此学生账号下的所交易完成的商品，包括闲置，租赁和赠送
     * @param request
     * @return
     */
    @RequestMapping(value = "/mySellGoods",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, List<Sell>> mySellGoods(HttpServletRequest request){
        Map<String,List<Sell>> sellGoods = new HashMap<>();

        //获取学生的学号，即登录此账户的用户
        Integer studentId = 1;//(Integer)request.getSession().getAttribute("studentId");

        //获取此账号下所交易完成的所有的闲置，租赁和赠送的商品
        List<Sell> listSell = sellService.mySellGoods(studentId);

        sellGoods.put("listSell",listSell);

        return sellGoods;
    }
}

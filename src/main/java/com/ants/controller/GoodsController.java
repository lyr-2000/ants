package com.ants.controller;

import com.ants.entity.Goods;
import com.ants.service.GoodsService;
import com.ants.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author czd
 */
@Controller
@RequestMapping(value = "/ants/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private StudentService studentService;

    /**
     *
     * @param goodsId
     * @return
     */
    @RequestMapping(value = "chooseGood",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Map<String,Object>> chooseGoodsById(@RequestParam(value = "goodsId") Integer goodsId){
        Map dataMap = new HashMap<>();
        //根据商品id获取单个商品的详细信息
        Map<String,Object> goodsInformation = goodsService.chooseGoodsById(goodsId);
        dataMap.put("information",goodsInformation);

        //根据此商品ID获取对应卖家的其他上架商品
        List<Goods> otherGoods = studentService.chooseGoodsByStudentId(goodsId);
        dataMap.put("otherGoods",otherGoods);
        return dataMap;
    }
}

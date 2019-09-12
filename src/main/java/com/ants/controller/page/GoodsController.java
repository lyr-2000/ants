package com.ants.controller.page;

import com.ants.entity.page.Goods;
import com.ants.service.page.GoodsService;
import com.ants.service.personal.StudentService;
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
 * @Author czd
 * @Date:created in 2019/10/11
 * @Version: V1.0
 */
@Controller
@RequestMapping(value = "/ants/goods")
public class GoodsController {


    @Autowired
    private GoodsService goodsService;

    @Autowired
    private StudentService studentService;

    /**
     * 获取单个商品的信息
     * @param goodsId
     * @return
     */
    @RequestMapping(value = "/chooseGood",method = RequestMethod.GET)
    @ResponseBody
    public Map chooseGoodsById(@RequestParam(value = "goodsId") Integer goodsId){
        //用来保存返回给前端数据的信息的map
        Map dataMap = new HashMap<>();

        if(goodsId == null){
            dataMap.put("error","商品信息获取错误!");
            return  dataMap;
        }

        //根据商品id获取单个商品的详细信息
        Map<String,Object> goodsInformation = goodsService.chooseGoodsById(goodsId);
        dataMap.put("singleGoodsMessage",goodsInformation);

        //根据此商品ID获取对应卖家的其他上架商品
        List<Goods> otherGoods = studentService.chooseGoodsByStudentId(goodsId);
        dataMap.put("otherGoods",otherGoods);
        
        Integer goodsNumbers =  studentService.countGoodsNumbers(goodsId);
        dataMap.put("otherGoodsNumbers",goodsNumbers);
        return dataMap;
    }
}

package com.ants.controller.commodity.give;

import com.ants.constant.PageConsts;
import com.ants.entity.commodity.give.GiveGoods;
import com.ants.service.commodity.give.GiveGoodsService;
import com.ants.util.ShopIdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 赠送相关的代码均在此控制器
 * @Author czd
 * @Date:created in 2019/10/11
 * @Version: V1.0
 *
 */
@Controller
@RequestMapping(value = "/ants/giveGoods")
public class GiveGoodsController {


    @Autowired
    private GiveGoodsService giveGoodsService;


    /**
     * 发布赠送功能
     *
     * @param photo
     * @param request
     * @param
     * @return
     */
    @RequestMapping(value = "/releaseGive", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> releaseGive(//@RequestParam MultipartFile photo,
                                           HttpServletRequest request,
                                           GiveGoods give
    ) {
        //用来保存返回给前端数据的map
        Map<String, String> uploadGive = new HashMap<>();

        //生产商品订单号
        String shopId = ShopIdUtil.getShopIdByUUID();
        //将生成的Stringl类型的商品订单号转换为Int类型
        Integer giveId = Integer.parseInt(shopId);

        //设置赠送商品的订单号
        give.setGoodsId(giveId);

        //设置赠送商品交易状态为未交易
        give.setGoodsState(0);

        //获取卖家ID
        Integer studentId = (Integer) request.getSession().getAttribute("studentId");
        if (studentId == null){
            uploadGive.put("error","用户未登录!");
            return uploadGive;
        }

        //设置商品所属卖家的ID
        give.setGoodsBelong(studentId);

        //获取上传商品的时间
        Date date = new Date();
        //设置时间的格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String uploadTime = simpleDateFormat.format(date);
        //设置商品上传时间
        give.setUploadTime(uploadTime);

        //将商品信息添加到数据库中
        int result = giveGoodsService.insertGiveGoods(give);
        //判断数据添加进数据库是否成功
        if (result > 0) {
            uploadGive.put("releaseStatus", "success");
        } else {
            uploadGive.put("releaseStatus", "fail");
        }

        //上传图片
//        uploadIdle = Upload.uploadPhoto(photo, request);

        return uploadGive;
    }

    /**
     * 根据学生账户获取此学生发布的所有的赠送的商品，我的赠送
     * @param request
     * @return
     */
    @RequestMapping(value = "/myGiveGoods", method = RequestMethod.GET)
    @ResponseBody
    public Map myGiveGoods(HttpServletRequest request) {
        //保存返回给前端的数据信息
        Map giveGoods = new HashMap<>();

        //用来存储myGiveGoods方法中的参数数据
        Map<String,Integer> parameterMap = new HashMap<>();

        //获取学生的学号，即登录此账户的用户
        Integer studentId = (Integer)request.getSession().getAttribute("studentId");
        if (studentId == null){
            giveGoods.put("error","用户未登录!");
            return giveGoods;
        }else{
            parameterMap.put("goodsBelong",studentId);
        }

        //设置数据库SQL语句中Limit关键字中的参数信息
        parameterMap.put("head",0);
        parameterMap.put("tail", PageConsts.COMMODITY_PAGE_NUMBER);

        //获取此账号下赠送的所有物品信息
        List<GiveGoods> giveList = giveGoodsService.listMyGiveGoods(parameterMap);

        giveGoods.put("giveGoods",giveList);

        return giveGoods;
    }


}

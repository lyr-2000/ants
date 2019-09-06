package com.ants.controller.give;

import com.ants.entity.give.Give;
import com.ants.service.give.GiveService;
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
 * @author czd
 * 赠送相关的代码均在此控制器
 */
@Controller
@RequestMapping(value = "/ants/give")
public class GiveController {

    @Autowired
    private GiveService giveService;


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
                                           Give give
    ) {
        Map<String, String> uploadGive = new HashMap<>();

        //生产商品订单号
        String shopId = ShopIdUtil.getShopIdByUUID();
        Integer giveId = Integer.parseInt(shopId);

        //设置赠送商品的订单号
        give.setGoodsId(giveId);

        //设置赠送商品交易状态为未交易
        give.setGoodsState(0);
        //获取卖家ID
        Integer studentId = 2;//(Integer) request.getSession().getAttribute("studentId");
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
        int result = giveService.addGiveGoods(give);
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
    public Map<String, List<Give>> myGiveGoods(HttpServletRequest request) {
        //保存返回给前端的数据信息
        Map<String, List<Give>> giveGoods = new HashMap<>();

        //获取学生的学号，即登录此账户的用户
        Integer studentId = 1;//(Integer)request.getSession().getAttribute("studentId");

        //获取此账号下赠送的所有物品信息
        List<Give> giveList = null;//giveService.myGiveGoods(studentId);

        giveGoods.put("giveGoods",giveList);

        return giveGoods;
    }


}

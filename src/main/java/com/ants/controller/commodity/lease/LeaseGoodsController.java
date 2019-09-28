package com.ants.controller.commodity.lease;

import com.ants.constant.PageConsts;
import com.ants.entity.commodity.lease.LeaseGoods;
import com.ants.service.commodity.lease.LeaseGoodsService;
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
 * 租赁相关的代码均在此控制器
 * @Author czd
 * @Date:created in 2019/10/11
 * @Version: V1.0
 *
 */
@Controller
@RequestMapping(value = "/ants/leaseGoods")
public class LeaseGoodsController {

    @Autowired
    private LeaseGoodsService leaseGoodsService;


    /**
     * 发布租赁功能
     *
     * @param photo
     * @param request
     * @param lease
     * @return
     */
    @RequestMapping(value = "/releaseLease", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> releaseLease(//@RequestParam MultipartFile photo,
                                            HttpServletRequest request,
                                            LeaseGoods lease
    ) {
        Map<String, String> uploadLease = new HashMap<>();

        //生产商品订单号
        String shopId = ShopIdUtil.getShopIdByUUID();
        Integer leaseId = Integer.parseInt(shopId);
        //设置商品的订单号
        lease.setGoodsId(leaseId);

        //设置商品交易状态为未租赁
        lease.setGoodsState(0);
        //获取卖家ID
        Integer studentId = (Integer) request.getSession().getAttribute("studentId");
        if (studentId != null){
            //设置商品所属卖家的ID
            lease.setGoodsBelong(studentId);
        }else{
            uploadLease.put("error","用户未登录!");
            return uploadLease;
        }



        //获取上传商品的时间
        Date date = new Date();
        //设置时间的格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String uploadTime = simpleDateFormat.format(date);
        //设置商品上传时间
        lease.setUploadTime(uploadTime);

        //将商品信息添加到数据库中
        int result = leaseGoodsService.insertLeaseGoods(lease);
        if (result > 0) {
            uploadLease.put("releaseStatus", "success");
        } else {
            uploadLease.put("releaseStatus", "fail");
        }


        //上传图片
//        uploadIdle = Upload.uploadPhoto(photo, request);
        return uploadLease;
    }

    /**
     * 根据学生账户获取此学生发布的所有的租赁的商品，我的租赁
     * @param request
     * @return
     */
    @RequestMapping(value = "/myLeaseGoods", method = RequestMethod.GET)
    @ResponseBody
    public Map myLeaseGoods(HttpServletRequest request) {
        //保存返回给前端数据的信息
        Map leaseGoods = new HashMap<>();

        //用来存储myIdleGoods方法中的参数数据
        Map<String,Integer> parameterMap = new HashMap<>();

        //获取学生的学号，即登录此账户的用户
        Integer studentId = (Integer)request.getSession().getAttribute("studentId");
        if (studentId == null){
            leaseGoods.put("error","用户未登录!");
            return leaseGoods;

        }else{
            parameterMap.put("goodsBelong",studentId);
        }

        //设置数据库SQL语句中Limit关键字中的参数信息
        parameterMap.put("head",0);
        parameterMap.put("tail", PageConsts.COMMODITY_PAGE_NUMBER);

        //获取此账号下租赁的所有物品信息
        List<LeaseGoods> leaseList = leaseGoodsService.listMyLeaseGoods(parameterMap);

        leaseGoods.put("leaseList",leaseList);

        return leaseGoods;
    }
}

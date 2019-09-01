package com.ants.controller;

import com.ants.dao.IdleDao;
import com.ants.entity.ChildClass;
import com.ants.entity.Goods;
import com.ants.entity.ParentClass;
import com.ants.service.ClassifyService;
import com.ants.service.GoodsService;
import com.ants.service.IdleService;
import com.ants.util.ShopIdUtil;
import com.ants.util.Upload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author czd
 * 闲置相关的代码均在此控制器
 */
@Controller
@RequestMapping(value = "/ants/idle")
public class IdleController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private ClassifyService classifyService;

    @Autowired
    private IdleService idleService;

    /**
     * 发布闲置功能
     *
     * @param photo
     * @param request
     * @param goods
     * @return
     */
    @RequestMapping(value = "/releaseIdle", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> releaseIdle(//@RequestParam MultipartFile photo,
                                           HttpServletRequest request,
                                           Goods goods
    ) {
        Map<String, String> uploadIdle = new HashMap<>();

        //生产商品订单号
        String shopId = ShopIdUtil.getShopIdByUUID();
        Integer goodsId = Integer.parseInt(shopId);

        //设置商品的订单号
        goods.setGoodsId(goodsId);

        //设置商品交易状态为未交易
        goods.setGoodsState(0);
        //获取卖家ID
        Integer studentId = 1;//(Integer) request.getSession().getAttribute("studentId");
        //设置商品所属卖家的ID
        goods.setGoodsBelong(studentId);

        //获取上传商品的时间
        Date date = new Date();
        //设置时间的格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String uploadTime = simpleDateFormat.format(date);
        //设置商品上传时间
        goods.setUploadTime(uploadTime);

        //将商品信息添加到数据库中
        int result = goodsService.addGoods(goods);
        if (result > 0) {
            uploadIdle.put("status", "success");
        } else {
            uploadIdle.put("status", "fail");
        }


        //上传图片
//        uploadIdle = Upload.uploadPhoto(photo, request);
        return uploadIdle;
    }


    /**
     * 动态获取大分类信息，根据大分类对应ID获取小分类的信息
     * @param state
     * @param request
     * @return
     */
    @RequestMapping(value = "/getClass", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, List> getClassifyParentAndChild(@RequestParam(value = "state") int state,
                                                       HttpServletRequest request) {
        Map<String, List> data = new HashMap<>();

        //根据状态判断是获取父类分类信息还是子类分类信息，1代表父类，2代表子类
        switch (state) {
            case 1:
                //将父类的分类情况发送到前端界面
                List<ParentClass> parentClasses = classifyService.parentClassificationHasOthers();
                data.put("parentClass", parentClasses);
                break;
            case 2:
                //获取前端对应的父类的id
                String parentId = request.getParameter("parentClass");
                Integer parentClass = null;
                if (!"".equals(parentId)) {
                    parentClass = Integer.parseInt(parentId);
                }
                //根据父类id获取对应的子类分类情况
                List<ChildClass> childClass = classifyService.childClassification(parentClass);
                data.put("childClass", childClass);
                break;

        }
        return data;
    }


    /**
     * 根据学生账户获取此学生发布的所有的闲置的商品，我的闲置
     * @param request
     * @return
     */
    @RequestMapping(value = "/myIdleGoods", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, List<Goods>> myIdleGoods(HttpServletRequest request) {
        Map<String, List<Goods>> idleGoods = new HashMap<>();

        //获取学生的学号，即登录此账户的用户
        Integer studentId = 1;//(Integer)request.getSession().getAttribute("studentId");

        //获取此账号下闲置的所有物品信息
        List<Goods> idleList = null;//idleService.myIdleGoods(studentId,1,2);

        idleGoods.put("idleList",idleList);

        return idleGoods;
    }
}

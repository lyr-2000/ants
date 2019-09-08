package com.ants.controller.idle;

import com.ants.entity.classification.ChildClass;
import com.ants.entity.page.Goods;
import com.ants.entity.classification.ParentClass;
import com.ants.service.classification.ClassifyService;
import com.ants.service.page.GoodsService;
import com.ants.service.idle.IdleService;
import com.ants.util.ShopIdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    //每页商品的数量
    private static final Integer PAGENUMBER = 8;

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
        //用来保存返回给前端数据的map
        Map<String, String> uploadIdle = new HashMap<>();

        //获取卖家ID
        Integer studentId = (Integer) request.getSession().getAttribute("studentId");

        if (studentId == null) {
            uploadIdle.put("error", "用户未登录!");
            return uploadIdle;
        }

        //设置商品所属卖家的ID
        goods.setGoodsBelong(studentId);

        //生产商品订单号
        String shopId = ShopIdUtil.getShopIdByUUID();
        //将生成的String类型的订单号转换成Int类型
        Integer goodsId = Integer.parseInt(shopId);

        //设置商品的订单号
        goods.setGoodsId(goodsId);

        //设置商品交易状态为未交易
        goods.setGoodsState(0);


        //获取上传商品的时间
        Date date = new Date();
        //设置时间的格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String uploadTime = simpleDateFormat.format(date);
        //设置商品上传时间
        goods.setUploadTime(uploadTime);

        //将商品信息添加到数据库中
        int result = goodsService.addGoods(goods);
        //判断是否将数据添加进数据库
        if (result > 0) {
            uploadIdle.put("releaseStatus", "success");
        } else {
            uploadIdle.put("releaseStatus", "fail");
        }


        //上传图片
//        uploadIdle = Upload.uploadPhoto(photo, request);
        return uploadIdle;
    }


    /**
     * 动态获取大分类信息，根据大分类对应ID获取小分类的信息
     *
     * @param classifyStatus
     * @param request
     * @return
     */
    @RequestMapping(value = "/getClass", method = RequestMethod.GET)
    @ResponseBody
    public Map getClassifyParentAndChild(
            @RequestParam(value = "classifyStatus") int classifyStatus,
            HttpServletRequest request
    ) {
        //用来保存返回给前端数据的map
        Map data = new HashMap<>();

        if (classifyStatus < 0) {
            data.put("error", "分类状态码错误!");
            return data;
        }

        //根据状态判断是获取父类分类信息还是子类分类信息，1代表父类，2代表子类
        switch (classifyStatus) {
            case 1:
                //将父类的分类情况发送到前端界面
                List<ParentClass> parentClasses = classifyService.parentClassificationHasOthers();
                data.put("parentClass", parentClasses);
                break;
            case 2:
                //获取前端对应的父类的id
                String parentId = request.getParameter("parentClass");

                Integer parentClass = null;

                //对传过来的大分类ID进行空值判断
                if (parentId != null && !"".equals(parentId)) {
                    parentClass = Integer.parseInt(parentId);
                } else {
                    data.put("error", "大分类ID获取错误!");
                    return data;
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
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/myIdleGoods", method = RequestMethod.GET)
    @ResponseBody
    public Map myIdleGoods(HttpServletRequest request) {
        //用来存储myIdleGoods方法中的参数数据
        Map<String,Integer> parameterMap = new HashMap<>();

        //保存返回给前端的数据信息
        Map idleGoods = new HashMap<>();

        //获取学生的学号，即登录此账户的用户
        Integer studentId = (Integer)request.getSession().getAttribute("studentId");
        if (studentId != null){
            parameterMap.put("goodsBelong",studentId);

        }else{
            idleGoods.put("error","用户未登录!");
            return idleGoods;
        }

        //设置数据库SQL语句中Limit关键字中的参数信息
        parameterMap.put("head",0);
        parameterMap.put("tail",PAGENUMBER);

        //获取此账号下闲置的所有物品信息
        List<Goods> idleList = idleService.myIdleGoods(parameterMap);

        idleGoods.put("idleList", idleList);

        return idleGoods;
    }
}

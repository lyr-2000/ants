package com.ants.controller.seek;

import com.ants.entity.seek.Seek;
import com.ants.service.seek.SeekService;
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
 * 寻求相关的代码均在此控制器
 * @Author czd
 * @Date:created in 2019/10/11
 * @Version: V1.0
 *
 */
@Controller
@RequestMapping(value = "/ants/seek")
public class SeekController {
    //设置每页商品数量有多少个商品
    private final static Integer PAGENUMBERS = 16;

    @Autowired
    private SeekService seekService;

    /**
     * 根据学生账户获取此学生发布的所有的租赁的商品，我的租赁
     * @param request
     * @return
     */
    @RequestMapping(value = "/mySeekGoods", method = RequestMethod.GET)
    @ResponseBody
    public Map mySeekGoods(HttpServletRequest request) {
        //用来存储mySeekGoods方法中的参数数据
        Map<String,Integer> parameterMap = new HashMap<>();
        //保存返回给前端数据的信息
        Map seekGoods = new HashMap<>();

        //获取学生的学号，即登录此账户的用户
        Integer studentId = (Integer)request.getSession().getAttribute("studentId");
        if (studentId != null){
            parameterMap.put("goodsBelong",studentId);
        }else{
            seekGoods.put("error","用户未登录!");
            return seekGoods;

        }

        //设置数据库SQL语句中Limit关键字中的参数信息
        parameterMap.put("head",0);
        parameterMap.put("tail",PAGENUMBERS);

        //获取此账号下寻求的所有物品信息，我的寻求
        List<Seek> seekList = seekService.mySeekGoods(parameterMap);

        seekGoods.put("seekList",seekList);

        return seekGoods;
    }

    /**
     * 发布寻求功能
     *
     * @param photo
     * @param request
     * @param seek
     * @return
     */
    @RequestMapping(value = "/releaseSeek", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> releaseSeek(//@RequestParam MultipartFile photo,
                                            HttpServletRequest request,
                                            Seek seek
    ) {
        Map<String, String> uploadSeek = new HashMap<>();

        //生产商品订单号
        String shopId = ShopIdUtil.getShopIdByUUID();
        Integer seekId = Integer.parseInt(shopId);


        //获取上传商品的时间
        Date date = new Date();
        //设置时间的格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String uploadTime = simpleDateFormat.format(date);
        //设置商品上传时间
        seek.setUploadTime(uploadTime);

        //设置商品交易状态为未租赁
        seek.setGoodsState(0);
        //获取卖家ID
        Integer studentId = (Integer) request.getSession().getAttribute("studentId");
        if (studentId == null){
            uploadSeek.put("error","用户未登录!");
            return  uploadSeek;
        }else{
            //设置商品所属卖家的ID
            seek.setGoodsBelong(studentId);
        }


        //设置商品的订单号
        seek.setGoodsId(seekId);


        //将商品信息添加到数据库中
        int result = seekService.addSeekGoods(seek);
        if (result > 0) {
            uploadSeek.put("releaseStatus", "success");
        } else {
            uploadSeek.put("releaseStatus", "fail");
        }


        //上传图片
//        uploadIdle = Upload.uploadPhoto(photo, request);
        return uploadSeek;
    }

}

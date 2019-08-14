package com.ants.controller;

import com.ants.entity.Goods;
import com.ants.entity.Lease;
import com.ants.service.LeaseService;
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
 * 租赁相关的代码均在此控制器
 */
@Controller
@RequestMapping(value = "/ants/lease")
public class LeaseController {

    @Autowired
    private LeaseService leaseService;

    /**
     * 根据学生账户获取此学生发布的所有的租赁的商品
     * @param request
     * @return
     */
    @RequestMapping(value = "/myLeaseGoods", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, List<Lease>> myLeaseGoods(HttpServletRequest request) {
        Map<String, List<Lease>> leaseGoods = new HashMap<>();

        //获取学生的学号，即登录此账户的用户
        Integer studentId = 2;//(Integer)request.getSession().getAttribute("studentId");

        //获取此账号下租赁的所有物品信息
        List<Lease> leaseList = leaseService.myLeaseGoods(studentId);

        leaseGoods.put("leaseList",leaseList);

        return leaseGoods;
    }
}

package com.ants.controller;

import com.ants.entity.*;
import com.ants.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author czd
 */
@Controller
@RequestMapping(value = "/ants/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private IdleService idleService;

    @Autowired
    private LeaseService leaseService;

    @Autowired
    private SeekService seekService;

    @Autowired
    private GiveService giveService;


    /**
     * 根据学生学号获取学生信息，个人资料
     *
     * @return
     */
    @RequestMapping(value = "/getStuMessage", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Student> getStudentMessage(HttpServletRequest request) {
        Map<String, Student> data = new HashMap<>();
        //这个是Session获取学生学号
        HttpSession session = request.getSession();
        session.setAttribute("studentId", 1);
        Integer studentId = (Integer) session.getAttribute("studentId");
        //根据学生学号获取学生信息
        Student stuMessage = studentService.getStudentMessage(studentId);

        data.put("stuMessage", stuMessage);

        return data;
    }


    /**
     * 编辑我的资料，然后保存个人信息
     *
     * @param student
     * @param request
     * @return
     */
    @RequestMapping(value = "/saveStuMessage", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> saveStuMessage(Student student,
                                              HttpServletRequest request
    ) {
        Map<String, String> stuMessage = new HashMap<>();

        //获取卖家ID
        Integer studentId = 1;//(Integer) request.getSession().getAttribute("studentId");
        //设置商品所属卖家的ID
        student.setStudentId(studentId);

        //保存编辑好的我的资料的信息，将其添加到数据库中
        int result = studentService.saveStuMessage(student);

        if (result > 0) {
            stuMessage.put("status", "success");
        } else {
            stuMessage.put("status", "fail");
        }
        return stuMessage;
    }


    /**
     * 在我的资料中，获取我的闲置，我的租赁，我的寻求，我的赠送的商品的列表
     * state 中 1代表我的闲置，2代表我的租赁，3代表我的寻求，4代表我的赠送
     * 举例：当state为1（代表我的闲置），后端返回数据中我的闲置那一块存在数据，其他部分的数据为空
     *
     * @param request
     * @param state
     * @param currentPage
     * @return
     */
    @RequestMapping(value = "/myTradingSituation", method = RequestMethod.GET)
    @ResponseBody
    public Map myTradingSituation(HttpServletRequest request,
                                  int state,
                                  int currentPage) {
        Map goodsList = new HashMap();

        //获取学生的学号，即登录此账户的用户
        Integer studentId = 1;//(Integer)request.getSession().getAttribute("studentId");

        //保存此账号下闲置的所有物品信息
        List<Goods> idleList = null;

        //保存此账号下租赁的所有物品信息
        List<Lease> leaseList = null;

        //保存此账号下赠送的所有物品信息
        List<Give> giveList = null;

        //保存此账号下寻求的所有物品信息，我的寻求
        List<Seek> seekList = null;

        //获取当前页数对应的数据库limit的head的值，以便获取对应数据库的限制输出的数据
        int head = (currentPage - 1) * 8;

        //获取当前页数对应的数据库limit的tail的值，以便获取对应数据库的限制输出的数据
        int tail = head + 8;

        //设置map用来保存myIdleGoods方法中的参数信息
        Map<String, Integer> parameterMap = new HashMap();

        //保存参数信息
        parameterMap.put("goodsBelong", studentId);
        parameterMap.put("head", head);
        parameterMap.put("tail", tail);

        int goodsNumbers = 0;

        switch (state) {

            case 1:
                //获取此账号下闲置的所有物品信息
                idleList = idleService.myIdleGoods(parameterMap);

                //获取此账号下的闲置商品的全部数量
                goodsNumbers = idleService.myIdleGoodsNums(studentId);
                break;


            case 2:
                //获取此账号下租赁的所有物品信息
                leaseList = leaseService.myLeaseGoods(parameterMap);

                //获取此账号下的租赁商品的全部数量
                goodsNumbers = leaseService.myLeaseGoodsNums(studentId);
                break;


            case 3:
                //获取此账号下赠送的所有物品信息
                giveList = giveService.myGiveGoods(parameterMap);

                //获取此账号下的租赁商品的全部数量
                goodsNumbers = giveService.myGiveGoodsNums(studentId);
                break;


            case 4:
                //获取此账号下寻求的所有物品信息，我的寻求
                seekList = seekService.mySeekGoods(parameterMap);

                //获取此账号下的租赁商品的全部数量
                goodsNumbers = seekService.mySeekGoodsNums(studentId);
                break;
        }

        //获取总页数
        int allPage = (goodsNumbers / 8) + 1;

        goodsList.put("allPage",allPage);
        goodsList.put("giveList", giveList);
        goodsList.put("leaseList", leaseList);
        goodsList.put("idleList", idleList);
        goodsList.put("seekList", seekList);

        return goodsList;
    }

}

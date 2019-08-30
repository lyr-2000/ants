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
     * @return
     */
    @RequestMapping(value = "/getStuMessage",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Student> getStudentMessage(HttpServletRequest request){
        Map<String ,Student> data = new HashMap<>();
        //这个是Session获取学生学号
        HttpSession session = request.getSession();
        session.setAttribute("studentId",1);
        Integer studentId = (Integer) session.getAttribute("studentId");
        //根据学生学号获取学生信息
        Student stuMessage = studentService.getStudentMessage(studentId);

        data.put("stuMessage",stuMessage);

        return data;
    }

    /**
     * 编辑我的资料，然后保存个人信息
     * @param student
     * @param request
     * @return
     */
    @RequestMapping(value = "/saveStuMessage",method = RequestMethod.POST)
    @ResponseBody
    public Map<String ,String> saveStuMessage(Student student,
                                              HttpServletRequest request
    ){
        Map<String,String> stuMessage = new HashMap<>();

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
     * @param request
     * @return
     */
    @RequestMapping(value = "/myTradingSituation",method = RequestMethod.GET)
    @ResponseBody
    public Map myTradingSituation(HttpServletRequest request){
        Map goodsList = new HashMap();

        //获取学生的学号，即登录此账户的用户
        Integer studentId = 1;//(Integer)request.getSession().getAttribute("studentId");

        //获取此账号下闲置的所有物品信息
        List<Goods> idleList = idleService.myIdleGoods(studentId);

        //获取此账号下租赁的所有物品信息
        List<Lease> leaseList = leaseService.myLeaseGoods(studentId);

        //获取此账号下赠送的所有物品信息
        List<Give> giveList = giveService.myGiveGoods(studentId);

        //获取此账号下寻求的所有物品信息，我的寻求
        List<Seek> seekList = seekService.mySeekGoods(studentId);

        goodsList.put("giveList",giveList);
        goodsList.put("leaseList",leaseList);
        goodsList.put("idleList",idleList);
        goodsList.put("seekList",seekList);

        return goodsList;
    }

}

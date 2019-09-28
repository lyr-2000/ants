package com.ants.controller.personal;

import com.ants.constant.PageConsts;
import com.ants.entity.commodity.give.GiveGoods;
import com.ants.entity.commodity.lease.LeaseGoods;
import com.ants.entity.page.Goods;
import com.ants.entity.personal.Student;
import com.ants.entity.commodity.seek.SeekGoods;
import com.ants.service.commodity.give.GiveGoodsService;
import com.ants.service.commodity.idle.IdleGoodsService;
import com.ants.service.commodity.lease.LeaseGoodsService;
import com.ants.service.personal.StudentService;
import com.ants.service.commodity.seek.SeekGoodsService;
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
 * @Author czd
 * @Date:created in 2019/10/11
 * @Version: V1.0
 */
@Controller
@RequestMapping(value = "/ants/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private IdleGoodsService idleService;

    @Autowired
    private LeaseGoodsService leaseService;

    @Autowired
    private SeekGoodsService seekService;

    @Autowired
    private GiveGoodsService giveService;


    /**
     * 根据学生学号获取学生信息，个人资料
     *
     * @return
     */
    @RequestMapping(value = "/getStuMessage", method = RequestMethod.GET)
    @ResponseBody
    public Map getStudentMessage(HttpServletRequest request) {
        Map data = new HashMap<>();
        //这个是Session获取学生学号
        HttpSession session = request.getSession();
//        session.setAttribute("studentId", 1);
        Integer studentId = (Integer) session.getAttribute("studentId");

        if (studentId == null){
            data.put("error","用户未登录!");
            return  data;
        }

        //根据学生学号获取学生信息
        Student stuMessage = studentService.getStudentMessage(studentId);

        data.put("stuMessage", stuMessage);

        return data;
    }


    /**
     * 编辑我的资料，然后保存个人信息
     * @param portrait
     * @param student
     * @param request
     * @return
     */
    @RequestMapping(value = "/saveStuMessage", method = RequestMethod.PUT)
    @ResponseBody
    public Map<String, String> saveStuMessage(//@RequestParam MultipartFile portrait,
                                              Student student,
                                              HttpServletRequest request
    ) {
        Map<String, String> stuMessage = new HashMap<>();

        //获取卖家ID
        HttpSession session = request.getSession();
        Integer studentId = (Integer)session.getAttribute("studentId");
        if (studentId != null){
            //设置商品所属卖家的ID
            student.setStudentId(studentId);
        }else{
            stuMessage.put("error","用户未登录!");
            return  stuMessage;
        }


        //保存编辑好的我的资料的信息，将其添加到数据库中
        int result = studentService.updateStuMessage(student);

        //上传图片
//        uploadIdle = Upload.uploadPhoto(portrait, request);

        if (result > 0) {
            stuMessage.put("saveStatus", "success");
        } else {
            stuMessage.put("saveStatus", "fail");
        }
        return stuMessage;
    }


    /**
     * 在我的资料中，获取我的闲置，我的租赁，我的寻求，我的赠送的商品的列表
     * state 中 1代表我的闲置，2代表我的租赁，3代表我的寻求，4代表我的赠送
     * 举例：当state为1（代表我的闲置），后端返回数据中我的闲置那一块存在数据，其他部分的数据为空
     *
     * @param request
     * @param type
     * @param currentPage
     * @return
     */
    @RequestMapping(value = "/myTradingSituation", method = RequestMethod.GET)
    @ResponseBody
    public Map myTradingSituation(HttpServletRequest request,
                                  @RequestParam(value = "type") int type,
                                  @RequestParam(value = "currentPage") int currentPage) {
        //用来保存返回给前端数据的信息的map
        Map goodsList = new HashMap();
        if (type < 0){
            goodsList.put("error","信息类型传输错误");
            return goodsList;
        }

        //获取学生的学号，即登录此账户的用户
        Integer studentId = (Integer)request.getSession().getAttribute("studentId");
        if (studentId == null){
            goodsList.put("error","用户未登录!");
            return goodsList;
        }
        if (currentPage < 1){
            goodsList.put("error","页面数据传输错误");
            return goodsList;
        }

        //保存此账号下闲置的所有物品信息
        List<Goods> idleList = null;

        //保存此账号下租赁的所有物品信息
        List<LeaseGoods> leaseList = null;

        //保存此账号下赠送的所有物品信息
        List<GiveGoods> giveList = null;

        //保存此账号下寻求的所有物品信息，我的寻求
        List<SeekGoods> seekList = null;

        //获取当前页数对应的数据库limit的head的值，以便获取对应数据库的限制输出的数据
        int head = (currentPage - 1) * PageConsts.COMMODITY_PAGE_NUMBER;

        //获取当前页数对应的数据库limit的tail的值，以便获取对应数据库的限制输出的数据
//        int tail = head + 8;

        //设置map用来保存myIdleGoods方法中的参数信息
        Map<String, Integer> parameterMap = new HashMap();

        //保存参数信息
        parameterMap.put("goodsBelong", studentId);
        //设置数据库SQL语句中Limit关键字中的参数信息
        parameterMap.put("head", head);
        parameterMap.put("tail", PageConsts.COMMODITY_PAGE_NUMBER);

        int goodsNumbers = 0;

        switch (type) {

            case 1:
                //获取此账号下闲置的所有物品信息
                idleList = idleService.listMyIdleGoods(parameterMap);

                //获取此账号下的闲置商品的全部数量
                goodsNumbers = idleService.countMyIdleGoodsNums(studentId);
                break;


            case 2:
                //获取此账号下租赁的所有物品信息
                leaseList = leaseService.listMyLeaseGoods(parameterMap);

                //获取此账号下的租赁商品的全部数量
                goodsNumbers = leaseService.countMyLeaseGoodsNums(studentId);
                break;


            case 3:
                //获取此账号下赠送的所有物品信息
                giveList = giveService.listMyGiveGoods(parameterMap);

                //获取此账号下的租赁商品的全部数量
                goodsNumbers = giveService.countMyGiveGoodsNums(studentId);
                break;


            case 4:
                //获取此账号下寻求的所有物品信息，我的寻求
                seekList = seekService.listMySeekGoods(parameterMap);

                //获取此账号下的租赁商品的全部数量
                goodsNumbers = seekService.countMySeekGoodsNums(studentId);
                break;
        }

        //获取总页数
        int allPage = (goodsNumbers / PageConsts.COMMODITY_PAGE_NUMBER) + 1;

        goodsList.put("allPage",allPage);
        goodsList.put("giveList", giveList);
        goodsList.put("leaseList", leaseList);
        goodsList.put("idleList", idleList);
        goodsList.put("seekList", seekList);

        return goodsList;
    }

}

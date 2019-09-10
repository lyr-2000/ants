package com.ants.controller.announcement;

import com.ants.entity.announcement.Announcement;
import com.ants.service.announcement.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author czd
 * 用于公告类型的业务代码
 */
@Controller
@RequestMapping(value = "/ants/announcement")
public class AnnouncementController {
    //每页商品的数量
    private static final Integer PAGENUMBER = 10;

    @Autowired
    private AnnouncementService announcementService;

    @RequestMapping(value = "/getAnnList",method = RequestMethod.POST)
    @ResponseBody
    public Map getAnnouncementList(@RequestParam("currentPage") Integer currentPage){
        //用来保存返回给前端信息的数据的map
        Map announcementMap = new HashMap();

        //用来存储myIdleGoods方法中的参数数据
        Map<String,Integer> parameterMap = new HashMap<>();

        if (currentPage < 0){
            announcementMap.put("error","页面数传输错误!");
            return announcementMap;
        }
        //获取当前页数对应的数据库limit的head的值，以便获取对应数据库的限制输出的数据
        int head = (currentPage - 1) * 8;

        //设置数据库SQL语句中Limit关键字中的参数信息
        parameterMap.put("head", head);
        parameterMap.put("tail", PAGENUMBER);

        //根据页面数获取对应的数据库的公告的数据信息
        List<Announcement> announcementList = announcementService.getAnnouncementList(parameterMap);

        announcementMap.put("announcementList",announcementList);

        return announcementMap;
    }

    /**
     * 根据公告的id获取对应的公告的详细信息
     * @param annId
     * @return
     */
    @RequestMapping(value = "/getAnnDetail",method = RequestMethod.POST)
    @ResponseBody
    public Map getAnnDetail(@RequestParam(value = "annId") Integer annId){
        //保存返回给前端的数据的map
        Map detailMap = new HashMap();

        if (annId == null || annId < 0 ) {
            detailMap.put("error","参数传输错误!");
            return detailMap;
        }

        //根据公告的id获取对应公告的信息
        Announcement announcement = announcementService.getAnnDetail(annId);

        detailMap.put("annDetail",announcement);


        return detailMap;

    }
}

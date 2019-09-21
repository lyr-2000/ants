package com.ants.controller.announcement;

import com.ants.constant.PageConsts;
import com.ants.entity.announcement.Announcement;
import com.ants.service.announcement.AnnouncementService;
import com.ants.util.InterceptUtil;
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
 * 用于公告类型的业务代码
 * @Author czd
 * @Date:create in 2019/10/11
 * @Version: V1.0
 *
 */
@Controller
@RequestMapping(value = "/ants/announcement")
public class AnnouncementController {


    @Autowired
    private AnnouncementService announcementService;

    @RequestMapping(value = "/getAnnList",method = RequestMethod.GET)
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
        int head = (currentPage - 1) * PageConsts.ANN_PAGE_NUMBER;

        //设置数据库SQL语句中Limit关键字中的参数信息
        parameterMap.put("head", head);
        parameterMap.put("tail", PageConsts.ANN_PAGE_NUMBER);

        //根据页面数获取对应的数据库的公告的数据信息
        List<Announcement> announcementList = announcementService.listAnnouncement(parameterMap);

        announcementMap.put("announcementList",announcementList);

        //从数据库中获取公告的数量
        Integer annNum = announcementService.countAnnNum();

        //获取总的页面数
        int allPage = (annNum / PageConsts.ANN_PAGE_NUMBER) + 1;

        announcementMap.put("allPage",allPage);

        return announcementMap;
    }

    /**
     * 根据公告的id获取对应的公告的详细信息
     * @param annId
     * @return
     */
    @RequestMapping(value = "/getAnnDetail",method = RequestMethod.GET)
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

        //获取数据库中的公告的内容
        String annContent = announcement.getAnnContent();

        //创建截取字符串的自定义对象
        InterceptUtil intercept = new InterceptUtil();

        //将截取的字符串以"/n"截取并且返回一个数组
        String [] contentArray = intercept.intecepterString(annContent);

        //初始化字段fielMap
        Map fieldMap = new HashMap(){
            {
                put("annId",1);
                put("annTitle","hello");
                put("annContent",new String[1]);
                put("annTime","2019-05-02 16:14:54.0");
            }
        };

        //将数据库返回的数据对象中的数据写进fieldMap中，以便等等对数据进行打包
        fieldMap.put("annId",announcement.getAnnId());
        fieldMap.put("annTitle",announcement.getAnnTitle());
        fieldMap.put("annContent",contentArray);
        fieldMap.put("annTime",announcement.getAnnTime());



        detailMap.put("annDetail",fieldMap);

        return detailMap;

    }
}

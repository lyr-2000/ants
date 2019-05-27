package com.ants.controller;

import com.alibaba.fastjson.JSON;
import com.ants.util.SlideCode;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.PrintWriter;
import java.util.Map;

/**
 * @Author: CB#
 * @Date: 2019/5/27
 * @Description: com.ants.controller
 * @version: 1.0
 */
@Controller
@RequestMapping(value = "/ants/code")
public class SlideController extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException{
        super.init(config);
        SlideCode.init(config.getServletContext());
    }

    /*
    登录获取首页的验证码
     */
    @RequestMapping(value = "/SlideCode", method = RequestMethod.POST)
    @ResponseBody
    protected void getSlideCode(HttpServletRequest request, HttpServletResponse response) {
        String imgName = request.getParameter("imgName");
        /*
        如果前端给的图片名字为空字符串进行随机取样
         */
        if("".equals(imgName)){
            File file = new File("/resourceImg");
            String[] list = file.list();
            String filename;
            //获取随机图片， 每次获取到的图片与已有的图片要不同。
            int randowval = RandomUtils.nextInt(list.length);
            filename = list[randowval];
            imgName = filename;
        }
        PrintWriter out = null;
        try {
            SlideCode resourceImg = new SlideCode();
            Map<String, String> result = resourceImg.create(request, imgName);
            out = response.getWriter();
            response.setContentType("application/json-rpc;charset=UTF-8");
            out.println(JSON.toJSONString(result));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    /*
     判断验证码是否正确
    */
    @RequestMapping(value = "/JudgeCode", method = RequestMethod.POST)
    @ResponseBody
    protected void JudgeCode(HttpServletRequest request, HttpServletResponse response) {
        String point = request.getParameter("point");
        Integer location_x = (Integer) request.getSession().getAttribute("location_x");
        if ((Integer.valueOf(point) < location_x + 4) && (Integer.valueOf(point) > location_x - 4)) {
            //说明验证通过，
//            outData(response, "success");
            System.out.println("验证通过");
        } else {
//            outData(response, "error");
            System.out.println("验证失败");
        }
    }


}

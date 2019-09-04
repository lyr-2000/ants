package com.ants.controller.personal;

import com.alibaba.fastjson.JSON;
import com.ants.util.SlideCode;
import com.ants.util.editphoto;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: CB#
 * @Date: 2019/5/27
 * @Description: com.ants.controller
 * @version: 1.0
 */
@Controller
@RequestMapping("/slideCode")
public class SlideController extends HttpServlet {

    /*
    登录获取首页的验证码
     */
    @RequestMapping(value = "/slide", method = RequestMethod.GET)
    @ResponseBody
    protected Map getSlideCode(HttpServletRequest request, HttpServletResponse response) throws FileNotFoundException {
        String imagename = request.getParameter("imgname");
        System.out.println(imagename);
        File path = new File(ResourceUtils.getURL("classpath:").getPath());
        if (!path.exists()) {
            path = new File("");
        }
        editphoto.init(request.getSession().getServletContext().getRealPath(""));

        if (!StringUtils.isEmpty(imagename)) {
            imagename = imagename.substring(imagename.lastIndexOf("/") + 1, imagename.lastIndexOf("png") + 3);
        }
        Map<String, String> result = null;
        try {
            editphoto resourImg = new editphoto();
            result = resourImg.create(request, imagename);
            response.setContentType("application/json-rpc;charset=UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping(value="/checkServlet",method=RequestMethod.POST)
    @ResponseBody
    protected Map checkCode(HttpServletResponse response, HttpServletRequest request,String point) {
        Map map = new HashMap();
        try {
            response.setContentType("application/json-rpc;charset=UTF-8");
            Integer location_x = (Integer) request.getSession().getAttribute("location_x");
             HttpSession session = request.getSession();
            if ((Integer.valueOf(point) < location_x + 4) && (Integer.valueOf(point) > location_x - 4)) {
                //说明验证通过，
                map.put("status", 1);
                map.put("slideCode", "dadas");
                System.out.println("验证通过");
            } else {
                map.put("status", 0);
                map.put("slideCode", "dasdas");
                System.out.println("验证失败");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return map;

    }


}

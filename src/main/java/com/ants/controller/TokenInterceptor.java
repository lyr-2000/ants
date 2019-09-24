package com.ants.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.json.JsonObject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author 晨边#CB
 * @Date:created in  2019/9/25 1:54
 * @Version V1.0
 **/

public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        response.setCharacterEncoding("utf-8");
        String token = request.getParameter("token");
        //token不存在
        if(null!=token){
            //验证token是否正确
            if(token!=null||token.equals(request.getSession().getAttribute("token"))){
                return true;
            }
        }
        JSONObject jsonObject  = new JSONObject();
        jsonObject.put("status","error");
        jsonObject.put("message","你的token还没有输入呢！！");
        response.getWriter().write(jsonObject.toString());
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}

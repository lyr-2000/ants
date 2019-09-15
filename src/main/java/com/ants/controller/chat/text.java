package com.ants.controller.chat;

import com.ants.entity.chat.ChatContactor;
import com.ants.impl.chat.ChatServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author 晨边#CB
 * @Date:created in  2019/9/16 2:23
 * @Version V1.0
 **/
@Controller
@RequestMapping(value = "/ants/text")
public class text {

    @Autowired
    private ChatServiceImpl chatService;

    @RequestMapping(value = "/getAnnList",method = RequestMethod.POST)
    @ResponseBody
    public Map  text(){
        List<ChatContactor> chatContactors = chatService.queryContactor(171543113);
        Map map = new HashMap();
        map.put("ss",chatContactors);
        return map;
    }


}

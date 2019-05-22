package com.ants.controller;

import com.ants.Util.requestLogin;
import com.ants.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author czd
 */
@Controller
@RequestMapping(value = "/ants/user")
public class UserController {

<<<<<<< Updated upstream

    @RequestMapping(value = "/login",method=RequestMethod.POST)
    @ResponseBody
    public Map<String ,String> studentsLogin(Student student, String cpacha, HttpServletRequest request){
        Map<String ,String> ants = new HashMap<String,String>();
        if(student ==null){
            ants.put("type","false");
            ants.put("message","请填写用户名");
            return ants;
        }
        if(StringUtils.isEmpty(cpacha)){
            ants.put("type", "false");
            ants.put("message", "请填写验证码！");
            return ants;
        }
        if(StringUtils.isEmpty(student.getUserName())){
            ants.put("type", "error");
            ants.put("message", "请填写用户名！");
            return ants;
        }
        if(StringUtils.isEmpty(student.getPassword())){
            ants.put("type", "error");
            ants.put("message", "请填写密码！");
            return ants;
        }
        Object loginCpacha = request.getSession().getAttribute("loginCpacha");
        if(loginCpacha == null){
            ants.put("type", "error");
            ants.put("message", "未获取到验证码，请重新刷新下界面");
            return ants;
        }
        try{
            if(requestLogin.askForLogin(student.getuNpD())!=303){
                ants.put("type","error");
                ants.put("message","改用户不存在");
                return ants;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;//登录成功
    }




=======
    @Autowired
    private UserService userService;
>>>>>>> Stashed changes

    @RequestMapping(value = "/helloUser")
    @ResponseBody
    public Map<String, Object> helloUser() {

        User user = new User();
        user.setParentId(5);
        user.setParentName("22200");
        int result = userService.add(user);
        System.out.println("result: " + result);

        Map<String, Object> ret = new HashMap<>();
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("content", 1);
        queryMap.put("offset", 2);
        queryMap.put("pageSize", 3);
        ret.put("rows", 4);
        ret.put("total", 4);
        return ret;
    }
}

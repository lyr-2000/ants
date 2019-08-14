package com.ants.controller;

import com.ants.entity.Student;
import com.ants.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author czd
 */
@Controller
@RequestMapping(value = "/ants/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    /**
     * 根据学生学号获取学生信息
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

}

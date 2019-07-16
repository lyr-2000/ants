package com.ants.controller;

import com.ants.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @author czd
 */
@Controller
@RequestMapping(value = "/ants/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

}

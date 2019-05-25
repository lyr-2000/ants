package com.ants.service;

import com.ants.entity.Student;
import org.springframework.stereotype.Service;

/**
 * @author czd
 */
@Service
public interface StudentService {
    /**
     * 添加新用户的接口
     *
     * @param student
     * @return
     */
    public int add(Student student);
}

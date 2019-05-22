package com.ants.service;

import com.ants.entity.Student;
import org.springframework.stereotype.Service;

/**
 * @author czd
 */
@Service
public interface StudentService {
    public int add(Student student);
}

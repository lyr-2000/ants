package com.ants.dao;

import com.ants.entity.Student;
import org.springframework.stereotype.Repository;

/**
 * @author czd
 */
@Repository
public interface StudentDao {
    public int add(Student student);
}

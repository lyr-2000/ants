package com.ants.dao;

import com.ants.entity.Student;
import org.springframework.stereotype.Repository;

/**
 * @author czd
 */
@Repository
public interface StudentDao {
    /**
     * 添加新用户的接口
     *
     * @param student
     * @return
     */
    public int add(Student student);
}

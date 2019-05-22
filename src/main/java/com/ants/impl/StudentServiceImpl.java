package com.ants.impl;
import com.ants.dao.StudentDao;
import com.ants.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author czd
 */
@Service
public class StudentServiceImpl implements StudentDao {

    @Autowired
    private StudentDao studentDao;

    @Override
    public int add(Student student) {
        return studentDao.add(student);
    }
}

package com.ants.impl;

import com.ants.dao.ClassifyDao;
import com.ants.service.ClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author czd
 */
@Service
public class ClassifyServiceImpl implements ClassifyService {

    @Autowired
    private ClassifyDao classifyDao;

    @Override
    public List<String> parentClassification(){
        return classifyDao.parentClassification();
    }
}

package com.ants.impl;

import com.ants.dao.IdleDao;
import com.ants.entity.Goods;
import com.ants.service.IdleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author czd
 * 闲置相关的代码均在此服务层实现类
 */
@Service
public class IdleServiceImpl implements IdleService {

    @Autowired
    private IdleDao idleDao;

    /**
     * 根据学生账户获取此学生发布的闲置的商品
     * @return
     */
    public List<Goods> myIdleGoods(Integer studentId){
        return idleDao.myIdleGoods(studentId);
    }
}

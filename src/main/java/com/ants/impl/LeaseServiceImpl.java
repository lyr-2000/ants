package com.ants.impl;

import com.ants.dao.LeaseDao;
import com.ants.entity.Lease;
import com.ants.service.LeaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author czd
 * 租赁相关的代码均在此服务层实现类
 */
@Service
public class LeaseServiceImpl implements LeaseService {

    @Autowired
    private LeaseDao leaseDao;

    /**
     * 根据学生账户获取此学生发布的租赁的商品
     * @return
     */
    public List<Lease> myLeaseGoods(Integer studentId){
        return leaseDao.myLeaseGoods(studentId);
    }
}

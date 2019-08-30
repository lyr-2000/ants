package com.ants.service;

import com.ants.entity.Lease;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author czd
 * 租赁相关的代码均在此服务层
 */
@Service
public interface LeaseService {
    /**
     * 根据学生账户获取此学生发布的租赁的商品
     * @return
     */
    public List<Lease> myLeaseGoods(Integer studentId);

    /**
     * 添加新租赁商品,发布租赁
     * @param lease
     * @return
     */
    public int addLeaseGoods(Lease lease);
}

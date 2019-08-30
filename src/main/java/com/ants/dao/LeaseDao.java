package com.ants.dao;

import com.ants.entity.Lease;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author czd
 * 租赁相关的方法均在此数据层
 */
@Repository
public interface LeaseDao {

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

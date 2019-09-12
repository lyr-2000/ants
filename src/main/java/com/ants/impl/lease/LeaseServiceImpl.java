package com.ants.impl.lease;

import com.ants.dao.lease.LeaseDao;
import com.ants.entity.lease.Lease;
import com.ants.service.lease.LeaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 租赁相关的代码均在此服务层实现类
 * @Author czd
 * @Date:created in 2019/10/11
 * @Version: V1.0

 */
@Service
public class LeaseServiceImpl implements LeaseService {

    @Autowired
    private LeaseDao leaseDao;

    /**
     * 根据学生账户获取此学生发布的租赁的商品
     * @return
     */
    public List<Lease> myLeaseGoods(Map<String,Integer> map){

        return leaseDao.myLeaseGoods(map);
    }

    /**
     * 根据学生账户获取此学生发布的租赁的商品的总数量
     * @param studentId
     * @return
     */
    public Integer myLeaseGoodsNums(Integer studentId){
        return leaseDao.myLeaseGoodsNums(studentId);
    }

    /**
     * 添加新租赁商品,发布租赁
     * @param lease
     * @return
     */
    public int addLeaseGoods(Lease lease){
        return leaseDao.addLeaseGoods(lease);
    }
}

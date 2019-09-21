package com.ants.impl.commodity.lease;

import com.ants.dao.commodity.lease.LeaseGoodsDao;
import com.ants.entity.lease.Lease;
import com.ants.service.commodity.lease.LeaseGoodsService;
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
public class LeaseGoodsServiceImpl implements LeaseGoodsService {

    @Autowired
    private LeaseGoodsDao leaseDao;

    /**
     * 根据学生账户获取此学生发布的租赁的商品
     * @return
     */
    public List<Lease> listMyLeaseGoods(Map<String,Integer> map){

        return leaseDao.listMyLeaseGoods(map);
    }

    /**
     * 根据学生账户获取此学生发布的租赁的商品的总数量
     * @param studentId
     * @return
     */
    public Integer countMyLeaseGoodsNums(Integer studentId){
        return leaseDao.countMyLeaseGoodsNums(studentId);
    }

    /**
     * 添加新租赁商品,发布租赁
     * @param lease
     * @return
     */
    public int insertLeaseGoods(Lease lease){
        return leaseDao.insertLeaseGoods(lease);
    }
}

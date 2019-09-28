package com.ants.dao.commodity.lease;

import com.ants.entity.commodity.lease.LeaseGoods;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 租赁相关的方法均在此数据层
 * @Author czd
 * @Date:created in 2019/10/11
 * @Version: V1.0
 *
 */
@Repository
public interface LeaseGoodsDao {

    /**
     * 根据学生账户获取此学生发布的租赁的商品
     * @return
     */
     List<LeaseGoods> listMyLeaseGoods(Map<String,Integer> map);


    /**
     * 根据学生账户获取此学生发布的租赁的商品的总数量
     * @param studentId
     * @return
     */
     Integer countMyLeaseGoodsNums(Integer studentId);

    /**
     * 添加新租赁商品,发布租赁
     * @param lease
     * @return
     */
     int insertLeaseGoods(LeaseGoods lease);
}

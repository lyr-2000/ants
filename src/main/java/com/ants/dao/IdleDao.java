package com.ants.dao;

/**
 * @author czd
 * 闲置相关的方法均在此数据层
 */

import com.ants.entity.Goods;
import com.ants.service.GoodsService;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface IdleDao {

    /**
     * 根据学生账户获取此学生发布的闲置的商品
     * @param map
     * @return
     */
    public List<Goods> myIdleGoods(Map<String,Integer> map);


    /**
     * 根据学生账户获取此学生发布的闲置的商品的总数量
     * @param studentId
     * @return
     */
    public Integer myIdleGoodsNums(Integer studentId);
}

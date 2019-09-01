package com.ants.dao;

import com.ants.entity.Sell;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author czd
 * 交易完成后相关的方法均在此数据层
 */
@Repository
public interface SellDao {

    /**
     * 根据学生学号获取此学生账号下的所交易完成的商品，包括闲置，租赁和赠送
     * @param map
     * @return
     */
    public List<Sell> mySellGoods(Map<String,Integer> map);

    /**
     * 根据学生账户获取此学生发布的已经完成交易的商品（闲置，租赁，赠送）的总数量
     * @param map
     * @return
     */
    public Integer mySellGoodsNums(Map<String,Integer> map);
}

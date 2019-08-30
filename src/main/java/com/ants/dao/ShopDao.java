package com.ants.dao;

import com.ants.entity.Shop;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author czd
 * 交易箱相关的方法均在此数据层
 */
@Repository
public interface ShopDao {

    /**
     * 根据此学生账号获取交易箱内的我想买和我想卖的商品的内容列表信息
     * @param shop
     * @return
     */
    public List<Shop> tradingCase(Shop shop);
}

package com.ants.dao;

/**
 * @author czd
 * 闲置相关的方法均在此数据层
 */

import com.ants.entity.Goods;
import com.ants.service.GoodsService;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IdleDao {

    /**
     * 根据学生账户获取此学生发布的闲置的商品
     * @return
     */
    public List<Goods> myIdleGoods(Integer studentId);
}

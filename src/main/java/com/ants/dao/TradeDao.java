package com.ants.dao;

import com.ants.entity.Trade;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author czd
 * 正在交易中相关的方法均在此数据层
 */
@Repository
public interface TradeDao {

    /**
     * 根据学生学号获取此账号下正在交易的商品，包括闲置，租赁和赠送
     * @param studentId
     * @return
     */
    public List<Trade> myTradeGoods(Integer studentId);
}

package com.ants.service;

import com.ants.entity.Trade;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author czd
 * 正在交易中相关的代码均在此服务层
 */
@Service
public interface TradeService {

    /**
     * 根据学生学号获取此账号下正在交易的商品，包括闲置，租赁和赠送
     * @param studentId
     * @return
     */
    public List<Trade> myTradeGoods(Map<String,Integer> map);

    /**
     * 根据学生账户获取此学生发布的正在交易的商品（闲置，租赁，寻求和赠送）的总数量
     * @param map
     * @return
     */
    public Integer myTradingGoodsNums(Map<String,Integer> map);
}

package com.ants.service;

import com.ants.entity.Trade;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<Trade> myTradeGoods(Integer studentId);
}

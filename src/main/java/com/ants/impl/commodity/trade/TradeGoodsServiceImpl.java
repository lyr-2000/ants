package com.ants.impl.commodity.trade;

import com.ants.dao.commodity.trade.TradeGoodsDao;
import com.ants.entity.trade.Trade;
import com.ants.service.commodity.trade.TradeGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 正在交易中相关的代码均在此服务层实现类
 * @Author czd
 * @Date:created in 2019/10/11
 * @Version: V1.0

 */
@Service
public class TradeGoodsServiceImpl implements TradeGoodsService {

    @Autowired
    private TradeGoodsDao tradeDao;

    /**
     * 根据学生学号获取此账号下正在交易的商品，包括闲置，租赁和赠送
     * @param studentId
     * @return
     */
    public List<Trade> listMyTradeGoods(Map<String,Integer> map){
        return tradeDao.listMyTradeGoods(map);
    }

    /**
     * 根据学生账户获取此学生发布的正在交易的商品（闲置，租赁，寻求和赠送）的总数量
     * @param map
     * @return
     */
    public Integer countMyTradingGoodsNums(Map<String,Integer> map){
        return tradeDao.countMyTradingGoodsNums(map);
    }
}

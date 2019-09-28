package com.ants.dao.commodity.trade;

import com.ants.entity.commodity.trade.TradeGoods;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 正在交易中相关的方法均在此数据层
 * @Author czd
 * @Date:created in 2019/10/11
 * @VErsion: V1.0
 *
 */
@Repository
public interface TradeGoodsDao {

    /**
     * 根据学生学号获取此账号下正在交易的商品，包括闲置，租赁和赠送
     * @param studentId
     * @return
     */
     List<TradeGoods> listMyTradeGoods(Map<String,Integer> map);

    /**
     * 根据学生账户获取此学生发布的正在交易的商品（闲置，租赁，寻求和赠送）的总数量
     * @param map
     * @return
     */
     Integer countMyTradingGoodsNums(Map<String,Integer> map);
}

package com.ants.impl.sell;

import com.ants.dao.sell.SellDao;
import com.ants.entity.sell.Sell;
import com.ants.service.sell.SellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author czd
 * 交易完成后相关的代码均在此服务层实现类
 */
@Service
public class SellServiceImpl implements SellService {

    @Autowired
    private SellDao sellDao;

    /**
     * 根据学生学号获取此学生账号下的所交易完成的商品，包括闲置，租赁和赠送
     * @param map
     * @return
     */
    public List<Sell> mySellGoods(Map<String,Integer> map){
        return sellDao.mySellGoods(map);
    }

    /**
     * 根据学生账户获取此学生发布的已经完成交易的商品（闲置，租赁，赠送）的总数量
     * @param map
     * @return
     */
    public Integer mySellGoodsNums(Map<String,Integer> map){
        return sellDao.mySellGoodsNums(map);
    }
}

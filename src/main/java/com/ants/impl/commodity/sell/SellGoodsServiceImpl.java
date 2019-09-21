package com.ants.impl.commodity.sell;

import com.ants.dao.commodity.sell.SellGoodsDao;
import com.ants.entity.sell.Sell;
import com.ants.service.commodity.sell.SellGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 交易完成后相关的代码均在此服务层实现类
 * @Author czd
 * @Date:created in 2019/10/11
 * @Version: V1.0

 */
@Service
public class SellGoodsServiceImpl implements SellGoodsService {

    @Autowired
    private SellGoodsDao sellDao;

    /**
     * 根据学生学号获取此学生账号下的所交易完成的商品，包括闲置，租赁和赠送
     * @param map
     * @return
     */
    public List<Sell> listMySellGoods(Map<String,Integer> map){
        return sellDao.listMySellGoods(map);
    }

    /**
     * 根据学生账户获取此学生发布的已经完成交易的商品（闲置，租赁，赠送）的总数量
     * @param map
     * @return
     */
    public Integer countMySellGoodsNums(Map<String,Integer> map){
        return sellDao.countMySellGoodsNums(map);
    }
}

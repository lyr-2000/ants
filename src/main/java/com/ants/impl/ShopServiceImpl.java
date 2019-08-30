package com.ants.impl;

import com.ants.dao.ShopDao;
import com.ants.entity.Shop;
import com.ants.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author czd
 * 交易箱相关的代码均在此服务层实现类
 */
@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopDao shopDao;

    /**
     * 根据此学生账号获取交易箱内的我想买和我想卖的商品的内容列表信息
     * @param shop
     * @return
     */
    public List<Shop> tradingCase(Shop shop){
        return shopDao.tradingCase(shop);
    }
}

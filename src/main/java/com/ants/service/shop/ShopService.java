package com.ants.service.shop;

import com.ants.entity.shop.Shop;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author czd
 * 和交易箱相关的代码均在此服务层
 */
@Service
public interface ShopService {

    /**
     * 根据此学生账号获取交易箱内的我想买和我想卖的商品的内容列表信息
     * @param shop
     * @return
     */
    public List<Shop> tradingCase(Shop shop);
}

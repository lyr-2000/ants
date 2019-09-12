package com.ants.impl.shop;

import com.ants.dao.shop.ShopDao;
import com.ants.entity.shop.Shop;
import com.ants.service.shop.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 交易箱相关的代码均在此服务层实现类
 * @Author czd
 * @Date:created in 2019/10/11
 * @Version: V1.0

 */
@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopDao shopDao;

    /**
     * 根据此学生账号获取交易箱内的我想买和我想卖的商品的内容列表信息
     * @param map
     * @return
     */
    public List<Shop> tradingCase(Map<String,Integer> map){

        return shopDao.tradingCase(map);
    }

    /**
     * 根据学生账户获取此学生我想买和我想卖的商品总数量
     * @param map
     * @return
     */
    public Integer myShopGoodsNums(Map<String,Integer> map){
        return shopDao.myShopGoodsNums(map);
    }
}

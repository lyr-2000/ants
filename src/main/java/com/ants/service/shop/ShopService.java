package com.ants.service.shop;

import com.ants.entity.shop.Shop;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 和交易箱相关的代码均在此服务层
 * @Author czd
 * @Date:created in 2019/10/11
 * @Version: V1.0

 */
@Service
public interface ShopService {

    /**
     * 根据此学生账号获取交易箱内的我想买和我想卖的商品的内容列表信息
     * @param map
     * @return
     */
     List<Shop> listTradingCase(Map<String,Integer> map);

    /**
     * 根据学生账户获取此学生我想买和我想卖的商品总数量
     * @param map
     * @return
     */
     Integer countMyShopGoodsNums(Map<String,Integer> map);
}

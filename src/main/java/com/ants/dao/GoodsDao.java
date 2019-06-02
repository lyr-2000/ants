package com.ants.dao;

import com.ants.entity.Goods;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author czd
 */
@Repository
public interface GoodsDao {

    /**
     * 随机获取16个商品的案例到副页面进行数据渲染
     * @param head
     * @return
     */
    public List<Goods> chooseExampleGoods(Map<String,Integer> map);

    /**
     * 获取所有商品的数量
     * @return
     */
    public Integer getGoodsNumbers();
}

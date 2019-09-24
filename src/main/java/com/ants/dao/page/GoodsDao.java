package com.ants.dao.page;

import com.ants.entity.page.Goods;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Author czd
 * @Date:created in 2019/10/11
 * @Version: V1.0
 */
@Repository
public interface GoodsDao {

    /**
     * 随机获取16个商品的案例到副页面进行数据渲染
     * @param head
     * @return
     */
     List<Goods> listExampleGoods(Map<String,Integer> map);

    /**
     * 获取所有商品的数量
     * @return
     */
     Integer countGoodsNumbers();

    /**
     * 根据商品id获取对应商品信息
     * @param goodsId
     * @return
     */
     Map<String,Object> getGoodsById(Integer goodsId);

    /**
     * 添加新商品
     * @param goods
     * @return
     */
     int insertGoods(Goods goods);
}

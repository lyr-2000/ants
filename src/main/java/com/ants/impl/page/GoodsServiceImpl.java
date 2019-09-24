package com.ants.impl.page;

import com.ants.dao.page.GoodsDao;
import com.ants.entity.page.Goods;
import com.ants.service.page.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author czd
 * @Date:created in 2019/10/11
 * @Version: V1.0
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsDao goodsDao;

    @Override
    public List<Goods> listExampleGoods(Map<String,Integer> map) {
        return goodsDao.listExampleGoods(map);
    }

    @Override
    public Integer countGoodsNumbers() {
        return goodsDao.countGoodsNumbers();
    }

    /**
     * 根据商品id获取对应商品信息
     * @param goodsId
     * @return
     */
    public Map<String,Object> getGoodsById(Integer goodsId){
        return goodsDao.getGoodsById(goodsId);
    }

    /**
     * 添加新商品
     * @param goods
     * @return
     */
    public int insertGoods(Goods goods){
        return goodsDao.insertGoods(goods);
    }
}

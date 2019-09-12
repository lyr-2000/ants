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
    public List<Goods> chooseExampleGoods(Map<String,Integer> map) {
        return goodsDao.chooseExampleGoods(map);
    }

    @Override
    public Integer getGoodsNumbers() {
        return goodsDao.getGoodsNumbers();
    }

    /**
     * 根据商品id获取对应商品信息
     * @param goodsId
     * @return
     */
    public Map<String,Object> chooseGoodsById(Integer goodsId){
        return goodsDao.chooseGoodsById(goodsId);
    }

    /**
     * 添加新商品
     * @param goods
     * @return
     */
    public int addGoods(Goods goods){
        return goodsDao.addGoods(goods);
    }
}

package com.ants.impl;

import com.ants.dao.GoodsDao;
import com.ants.entity.Goods;
import com.ants.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author czd
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
}

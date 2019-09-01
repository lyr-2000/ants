package com.ants.impl;

import com.ants.dao.GiveDao;
import com.ants.entity.Give;
import com.ants.service.GiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author czd
 * 赠送相关的代码均在此服务层实现类
 */
@Service
public class GiveServiceImpl implements GiveService {
    @Autowired
    private GiveDao giveDao;


    /**
     * 添加赠送物品
     * @param give
     * @return
     */
    public int addGiveGoods(Give give){
        return giveDao.addGiveGoods(give);
    }

    /**
     * 根据学生账户获取此学生发布的赠送的商品
     * @param map
     * @return
     */
    public List<Give> myGiveGoods(Map<String,Integer> map){
        return giveDao.myGiveGoods(map);
    }

    /**
     * 根据学生账户获取此学生发布的赠送的商品的总数量
     * @param studentId
     * @return
     */
    public Integer myGiveGoodsNums(Integer studentId){
        return giveDao.myGiveGoodsNums(studentId);
    }
}

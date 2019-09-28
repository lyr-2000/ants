package com.ants.impl.commodity.give;

import com.ants.dao.commodity.give.GiveGoodsDao;
import com.ants.entity.commodity.give.GiveGoods;
import com.ants.service.commodity.give.GiveGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 赠送相关的代码均在此服务层实现类
 * @Author czd
 * @Date:created in 2019/10/11
 * @Version: V1.0

 */
@Service
public class GiveGoodsServiceImpl implements GiveGoodsService {
    @Autowired
    private GiveGoodsDao giveDao;


    /**
     * 添加赠送物品
     * @param give
     * @return
     */
    public int insertGiveGoods(GiveGoods give){
        return giveDao.insertGiveGoods(give);
    }

    /**
     * 根据学生账户获取此学生发布的赠送的商品
     * @param map
     * @return
     */
    public List<GiveGoods> listMyGiveGoods(Map<String,Integer> map){
        return giveDao.listMyGiveGoods(map);
    }

    /**
     * 根据学生账户获取此学生发布的赠送的商品的总数量
     * @param studentId
     * @return
     */
    public Integer countMyGiveGoodsNums(Integer studentId){
        return giveDao.countMyGiveGoodsNums(studentId);
    }
}

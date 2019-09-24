package com.ants.impl.commodity.idle;

import com.ants.dao.commodity.idle.IdleGoodsDao;
import com.ants.entity.page.Goods;
import com.ants.service.commodity.idle.IdleGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 闲置相关的代码均在此服务层实现类
 * @Author czd
 * @Date:created in 2019/10/11
 * @Version: V1.0

 */
@Service
public class IdleGoodsServiceImpl implements IdleGoodsService {

    @Autowired
    private IdleGoodsDao idleDao;

    /**
     * 根据学生账户获取此学生发布的闲置的商品
     * @param map
     * @return
     */
    public List<Goods> listMyIdleGoods(Map<String,Integer> map){
        return idleDao.listMyIdleGoods(map);
    }


    /**
     * 根据学生账户获取此学生发布的闲置的商品的总数量
     * @param studentId
     * @return
     */
    public Integer countMyIdleGoodsNums(Integer studentId){
        return idleDao.countMyIdleGoodsNums(studentId);
    }
}

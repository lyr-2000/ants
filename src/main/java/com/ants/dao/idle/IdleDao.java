package com.ants.dao.idle;

/**
 * 闲置相关的方法均在此数据层
 * @Author czd
 * @Date:created in 2019/10/11
 * @Version: V1.0
 */

import com.ants.entity.page.Goods;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface IdleDao {

    /**
     * 根据学生账户获取此学生发布的闲置的商品
     * @param map
     * @return
     */
     List<Goods> myIdleGoods(Map<String,Integer> map);


    /**
     * 根据学生账户获取此学生发布的闲置的商品的总数量
     * @param studentId
     * @return
     */
     Integer myIdleGoodsNums(Integer studentId);
}

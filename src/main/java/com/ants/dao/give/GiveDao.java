package com.ants.dao.give;

import com.ants.entity.give.Give;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 赠送相关的方法均在此数据层
 * @Author czd
 * @Date:created in 2019/10/11
 * @Version: V1.0
 *
 */
@Repository
public interface GiveDao {
    /**
     * 添加赠送物品
     * @param give
     * @return
     */
     int addGiveGoods(Give give);


    /**
     * 根据学生账户获取此学生发布的赠送的商品
     * @param map
     * @return
     */
     List<Give> myGiveGoods(Map<String,Integer> map);

    /**
     * 根据学生账户获取此学生发布的赠送的商品的总数量
     * @param studentId
     * @return
     */
     Integer myGiveGoodsNums(Integer studentId);
}

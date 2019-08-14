package com.ants.dao;

import com.ants.entity.Give;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author czd
 * 赠送相关的方法均在此数据层
 */
@Repository
public interface GiveDao {
    /**
     * 添加赠送物品
     * @param give
     * @return
     */
    public int addGiveGoods(Give give);


    /**
     * 根据学生账户获取此学生发布的赠送的商品
     * @param studentId
     * @return
     */
    public List<Give> myGiveGoods(Integer studentId);
}

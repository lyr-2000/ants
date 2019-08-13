package com.ants.dao;

import com.ants.entity.Give;
import org.springframework.stereotype.Repository;

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
}

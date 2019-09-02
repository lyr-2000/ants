package com.ants.service.give;

import com.ants.entity.give.Give;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author czd
 * 赠送相关的代码均在此服务层
 */
@Service
public interface GiveService {
    /**
     * 添加赠送物品
     * @param give
     * @return
     */
    public int addGiveGoods(Give give);

    /**
     * 根据学生账户获取此学生发布的赠送的商品
     * @param map
     * @return
     */
    public List<Give> myGiveGoods(Map<String,Integer> map);

    /**
     * 根据学生账户获取此学生发布的赠送的商品的总数量
     * @param studentId
     * @return
     */
    public Integer myGiveGoodsNums(Integer studentId);
}

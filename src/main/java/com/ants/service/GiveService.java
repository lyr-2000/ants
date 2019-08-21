package com.ants.service;

import com.ants.entity.Give;
import org.springframework.stereotype.Service;

import java.util.List;

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
     * @param studentId
     * @return
     */
    public List<Give> myGiveGoods(Integer studentId);
}
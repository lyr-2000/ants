package com.ants.service;

import com.ants.entity.Goods;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author czd
 * 闲置相关的代码均在此服务层
 */
@Service
public interface IdleService {

    /**
     * 根据学生账户获取此学生发布的闲置的商品
     * @return
     */
    public List<Goods> myIdleGoods(Integer studentId);
}

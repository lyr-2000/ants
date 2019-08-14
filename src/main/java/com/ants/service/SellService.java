package com.ants.service;

import com.ants.entity.Sell;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author czd
 * 交易完成后相关的代码均在此服务层
 */
@Service
public interface SellService {

    /**
     * 根据学生学号获取此学生账号下的所交易完成的商品，包括闲置，租赁和赠送
     * @param studentId
     * @return
     */
    public List<Sell> mySellGoods(Integer studentId);
}

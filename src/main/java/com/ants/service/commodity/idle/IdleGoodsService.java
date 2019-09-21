package com.ants.service.commodity.idle;

import com.ants.entity.page.Goods;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 闲置相关的代码均在此服务层
 * @Author czd
 * @Date:created in 2019/10/11
 * @Version: V1.0

 */
@Service
public interface IdleGoodsService {

    /**
     * 根据学生账户获取此学生发布的闲置的商品
     * @param map
     * @return
     */
     List<Goods> listMyIdleGoods(Map<String,Integer> map);

    /**
     * 根据学生账户获取此学生发布的闲置的商品的总数量
     * @param studentId
     * @return
     */
     Integer countMyIdleGoodsNums(Integer studentId);
}

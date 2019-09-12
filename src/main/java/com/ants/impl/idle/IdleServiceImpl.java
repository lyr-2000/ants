package com.ants.impl.idle;

import com.ants.dao.idle.IdleDao;
import com.ants.entity.page.Goods;
import com.ants.service.idle.IdleService;
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
public class IdleServiceImpl implements IdleService {

    @Autowired
    private IdleDao idleDao;

    /**
     * 根据学生账户获取此学生发布的闲置的商品
     * @param map
     * @return
     */
    public List<Goods> myIdleGoods(Map<String,Integer> map){
        return idleDao.myIdleGoods(map);
    }


    /**
     * 根据学生账户获取此学生发布的闲置的商品的总数量
     * @param studentId
     * @return
     */
    public Integer myIdleGoodsNums(Integer studentId){
        return idleDao.myIdleGoodsNums(studentId);
    }
}

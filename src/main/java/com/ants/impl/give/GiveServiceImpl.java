package com.ants.impl.give;

import com.ants.dao.give.GiveDao;
import com.ants.entity.give.Give;
import com.ants.service.give.GiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 赠送相关的代码均在此服务层实现类
 * @Author czd
 * @Date:created in 2019/10/11
 * @Version: V1.0

 */
@Service
public class GiveServiceImpl implements GiveService {
    @Autowired
    private GiveDao giveDao;


    /**
     * 添加赠送物品
     * @param give
     * @return
     */
    public int addGiveGoods(Give give){
        return giveDao.addGiveGoods(give);
    }

    /**
     * 根据学生账户获取此学生发布的赠送的商品
     * @param map
     * @return
     */
    public List<Give> myGiveGoods(Map<String,Integer> map){
        return giveDao.myGiveGoods(map);
    }

    /**
     * 根据学生账户获取此学生发布的赠送的商品的总数量
     * @param studentId
     * @return
     */
    public Integer myGiveGoodsNums(Integer studentId){
        return giveDao.myGiveGoodsNums(studentId);
    }
}

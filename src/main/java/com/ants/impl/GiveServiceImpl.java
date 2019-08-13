package com.ants.impl;

import com.ants.dao.GiveDao;
import com.ants.entity.Give;
import com.ants.service.GiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author czd
 * 赠送相关的代码均在此服务层实现类
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
}

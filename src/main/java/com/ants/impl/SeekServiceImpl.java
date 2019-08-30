package com.ants.impl;

import com.ants.dao.SeekDao;
import com.ants.entity.Seek;
import com.ants.service.SeekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author czd
 * 寻求相关的代码均在此服务层实现类
 */
@Service
public class SeekServiceImpl implements SeekService {

    @Autowired
    private SeekDao seekDao;

    /**
     * 根据学生账户获取此学生发布的寻求的商品,我的寻求
     * @param studentId
     * @return
     */
    public List<Seek> mySeekGoods(Integer studentId){
        return seekDao.mySeekGoods(studentId);
    }

    /**
     * 添加新寻求商品,发布寻求
     * @param seek
     * @return
     */
    public int addSeekGoods(Seek seek){
        return seekDao.addSeekGoods(seek);
    }
}

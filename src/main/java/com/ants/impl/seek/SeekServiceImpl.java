package com.ants.impl.seek;

import com.ants.dao.seek.SeekDao;
import com.ants.entity.seek.Seek;
import com.ants.service.seek.SeekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
    public List<Seek> mySeekGoods(Map<String,Integer> map){
        return seekDao.mySeekGoods(map);
    }


    /**
     * 根据学生账户获取此学生发布的寻求的商品的总数量
     * @param studentId
     * @return
     */
    public Integer mySeekGoodsNums(Integer studentId){
        return seekDao.mySeekGoodsNums(studentId);
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

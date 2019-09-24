package com.ants.impl.commodity.seek;

import com.ants.dao.commodity.seek.SeekGoodsDao;
import com.ants.entity.seek.Seek;
import com.ants.service.commodity.seek.SeekGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 寻求相关的代码均在此服务层实现类
 * @Author czd
 * @Date:created in 2019/10/11
 * @Version: V1.0

 */
@Service
public class SeekGoodsServiceImpl implements SeekGoodsService {

    @Autowired
    private SeekGoodsDao seekDao;

    /**
     * 根据学生账户获取此学生发布的寻求的商品,我的寻求
     * @param studentId
     * @return
     */
    public List<Seek> listMySeekGoods(Map<String,Integer> map){
        return seekDao.listMySeekGoods(map);
    }


    /**
     * 根据学生账户获取此学生发布的寻求的商品的总数量
     * @param studentId
     * @return
     */
    public Integer countMySeekGoodsNums(Integer studentId){
        return seekDao.countMySeekGoodsNums(studentId);
    }

    /**
     * 添加新寻求商品,发布寻求
     * @param seek
     * @return
     */
    public int insertSeekGoods(Seek seek){
        return seekDao.insertSeekGoods(seek);
    }
}

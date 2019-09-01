package com.ants.dao;

import com.ants.entity.Seek;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author czd
 * 寻求相关的方法均在此数据层
 */
@Repository
public interface SeekDao {

    /**
     * 根据学生账户获取此学生发布的寻求的商品,我的寻求
     * @param studentId
     * @return
     */
    public List<Seek> mySeekGoods(Map<String,Integer> map);


    /**
     * 根据学生账户获取此学生发布的寻求的商品的总数量
     * @param studentId
     * @return
     */
    public Integer mySeekGoodsNums(Integer studentId);

    /**
     * 添加新寻求商品,发布寻求
     * @param seek
     * @return
     */
    public int addSeekGoods(Seek seek);
}

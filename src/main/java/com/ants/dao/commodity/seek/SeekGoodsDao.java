package com.ants.dao.commodity.seek;

import com.ants.entity.seek.Seek;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 寻求相关的方法均在此数据层
 * @Author czd
 * @Date:created in 2019/10/11
 * @Version: V1.0
 *
 */
@Repository
public interface SeekGoodsDao {

    /**
     * 根据学生账户获取此学生发布的寻求的商品,我的寻求
     * @param studentId
     * @return
     */
     List<Seek> listMySeekGoods(Map<String,Integer> map);


    /**
     * 根据学生账户获取此学生发布的寻求的商品的总数量
     * @param studentId
     * @return
     */
     Integer countMySeekGoodsNums(Integer studentId);

    /**
     * 添加新寻求商品,发布寻求
     * @param seek
     * @return
     */
     int insertSeekGoods(Seek seek);
}

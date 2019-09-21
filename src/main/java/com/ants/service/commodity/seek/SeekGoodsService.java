package com.ants.service.commodity.seek;

import com.ants.entity.seek.Seek;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 寻求相关的代码均在此服务层
 * @Author czd
 * @Date:created in 2019/10/11
 * @Version: V1.0

 */
@Service
public interface SeekGoodsService {
    /**
     * 根据学生账户获取此学生发布的寻求的商品,我的寻求
     * @param map
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

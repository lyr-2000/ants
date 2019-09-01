package com.ants.service.seek;

import com.ants.entity.seek.Seek;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author czd
 * 寻求相关的代码均在此服务层
 */
@Service
public interface SeekService {
    /**
     * 根据学生账户获取此学生发布的寻求的商品,我的寻求
     * @param map
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

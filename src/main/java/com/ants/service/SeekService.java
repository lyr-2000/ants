package com.ants.service;

import com.ants.entity.Seek;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author czd
 * 寻求相关的代码均在此服务层
 */
@Service
public interface SeekService {
    /**
     * 根据学生账户获取此学生发布的寻求的商品,我的寻求
     * @param studentId
     * @return
     */
    public List<Seek> mySeekGoods(Integer studentId);

    /**
     * 添加新寻求商品,发布寻求
     * @param seek
     * @return
     */
    public int addSeekGoods(Seek seek);
}

package com.ants.dao;

import com.ants.entity.Goods;
import com.ants.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author czd
 */
@Repository
public interface StudentDao {
    /**
     * 添加新用户的接口
     *
     * @param student
     * @return
     */
    public int add(Student student);

    /**
     *根据此商品ID获取对应卖家的其他上架商品
     * @param id
     * @return
     */
    public List<Goods> chooseGoodsByStudentId(Integer id);

    /**
     * 根据商品Id获取对应卖家的其他
     * @param goodsId
     * @return
     */
    public Integer countGoodsNumbers(Integer goodsId);
}

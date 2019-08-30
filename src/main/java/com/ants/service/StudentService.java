package com.ants.service;

import com.ants.entity.Goods;
import com.ants.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author czd
 */
@Service
public interface StudentService {
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

    /**
     * 根据学生学号获取学生信息
     * @param id
     * @return
     */
    public Student getStudentMessage(Integer id);

    /**
     * 编辑我的资料，然后保存个人信息
     * @param student
     * @return
     */
    public int saveStuMessage(Student student);
}

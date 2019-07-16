package com.ants.impl;

import com.ants.dao.StudentDao;
import com.ants.entity.Goods;
import com.ants.entity.Student;
import com.ants.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author czd
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    /**
     * 添加新用户的接口实现方法
     *
     * @param student
     * @return
     */
    @Override
    public int add(Student student) {
        return studentDao.add(student);
    }


    /**
     *根据此商品ID获取对应卖家的其他上架商品
     * @param id
     * @return
     */
    public List<Goods> chooseGoodsByStudentId(Integer id){
        return studentDao.chooseGoodsByStudentId(id);
    }

    /**
     * 根据商品Id获取对应卖家的其他
     * @param goodsId
     * @return
     */
    public Integer countGoodsNumbers(Integer goodsId){
        return studentDao.countGoodsNumbers(goodsId);
    }
}

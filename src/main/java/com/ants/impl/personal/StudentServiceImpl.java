package com.ants.impl.personal;

import com.ants.dao.personal.StudentDao;
import com.ants.entity.page.Goods;
import com.ants.entity.personal.Student;
import com.ants.service.personal.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author czd
 * @Date:created in 2019/10/11
 * @Version: V1.0
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

    /**
     * 根据学生学号获取学生信息
     * @param id
     * @return
     */
    public Student getStudentMessage(Integer id) {
        return studentDao.getStudentMessage(id);
    }

    /**
     * 编辑我的资料，然后保存个人信息
     * @param student
     * @return
     */
    public int saveStuMessage(Student student){
        return studentDao.saveStuMessage(student);
    }
}

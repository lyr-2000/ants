package com.ants.dao.personal;

import com.ants.entity.page.Goods;
import com.ants.entity.personal.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author czd
 * @Date:created in 2019/10/11
 * @Version: V1.0
 */
@Repository
public interface StudentDao {
    /**
     * 添加新用户的接口
     *
     * @param student
     * @return
     */
     int add(Student student);

    /**
     *根据此商品ID获取对应卖家的其他上架商品
     * @param id
     * @return
     */
     List<Goods> chooseGoodsByStudentId(Integer id);

    /**
     * 根据商品Id获取对应卖家的其他
     * @param goodsId
     * @return
     */
     Integer countGoodsNumbers(Integer goodsId);

    /**
     * 根据学生学号获取学生信息
     * @param id
     * @return
     */
     Student getStudentMessage(Integer id);

    /**
     * 编辑我的资料，然后保存个人信息
     * @param student
     * @return
     */
     int saveStuMessage(Student student);
}

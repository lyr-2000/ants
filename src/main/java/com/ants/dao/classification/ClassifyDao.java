package com.ants.dao.classification;

import com.ants.entity.classification.ChildClass;
import com.ants.entity.page.Goods;
import com.ants.entity.classification.ParentClass;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Author czd
 * @Date:created in 2019/10/11
 * @Version: V1.0
 */
@Repository
public interface ClassifyDao {
    /**
     * 首页大分类的数据接口，无“其他”这大分类
     */
     List<ParentClass> parentClassification();

    /**
     * 首页大分类的数据接口
     */
     List<ParentClass> parentClassificationHasOthers();


    /**
     * 首页小分类的数据接口
     */
     List<ChildClass> childClassification(Integer parentClass);

    /**
     * 获取所有大分类的ID的的数据接口
     *
     * @return
     */
     List<Integer> parentClassId();

    /**
     * 获取所有的小分类的名字，除了“其他”这分类
     *
     * @return
     */
     List<ChildClass> allChildClassification();

    /**
     * 根据大分类的ID获取属于此大分类的商品的信息
     *
     * @param parentId
     * @return
     */
     List<Goods> chooseGoodsByParent(Map<String,Integer> map);

    /**
     * 根据大分类的ID获取属于此大分类的所有商品的总数量
     *
     * @param parentId
     * @return
     */
     Integer getGoodsByParentNumbers(Integer parentId);

    /**
     * 根据前端传来的ID获取此ID代表的大分类的名称
     *
     * @param parentId
     * @return
     */
     ParentClass getParentName(Integer parentId);

    /**
     * 根据前端传来的ID获取此ID代表的小分类的名称
     *
     * @param parentId
     * @return
     */
     ChildClass getChildName(Integer childId);

    /**
     * 根据前端传来的子类的ID获取父类的名称
     *
     * @param childId
     * @return
     */
     ParentClass getParentNameByChildId(Integer childId);

    /**
     * 根据前端传来的子类ID获取相应的商品数据
     *
     * @param childId
     * @return
     */
     List<Goods> chooseGoodsByChild(Map<String,Integer> map);

    /**
     * 根据小分类的ID获取属于此小分类的所有商品的总数量
     *
     * @param childId
     * @return
     */
     Integer getGoodsByChildNumbers(Integer childId);

    /**
     * 根据子类ID获取其父类下的所有子类名称
     *
     * @param childId
     * @return
     */
     List<ChildClass> getChildClassifyByChildId(Integer childId);

    /**
     * 副页面中根据综合获取指定的商品的列表
     *
     * @param map
     * @return
     */
     List<Goods> chooseGoodsByComposite(Map<String, Integer> map);

    /**
     * 副页面中根据综合获取指定的商品的数量
     *
     * @param map
     * @return
     */
     int countGoodsByComposite(Map<String, Integer> map);

    /**
     * 副页面中根据上传时间获取指定的商品的列表（降序）
     * @param map
     * @return
     */
     List<Goods> chooseGoodsByUploadTime(Map<String, Integer> map);

    /**
     * 副页面中根据价格获取指定的商品的列表（降序）
     * @param map
     * @return
     */
     List<Goods> chooseGoodsByPrice(Map<String,Integer> map);
}

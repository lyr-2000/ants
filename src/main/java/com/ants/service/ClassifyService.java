package com.ants.service;

import com.ants.entity.ChildClass;
import com.ants.entity.Goods;
import com.ants.entity.ParentClass;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author czd
 */
@Service
public interface ClassifyService {
    /**
     * 首页大分类的数据接口，无“其他”这个大分类
     *
     * @return
     */
    public List<ParentClass> parentClassification();

    /**
     * 首页大分类的数据接口
     * @return
     */
    public List<ParentClass> parentClassificationHasOthers();

    /**
     * 首页小分类的数据接口
     *
     * @return
     */
    public List<String> childClassification(Integer parentClass);

    /**
     * 获取所有大分类的ID的的数据接口
     *
     * @return
     */
    public List<Integer> parentClassId();

    /**
     * 获取所有的小分类的名字，除了“其他”这分类
     * @return
     */
    public List<ChildClass> allChildClassification();

    /**
     * 根据大分类的ID获取属于此大分类的商品的信息
     * @param parentId
     * @return
     */
    public List<Goods> chooseGoodsByParent(Integer parentId);

    /**
     * 根据大分类的ID获取属于此大分类的所有商品的总数量
     * @param parentId
     * @return
     */
    public Integer getGoodsByParentNumbers(Integer parentId);

    /**
     * 根据前端传来的ID获取此ID代表的大分类的名称
     * @param parentId
     * @return
     */
    public String getParentName(Integer parentId);

    /**
     * 根据前端传来的ID获取此ID代表的小分类的名称
     * @param parentId
     * @return
     */
    public String getChildName(Integer childId);

    /**
     * 根据前端传来的子类的ID获取父类的名称
     * @param childId
     * @return
     */
    public String getParentNameByChildId(Integer childId);

    /**
     * 根据前端传来的子类ID获取相应的商品数据
     * @param childId
     * @return
     */
    public List<Goods> chooseGoodsByChild(Integer childId);

    /**
     * 根据小分类的ID获取属于此小分类的所有商品的总数量
     * @param childId
     * @return
     */
    public Integer getGoodsByChildNumbers(Integer childId);
}

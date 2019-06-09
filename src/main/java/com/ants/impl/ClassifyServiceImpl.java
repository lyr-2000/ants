package com.ants.impl;

import com.ants.dao.ClassifyDao;
import com.ants.entity.ChildClass;
import com.ants.entity.Goods;
import com.ants.entity.ParentClass;
import com.ants.service.ClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author czd
 */
@Service
public class ClassifyServiceImpl implements ClassifyService {

    @Autowired
    private ClassifyDao classifyDao;


    /**
     * 首页大分类的数据接口实现方法，无“其他”这个大分类
     *
     * @return
     */
    @Override
    public List<ParentClass> parentClassification() {
        return classifyDao.parentClassification();
    }

    /**
     * 首页大分类的数据接口实现方法
     *
     * @return
     */
    @Override
    public List<ParentClass> parentClassificationHasOthers() {
        return classifyDao.parentClassificationHasOthers();
    }

    /**
     * 首页小分类的数据接口实现方法
     *
     * @param parentClass
     * @return
     */
    @Override
    public List<String> childClassification(Integer parentClass) {
        return classifyDao.childClassification(parentClass);
    }

    /**
     * 获取大分类的ID的接口实现方法
     *
     * @return
     */
    @Override
    public List<Integer> parentClassId() {
        return classifyDao.parentClassId();
    }


    /**
     * 获取所有的小分类的名字，除了“其他”这分类
     *
     * @return
     */
    @Override
    public List<ChildClass> allChildClassification() {
        return classifyDao.allChildClassification();
    }

    /**
     * 据大分类的ID获取属于此大分类的商品的信息
     *
     * @param parentId
     * @return
     */
    @Override
    public List<Goods> chooseGoodsByParent(Map<String,Integer> map) {
        return classifyDao.chooseGoodsByParent(map);
    }

    /**
     * 根据大分类的ID获取属于此大分类的所有商品的总数量
     *
     * @param parentId
     * @return
     */
    @Override
    public Integer getGoodsByParentNumbers(Integer parentId) {
        return classifyDao.getGoodsByParentNumbers(parentId);
    }

    /**
     * 根据前端传来的ID获取此ID代表的小分类的名称
     *
     * @param childId
     * @return
     */
    @Override
    public String getChildName(Integer childId) {
        return classifyDao.getChildName(childId);
    }

    /**
     * 根据前端传来的ID获取此ID代表的大分类的名称
     *
     * @param parentId
     * @return
     */
    @Override
    public String getParentName(Integer parentId) {
        return classifyDao.getParentName(parentId);
    }

    /**
     * 根据前端传来的子类的ID获取父类的名称
     *
     * @param childId
     * @return
     */
    @Override
    public String getParentNameByChildId(Integer childId) {
        return classifyDao.getParentNameByChildId(childId);
    }

    /**
     * 根据前端传来的子类ID获取相应的商品数据
     *
     * @param childId
     * @return
     */
    @Override
    public List<Goods> chooseGoodsByChild(Map<String,Integer> map) {
        return classifyDao.chooseGoodsByChild(map);
    }

    /**
     * 根据小分类的ID获取属于此小分类的所有商品的总数量
     *
     * @param childId
     * @return
     */
    @Override
    public Integer getGoodsByChildNumbers(Integer childId) {
        return classifyDao.getGoodsByChildNumbers(childId);
    }

    /**
     * 根据子类ID获取其父类下的所有子类名称
     *
     * @param childId
     * @return
     */
    @Override
    public List<String> getChildClassifyByChildId(Integer childId) {
        return classifyDao.getChildClassifyByChildId(childId);
    }

    /**
     * 副页面中根据综合获取指定的商品的列表
     *
     * @param map
     * @return
     */
    @Override
    public List<Goods> chooseGoodsByComposite(Map<String, Integer> map) {
        return classifyDao.chooseGoodsByComposite(map);
    }

    /**
     * 副页面中根据综合获取指定的商品的数量
     *
     * @param map
     * @return
     */
    @Override
    public int countGoodsByComposite(Map<String, Integer> map) {
        return classifyDao.countGoodsByComposite(map);
    }

    /**
     * 副页面中根据上传时间获取指定的商品的列表（降序）
     *
     * @param map
     * @return
     */
    @Override
    public List<Goods> chooseGoodsByUploadTime(Map<String, Integer> map) {
        return classifyDao.chooseGoodsByUploadTime(map);
    }

    /**
     * 副页面中根据价格获取指定的商品的列表（降序）
     *
     * @param map
     * @return
     */
    @Override
    public List<Goods> chooseGoodsByPrice(Map<String, Integer> map) {
        return classifyDao.chooseGoodsByPrice(map);
    }
}

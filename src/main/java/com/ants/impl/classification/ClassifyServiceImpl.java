package com.ants.impl.classification;

import com.ants.dao.classification.ClassifyDao;
import com.ants.entity.classification.ChildClass;
import com.ants.entity.page.Goods;
import com.ants.entity.classification.ParentClass;
import com.ants.service.classification.ClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author czd
 * @Date:created in 2019/10/11
 * @Version: V1.0
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
    public List<ParentClass> listParentClassification() {
        return classifyDao.listParentClassification();
    }

    /**
     * 首页大分类的数据接口实现方法
     *
     * @return
     */
    @Override
    public List<ParentClass> listParentClassificationHasOthers() {
        return classifyDao.listParentClassificationHasOthers();
    }

    /**
     * 首页小分类的数据接口实现方法
     *
     * @param parentClass
     * @return
     */
    @Override
    public List<ChildClass> listChildClassification(Integer parentClass) {
        return classifyDao.listChildClassification(parentClass);
    }

    /**
     * 获取大分类的ID的接口实现方法
     *
     * @return
     */
    @Override
    public List<Integer> listParentClassId() {
        return classifyDao.listParentClassId();
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
    public List<Goods> getGoodsByParent(Map<String,Integer> map) {
        return classifyDao.getGoodsByParent(map);
    }

    /**
     * 根据大分类的ID获取属于此大分类的所有商品的总数量
     *
     * @param parentId
     * @return
     */
    @Override
    public Integer countGoodsByParentNumbers(Integer parentId) {
        return classifyDao.countGoodsByParentNumbers(parentId);
    }

    /**
     * 根据前端传来的ID获取此ID代表的小分类的名称
     *
     * @param childId
     * @return
     */
    @Override
    public ChildClass getChildName(Integer childId) {
        return classifyDao.getChildName(childId);
    }

    /**
     * 根据前端传来的ID获取此ID代表的大分类的名称
     *
     * @param parentId
     * @return
     */
    @Override
    public ParentClass getParentName(Integer parentId) {
        return classifyDao.getParentName(parentId);
    }

    /**
     * 根据前端传来的子类的ID获取父类的名称
     *
     * @param childId
     * @return
     */
    @Override
    public ParentClass getParentNameByChildId(Integer childId) {
        return classifyDao.getParentNameByChildId(childId);
    }

    /**
     * 根据前端传来的子类ID获取相应的商品数据
     *
     * @param childId
     * @return
     */
    @Override
    public List<Goods> listGoodsByChild(Map<String,Integer> map) {
        return classifyDao.listGoodsByChild(map);
    }

    /**
     * 根据小分类的ID获取属于此小分类的所有商品的总数量
     *
     * @param childId
     * @return
     */
    @Override
    public Integer countGoodsByChildNumbers(Integer childId) {
        return classifyDao.countGoodsByChildNumbers(childId);
    }

    /**
     * 根据子类ID获取其父类下的所有子类名称
     *
     * @param childId
     * @return
     */
    @Override
    public List<ChildClass> listChildClassifyByChildId(Integer childId) {
        return classifyDao.listChildClassifyByChildId(childId);
    }

    /**
     * 副页面中根据综合获取指定的商品的列表
     *
     * @param map
     * @return
     */
    @Override
    public List<Goods> listGoodsByComposite(Map<String, Integer> map) {
        return classifyDao.listGoodsByComposite(map);
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
    public List<Goods> listGoodsByUploadTime(Map<String, Integer> map) {
        return classifyDao.listGoodsByUploadTime(map);
    }

    /**
     * 副页面中根据价格获取指定的商品的列表（降序）
     *
     * @param map
     * @return
     */
    @Override
    public List<Goods> listGoodsByPrice(Map<String, Integer> map) {
        return classifyDao.listGoodsByPrice(map);
    }
}

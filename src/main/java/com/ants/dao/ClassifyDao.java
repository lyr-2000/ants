package com.ants.dao;

import com.ants.entity.ChildClass;
import com.ants.entity.Goods;
import com.ants.entity.ParentClass;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author czd
 */
@Repository
public interface ClassifyDao {
    /**
     * 首页大分类的数据接口，无“其他”这大分类
     */
    public List<ParentClass> parentClassification();

    /**
     * 首页大分类的数据接口
     */
    public List<ParentClass> parentClassificationHasOthers();


    /**
     * 首页小分类的数据接口
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
     *
     * @return
     */
    public List<ChildClass> allChildClassification();

    /**
     * 根据大分类的ID获取属于此大分类的商品的信息
     *
     * @param parentId
     * @return
     */
    public List<Goods> chooseGoodsByParent(Map<String,Integer> map);

    /**
     * 根据大分类的ID获取属于此大分类的所有商品的总数量
     *
     * @param parentId
     * @return
     */
    public Integer getGoodsByParentNumbers(Integer parentId);

    /**
     * 根据前端传来的ID获取此ID代表的大分类的名称
     *
     * @param parentId
     * @return
     */
    public String getParentName(Integer parentId);

    /**
     * 根据前端传来的ID获取此ID代表的小分类的名称
     *
     * @param parentId
     * @return
     */
    public String getChildName(Integer childId);

    /**
     * 根据前端传来的子类的ID获取父类的名称
     *
     * @param childId
     * @return
     */
    public String getParentNameByChildId(Integer childId);

    /**
     * 根据前端传来的子类ID获取相应的商品数据
     *
     * @param childId
     * @return
     */
    public List<Goods> chooseGoodsByChild(Map<String,Integer> map);

    /**
     * 根据小分类的ID获取属于此小分类的所有商品的总数量
     *
     * @param childId
     * @return
     */
    public Integer getGoodsByChildNumbers(Integer childId);

    /**
     * 根据子类ID获取其父类下的所有子类名称
     *
     * @param childId
     * @return
     */
    public List<String> getChildClassifyByChildId(Integer childId);

    /**
     * 副页面中根据综合获取指定的商品的列表
     *
     * @param map
     * @return
     */
    public List<Goods> chooseGoodsByComposite(Map<String, Integer> map);

    /**
     * 副页面中根据综合获取指定的商品的数量
     *
     * @param map
     * @return
     */
    public int countGoodsByComposite(Map<String, Integer> map);

    /**
     * 副页面中根据上传时间获取指定的商品的列表（降序）
     * @param map
     * @return
     */
    public List<Goods> chooseGoodsByUploadTime(Map<String, Integer> map);

    /**
     * 副页面中根据价格获取指定的商品的列表（降序）
     * @param map
     * @return
     */
    public List<Goods> chooseGoodsByPrice(Map<String,Integer> map);
}

package com.ants.service;

import com.ants.entity.ParentClass;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author czd
 */
@Service
public interface ClassifyService {
    /**
     * 首页大分类的数据接口
     *
     * @return
     */
    public List<ParentClass> parentClassification();

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
}

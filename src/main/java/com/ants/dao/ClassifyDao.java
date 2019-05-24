package com.ants.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author czd
 */
@Repository
public interface ClassifyDao {
   /**
    * 首页大分类的数据接口
    */
   public List<String> parentClassification();

   /**
    * 首页小分类的数据接口
    */
   public List<String> childClassification(Integer parentClass);

   /**
    * 获取所有大分类的ID的的数据接口
    * @return
    */
   public List<Integer> parentClassId();
}

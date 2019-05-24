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
}

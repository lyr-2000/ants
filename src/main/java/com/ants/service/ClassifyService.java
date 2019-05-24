package com.ants.service;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author czd
 */
@Service
public interface ClassifyService {
      /**
       * 首页大分类的数据接口
       * @return
       */
      public List<String> parentClassification();
}

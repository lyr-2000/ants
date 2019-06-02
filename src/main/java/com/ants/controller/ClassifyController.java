package com.ants.controller;

import com.ants.entity.Goods;
import com.ants.entity.ParentClass;
import com.ants.service.ClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * @author czd
 * 大分类、小分类的Controller
 */
@Controller
@RequestMapping(value = "/ants/class")
public class ClassifyController {

    @Autowired
    private ClassifyService classifyService;

    /**
     * 首页的点击所有分类功能的数据，包括大分类类型和小分类类型
     *
     * @return
     */
    @RequestMapping(value = "/allClassify", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, List<String>> childClassify() {
        Map allMap = new HashMap<>();
        //存放小分类的数组的列表
        List<List<String>> childList = new ArrayList<>();
        //获取大分类的ID
        List<Integer> parentClass = classifyService.parentClassId();
        //获取所有的大分类的数据信息
        List<ParentClass> parentClassification = classifyService.parentClassification();

        //根据大分类的ID获取对应的小分类的数据信息列表
        for (Integer parentId : parentClass) {
            List<String> childClassification = classifyService.childClassification(parentId);
            childList.add(childClassification);
        }
        allMap.put("parentClassification", parentClassification);
        allMap.put("childClassification", childList);

        return allMap;
    }


    /**
     * 根据前端传来的大分类的ID获取属于此分类的商品信息
     *
     * @param parentId
     * @return
     */
    @RequestMapping(value = "/goodsByParent", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, List<Goods>> chooseGoodsByParent(@RequestParam(value = "parentId") Integer parentId) {
        Map dataMap = new HashMap<>();
        //根据前端给的大分类的ID获取属于此大分类的商品信息
        List<Goods> goodsList = classifyService.chooseGoodsByParent(parentId);
        dataMap.put("goodsList", goodsList);

        //获取属于此大分类的商品的总数
        Integer goodsNumbers = classifyService.getGoodsByParentNumbers(parentId);
        //根据商品的总数计算出这个大分类的一共的页数
        int page = (goodsNumbers / 16) + 1;
        dataMap.put("page", page);

        //获取纵向导航栏中属于此大分类的小分类信息
        List<String> childList = classifyService.childClassification(parentId);
        dataMap.put("childList", childList);

        //根据前端传来的ID获取此ID代表的大分类的名称，并且传回给前端进行字体加强
        String parentName = classifyService.getParentName(parentId);
        dataMap.put("parentName", parentName);

        return dataMap;
    }


    /**
     * 根据前端传来的小分类的ID获取属于此分类的商品信息
     * @param childId
     * @return
     */
    @RequestMapping(value = "/goodsByChild", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, List<Goods>> chooseGoodsByChild(@RequestParam(value = "childId") Integer childId) {
        Map dataMap = new HashMap();
        //根据前端传来的子类ID获取父类名称
        String parentName = classifyService.getParentNameByChildId(childId);
        dataMap.put("parentName", parentName);

        //根据前端传来的子类ID获取子类名称
        String childName = classifyService.getChildName(childId);
        dataMap.put("childName", childName);

        //根据前端传来的子类ID获取相对应的商品数据
        List<Goods> goodsList = classifyService.chooseGoodsByChild(childId);
        dataMap.put("goodsList", goodsList);

        //根据子类ID获取商品数量
        Integer goodsNumbers = classifyService.getGoodsByParentNumbers(childId);
        //根据子类对应的商品数量计算页数
        int page = (goodsNumbers / 16) + 1;
        dataMap.put("page", page);
        return dataMap;
    }
}

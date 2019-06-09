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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author czd
 * 大分类、小分类的Controller
 */
@Controller
@RequestMapping(value = "/ants/class")
public class ClassifyController {

    private final static Integer PAGENUMBERS = 2;

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
     * 副页面根据前端传来的大分类的ID获取属于此分类的商品信息
     *
     * @param parentId
     * @return
     */
    @RequestMapping(value = "/goodsByParent", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, List<Goods>> chooseGoodsByParent(@RequestParam(value = "parentId") Integer parentId) {
        Map dataMap = new HashMap<>();

        //获取前端传来的大分类ID和设置默认页面商品数量，默认是一页显示16个商品
        Map<String, Integer> parameterMap = new HashMap<>();
        parameterMap.put("parentId", parentId);
        parameterMap.put("head", 0);
        parameterMap.put("tail", PAGENUMBERS);

        //根据前端给的大分类的ID获取属于此大分类的商品信息
        List<Goods> goodsList = classifyService.chooseGoodsByParent(parameterMap);
        dataMap.put("goodsList", goodsList);

        //获取属于此大分类的商品的总数
        Integer goodsNumbers = classifyService.getGoodsByParentNumbers(parentId);
        //根据商品的总数计算出这个大分类的一共的页数
        int page = (goodsNumbers / PAGENUMBERS) + 1;
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
     * 副页面根据前端传来的小分类的ID获取属于此分类的商品信息
     *
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

        //获取前端传来的大分类ID和设置默认页面商品数量，默认是一页显示16个商品
        Map<String, Integer> parameterMap = new HashMap<>();
        parameterMap.put("childId", childId);
        parameterMap.put("head", 0);
        parameterMap.put("tail", PAGENUMBERS);

        //根据前端传来的子类ID获取相对应的商品数据
        List<Goods> goodsList = classifyService.chooseGoodsByChild(parameterMap);
        dataMap.put("goodsList", goodsList);

        //根据子类ID获取其父类下的所有子类
        List<String> childList = classifyService.getChildClassifyByChildId(childId);
        dataMap.put("childList", childList);

        //根据子类ID获取商品数量
        Integer goodsNumbers = classifyService.getGoodsByParentNumbers(childId);
        //根据子类对应的商品数量计算页数
        int page = (goodsNumbers / PAGENUMBERS) + 1;
        dataMap.put("page", page);

        return dataMap;
    }


    /**
     * 副页面中：当type等于1时根据综合获取指定的商品的列表
     * 当type等于2时根据上传时间获取指定的商品的列表
     * 当type等于3时根据价格获取指定的商品的列表
     *
     * @param parentId
     * @param childId
     * @param type
     * @return
     */
    @RequestMapping(value = "/chooseGoodsByType", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, List<Goods>> chooseGoodsByComposite(@RequestParam(value = "parentId") Integer parentId,
                                                           @RequestParam(value = "childId") Integer childId,
                                                           @RequestParam(value = "type") Integer type) {
        Map dataMap = new HashMap();

        //用来存放参数 parentId和childId的Map集合
        Map<String, Integer> parameterMap = new HashMap<>();
        parameterMap.put("parentId", parentId);
        parameterMap.put("childId", childId);
        parameterMap.put("head", 0);
        parameterMap.put("tail", PAGENUMBERS);

        /**
         * type: 等于0时代表大分类小分类根据页数获取商品信息；
         *       等于1时代表综合；
         *       等于2代表时间；
         *       等于3代表价格；
         */
        switch (type) {
            case 1:
                //根据parentId和childId来获取对应的商品的信息
                List<Goods> compositeGoods = classifyService.chooseGoodsByComposite(parameterMap);
                dataMap.put("composite", compositeGoods);
                break;
            case 2://根据parentId和childId来获取对应的商品的信息
                List<Goods> uploadTimeGoods = classifyService.chooseGoodsByUploadTime(parameterMap);
                dataMap.put("uploadTimeGoods", uploadTimeGoods);
                break;
            case 3://根据parentId和childId来获取对应的商品的信息
                List<Goods> chooseGoodsByPrice = classifyService.chooseGoodsByPrice(parameterMap);
                dataMap.put("chooseGoodsByPrice", chooseGoodsByPrice);
                break;
        }


        //根据parentId和childId来获取对应的商品的数量
        Integer goodsNumbers = classifyService.countGoodsByComposite(parameterMap);
        //获取此商品数量的页数
        Integer page = (goodsNumbers / PAGENUMBERS) + 1;
        dataMap.put("page", page);

        return dataMap;
    }


    /**
     * 副页面根据前端传过来的页面数(商品第几页)获取对应的商品信息
     *
     * @param parentId
     * @param childId
     * @param type
     * @param page
     * @return
     */
    @RequestMapping(value = "/pageJump", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, List<Goods>> pageJump(@RequestParam(value = "parentId") Integer parentId,
                                             @RequestParam(value = "childId") Integer childId,
                                             @RequestParam(value = "type") Integer type,
                                             @RequestParam(value = "page") Integer page) {

        Map dataMap = new HashMap();

        //用来存放参数 parentId和childId的Map集合
        Map<String, Integer> parameterMap = new HashMap<>();
        parameterMap.put("parentId", parentId);
        parameterMap.put("childId", childId);
        //根据前端传过来的页面数获取商品的页面数下标，即Limit中的head , tail
        Integer head = (page - 1) * PAGENUMBERS;
        Integer tail = head + PAGENUMBERS;
        parameterMap.put("head", head);
        parameterMap.put("tail", tail);

        /**
         * type：等于0时代表大分类小分类根据页数获取商品信息；
         *      等于1时代表综合；
         *      等于2代表时间；
         *      等于3代表价格；
         */

        switch (type) {
            case 0://根据前端给的大分类的ID获取属于此大分类的商品信息
                List<Goods> goodsList = classifyService.chooseGoodsByParent(parameterMap);
                dataMap.put("goodsList", goodsList);
                break;
            case 1://根据parentId和childId来获取对应的商品的信息
                List<Goods> compositeGoods = classifyService.chooseGoodsByComposite(parameterMap);
                dataMap.put("composite", compositeGoods);
                break;
            case 2:
                List<Goods> uploadTimeGoods = classifyService.chooseGoodsByUploadTime(parameterMap);
                dataMap.put("uploadTimeGoods", uploadTimeGoods);
                break;
            case 3://根据parentId和childId来获取对应的商品的信息
                List<Goods> chooseGoodsByPrice = classifyService.chooseGoodsByPrice(parameterMap);
                dataMap.put("chooseGoodsByPrice", chooseGoodsByPrice);
                break;
        }


        return dataMap;
    }
}

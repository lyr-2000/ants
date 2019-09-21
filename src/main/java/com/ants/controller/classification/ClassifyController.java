package com.ants.controller.classification;

import com.ants.constant.PageConsts;
import com.ants.entity.classification.ChildClass;
import com.ants.entity.page.Goods;
import com.ants.entity.classification.ParentClass;
import com.ants.service.classification.ClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.*;

/**
 * 大分类、小分类的Controller
 * @Author czd
 * @Date:created in 2019/10/11
 * @Version: V1.0
 *
 */
@Controller
@RequestMapping(value = "/ants/class")
public class ClassifyController {

    @Autowired
    private ClassifyService classifyService;

    /**
     * 首页的点击"所有分类"功能的数据，包括大分类类型和小分类类型
     *
     * @return
     */
    @RequestMapping(value = "/allClassify", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, List<String>> childClassify() {
        Map allMap = new HashMap<>();
        //存放小分类的数组的列表
        List<List<ChildClass>> childList = new ArrayList<>();
        //获取大分类的ID
        List<Integer> parentClass = classifyService.listParentClassId();
        //获取所有的大分类的数据信息
        List<ParentClass> parentClassification = classifyService.listParentClassification();

        //遍历所有大分类的ID的数据，然后获取对应大分类ID对应的小分类信息
        for (Integer parentId : parentClass) {
            //根据大分类的ID获取对应的小分类的数据信息列表
            List<ChildClass> childClassification = classifyService.listChildClassification(parentId);
            if(childClassification != null){
                childList.add(childClassification);
            }

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
    @RequestMapping(value = "/goodsByParent", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, List<Goods>> chooseGoodsByParent(@RequestParam(value = "parentId") Integer parentId) {
        Map dataMap = new HashMap<>();

        //获取前端传来的大分类ID和设置默认页面商品数量，默认是一页显示16个商品
        Map<String, Integer> parameterMap = new HashMap<>();
        if (parentId != null){
            parameterMap.put("parentId", parentId);
        }else{
            dataMap.put("error","未获取对应分类下的商品分类！");
            return  dataMap;
        }


        //设置默认页数，默认页数为1，即从数据库第0条数据开始获取
        parameterMap.put("head", 0);
        parameterMap.put("tail", PageConsts.CLASSIFY_PAGE_NUMBER);

        //根据前端给的大分类的ID获取属于此大分类的商品信息
        List<Goods> goodsList = classifyService.getGoodsByParent(parameterMap);
        dataMap.put("goodsList", goodsList);

        //获取属于此大分类的商品的总数
        Integer goodsNumbers = classifyService.countGoodsByParentNumbers(parentId);
        //根据商品的总数计算出这个大分类的一共的页数
        int page = (goodsNumbers / PageConsts.CLASSIFY_PAGE_NUMBER) + 1;
        dataMap.put("page", page);

        //获取纵向导航栏中属于此大分类的小分类信息
        List<ChildClass> childList = classifyService.listChildClassification(parentId);
        if (childList != null){
            dataMap.put("childList", childList);
        }else {
            dataMap.put("childList", null);
        }


        //根据前端传来的ID获取此ID代表的大分类的名称，并且传回给前端进行字体加强
        ParentClass parentName = classifyService.getParentName(parentId);
        if (parentName != null && !parentName.equals("")){
            dataMap.put("parentName", parentName);
        }else{
            dataMap.put("parentName", "父类商品分类名称为空!");
        }


        return dataMap;
    }


    /**
     * 副页面根据前端传来的小分类的ID获取属于此分类的商品信息
     *
     * @param childId
     * @return
     */
    @RequestMapping(value = "/goodsByChild", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, List<Goods>> chooseGoodsByChild(@RequestParam(value = "subClassId") Integer childId) {
        Map dataMap = new HashMap();

        if (childId == null){
            dataMap.put("error","未获取对应分类下的商品信息！");
            return dataMap;
        }

        //根据前端传来的子类ID获取父类名称
        ParentClass parentName = classifyService.getParentNameByChildId(childId);
        if (parentName != null && !parentName.equals("")){
            dataMap.put("parentName", parentName);
        }else{
            dataMap.put("parentName", "父分类商品分类名称为空!");
        }


        //根据前端传来的子类ID获取子类名称
        ChildClass childName = classifyService.getChildName(childId);
        if (childName != null && !childName.equals("")){
            dataMap.put("childName", childName);
        }else {
            dataMap.put("childName", "子分类商品分类名称为空!");
        }


        //获取前端传来的大分类ID和设置默认页面商品数量，默认是一页显示16个商品
        Map<String, Integer> parameterMap = new HashMap<>();
        parameterMap.put("childId", childId);

        //设置数据库SQL语句中Limit关键字中的参数信息
        parameterMap.put("head", 0);
        parameterMap.put("tail", PageConsts.CLASSIFY_PAGE_NUMBER);

        //根据前端传来的子类ID获取相对应的商品数据
        List<Goods> goodsList = classifyService.listGoodsByChild(parameterMap);
        dataMap.put("goodsList", goodsList);

        //根据子类ID获取其父类下的所有子类
        List<ChildClass> childList = classifyService.listChildClassifyByChildId(childId);
        dataMap.put("childList", childList);

        //根据子类ID获取商品数量
        Integer goodsNumbers = classifyService.countGoodsByParentNumbers(childId);
        //根据子类对应的商品数量计算页数
        int page = (goodsNumbers / PageConsts.CLASSIFY_PAGE_NUMBER) + 1;
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
    @RequestMapping(value = "/chooseGoodsByType", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, List<Goods>> chooseGoodsByComposite(@RequestParam(value = "parentId") Integer parentId,
                                                           @RequestParam(value = "childId") Integer childId,
                                                           @RequestParam(value = "type") Integer type) {
        Map dataMap = new HashMap();

        //用来存放参数 parentId和childId的Map集合
        Map<String, Integer> parameterMap = new HashMap<>();

        if (parentId == null || childId ==null){
            dataMap.put("error","未获取对应分类下的商品信息！");
            return dataMap;
        }

        if (type == null){
            dataMap.put("error","商品功能类型获取失败!");
            return dataMap;
        }

        parameterMap.put("parentId", parentId);
        parameterMap.put("childId", childId);

        //设置页面是为第一页开始显示数据，即从数据库中第0条数据开始获取
        parameterMap.put("head", 0);
        parameterMap.put("tail", PageConsts.CLASSIFY_PAGE_NUMBER);

        /**
         * type: 等于1时代表综合；
         *       等于2代表时间；
         *       等于3代表价格；
         *
         */
        List<Goods> goodsList = new LinkedList<>();
        switch (type) {
            case 1:
                //根据parentId和childId来获取对应的商品的信息
                goodsList = classifyService.listGoodsByComposite(parameterMap);
                dataMap.put("goodsList", goodsList);
                break;
            case 2://根据parentId和childId来获取对应的商品的信息
                goodsList = classifyService.listGoodsByUploadTime(parameterMap);
                dataMap.put("goodsList", goodsList);
                break;
            case 3://根据parentId和childId来获取对应的商品的信息
                goodsList = classifyService.listGoodsByPrice(parameterMap);
                dataMap.put("goodsList", goodsList);
                break;
        }


        //根据parentId和childId来获取对应的商品的数量
        Integer goodsNumbers = classifyService.countGoodsByComposite(parameterMap);
        //获取此商品数量的页数
        Integer page = (goodsNumbers / PageConsts.CLASSIFY_PAGE_NUMBER) + 1;
        dataMap.put("page", page);

        return dataMap;
    }


    /**
     * 副页面根据前端传过来的页面数(商品第几页)获取对应的商品信息
     *
     * @param parentId
     * @param childId
     * @param type
     * @param currentPage
     * @return
     */
    @RequestMapping(value = "/pageJump", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, List<Goods>> pageJump(@RequestParam(value = "parentId") Integer parentId,
                                             @RequestParam(value = "childId") Integer childId,
                                             @RequestParam(value = "type") Integer type,
                                             @RequestParam(value = "currentPage") Integer currentPage) {

        Map dataMap = new HashMap();

        //用来存放参数 parentId和childId的Map集合
        Map<String, Integer> parameterMap = new HashMap<>();
        if (type == null){
            dataMap.put("error","商品功能类型获取失败!");
            return dataMap;
        }

        if (parentId == null && childId== null){
            dataMap.put("error","未获取对应分类下的商品信息！");
            return dataMap;
        }


        parameterMap.put("parentId", parentId);
        parameterMap.put("childId", childId);
        //根据前端传过来的页面数获取商品的页面数下标，即Limit中的head , tail
        Integer head = (currentPage - 1) * PageConsts.CLASSIFY_PAGE_NUMBER;
//        Integer tail = head + PAGENUMBERS;

        //设置数据库SQL语句中Limit关键字中的参数信息
        parameterMap.put("head", head);
        parameterMap.put("tail", PageConsts.CLASSIFY_PAGE_NUMBER);

        /**
         * type：等于0时代表大分类小分类根据页数获取商品信息；
         *      等于1时代表综合；
         *      等于2代表时间；
         *      等于3代表价格；
         */
        List<Goods> goodsList = new LinkedList<>();
        switch (type) {
            case 0://根据前端给的大分类的ID获取属于此大分类的商品信息
                goodsList = classifyService.getGoodsByParent(parameterMap);
                dataMap.put("goodsList", goodsList);
                break;
            case 1://根据parentId和childId来获取对应的商品的信息
                goodsList = classifyService.listGoodsByComposite(parameterMap);
                dataMap.put("goodsList", goodsList);
                break;
            case 2:
                goodsList = classifyService.listGoodsByUploadTime(parameterMap);
                dataMap.put("goodsList", goodsList);
                break;
            case 3://根据parentId和childId来获取对应的商品的信息
                goodsList = classifyService.listGoodsByPrice(parameterMap);
                dataMap.put("goodsList", goodsList);
                break;
        }


        return dataMap;
    }

}

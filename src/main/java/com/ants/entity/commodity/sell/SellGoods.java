package com.ants.entity.commodity.sell;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * 对应着ants_goods_seek这张数据库表
 * 寻求物品
 * @Author czd
 * @Date:created in 2019/10/11
 * @Version: V1.0

 */
@Component
@Data
public class SellGoods {
    /** 商品id */
    private int goodsId;
    /** 商品名称 */
    private String goodsName;
    /** 商品描述 */
    private String goodsDescribe;
    /** 商品图片名称 */
    private String goodsPicture;
    /** 商品子类id */
    private int goodsClass;
    /** 商品价格 */
    private double goodsPrice;
    /** 商品状态：0 -> 已出售  1 -> 已赠送  2 -> 已租赁 */
    private int goodsState;
    /** 商品所属卖家id */
    private int goodsBelong;
    /** 商品交易完成时间 */
    private String sellTime;
    /** 商品交易数量 */
    private int numbers;

}

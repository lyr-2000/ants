package com.ants.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author czd
 * 对应着ants_goods_seek这张数据库表
 * 寻求物品
 */
@Component
@Data
public class Seek {
    private int goodsId;
    private String goodsName;
    private String goodsDescribe;
    private String goodsPicture;
    private int goodsClass;//一个子类的id
    private double goodsPrice;
    private int goodsState;//0：寻求中  1：已寻求
    private int  goodsBargin;//0:可议价  1：不可议价
    private int goodsBelong;
    private int goodsWay;//0:卖家送货上门  1:买家上门自取 2：可待商量
    private String uploadTime;//发布寻求时间
    private int repertory;//期望寻求的商品的数目

}

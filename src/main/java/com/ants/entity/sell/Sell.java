package com.ants.entity.sell;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author czd
 * 对应着ants_other_sell这张数据库表
 * 交易完成之后的商品
 */
@Component
@Data
public class Sell {
    private int goodsId;
    private String goodsName;
    private String goodsDescribe;
    private String goodsPicture;
    private int goodsClass;
    private double goodsPrice;
    private int goodsState; //0:已出售  1：已赠送  2:已租赁
    private int goodsBelong;
    private String sellTime;
    private int numbers;

}

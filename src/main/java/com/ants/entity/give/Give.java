package com.ants.entity.give;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author czd
 * 对应着ants_goods_give这张数据库表
 * 赠送物品
 */
@Component
@Data
public class Give {
    private int goodsId;
    private String goodsName;
    private String goodsDescribe;
    private String goodsPicture;
    private String goodsVideo;
    private int goodsClass;
    private double goodsPrice;
    private int goodsState;
    private int goodsBargin;
    private int goodsBelong;
    private int goodsWay;
    private String uploadTime;
    private int repertory;

}

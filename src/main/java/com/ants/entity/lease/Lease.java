package com.ants.entity.lease;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author czd
 * 对应着ants_goods_lease这张数据库表
 * 租赁物品
 */
@Component
@Data
public class Lease {
    private int goodsId;
    private String goodsName;
    private String goodsDescribe;
    private String goodsPicture;
    private String goodsVideo;
    private int goodsClass;
    private double goodsPrice;
    private int goodsState;
    private int goodsBargin;//0:可议价  1：不可议价
    private int goodsBelong;
    private int goodsWay;//0:卖家送货上门  1:买家上门自取 2：可待商量
    private String uploadTime;
    private int repertory;
}

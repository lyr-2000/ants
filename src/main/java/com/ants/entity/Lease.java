package com.ants.entity;

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
    private int goodsBelong;
    private String uploadTime;
    private int repertory;
}

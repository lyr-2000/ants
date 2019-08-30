package com.ants.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author czd
 * 对应着ants_shop_base这张数据库表
 * 对应着交易箱的相关Bean
 */
@Component
@Data
public class Shop {
    private int shopId;
    private int userId;
    private int goodsId;
    private String goodsPicture;
    private int shopNum;//加入购物车的数量
    private double goodsPrice;
    private int status;//0为我想买，1为我想卖
    private String uploadTime;//商品加入购物车时间
}

package com.ants.entity.shop;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * 对应着ants_other_sell这张数据库表
 * 交易完成之后的商品
 * @Author czd
 * @Date:created in 2019/10/11
 * @Version: V1.0
 */
@Component
@Data
public class Shop {
    /** 商品id */
    private int shopId;
    /** 用户id */
    private int userId;
    /** 商品订单号 */
    private int goodsId;
    /** 商品图片名称 */
    private String goodsPicture;
    /** 加入购物车的数量 */
    private int shopNum;
    /** 商品价格 */
    private double goodsPrice;
    /** 商品状态：0 -> 为我想买，1 -> 为我想卖 */
    private int status;
    /**  商品加入购物车时间 */
    private String uploadTime;
}

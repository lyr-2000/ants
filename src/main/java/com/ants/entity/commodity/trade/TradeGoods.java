package com.ants.entity.commodity.trade;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * 对应着ants_other_trade这张数据库表
 * 正在交易中的商品，报告租赁，闲置和赠送
 * @Author czd
 * @Date:created in 2019/10/11
 * @Version: V1.0

 */
@Component
@Data
public class TradeGoods {
    /** 商品id */
    private int goodsId;
    /** 商品名称 */
    private String goodsName;
    /** 商品描述 */
    private String goodsDescribe;
    /** 商品图片名称 */
    private String goodsPicture;
    /** 商品视频名称 */
    private String goodsVideo;
    /** 商品子类id */
    private int goodsClass;
    /** 商品价格 */
    private double goodsPrice;
    /** 商品类型：0 -> 普通商品  1 -> 赠送商品 2 -> 租赁商品 */
    private int goodsState;
    /** 商品是否议价：0 -> 可议价  1 -> 不可议价 */
    private int goodsBargin;
    /** 商品交易类型： 0 -> 买，1 -> 卖 */
    private int tradeState;
    /** 商品所属卖家id */
    private int goodsBelong;
    /** 送货形式：0 -> 卖家送货上门  1 -> 买家上门自取 2 -> 可待商量 */
    private int goodsWay;
    /**  库存 */
    private int repertory;
    /**  买卖双方最新聊天时间 */
    private String newChatTime;
    /**  商品上传时间 */
    private String uploadTime;

}

package com.ants.entity.trade;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author czd
 * 对应着ants_other_trade这张数据库表
 * 正在交易中的商品，报告租赁，闲置和赠送
 */
@Component
@Data
public class Trade {
    private int goodsId;
    private String goodsName;
    private String goodsDescribe;
    private String goodsPicture;
    private String goodsVideo;
    private int goodsClass;
    private double goodsPrice;
    private int goodsState; //0：普通商品  1：赠送商品 2：租赁商品
    private int goodsBargin; //0:可议价  1：不可议价
    private int tradeState; //交易类型 0代表买，1代表卖
    private int goodsBelong;
    private int goodsWay; //0:卖家送货上门  1:买家上门自取 2：可待商量
    private int repertory; //库存
    private String newChatTime; //买卖双方最新聊天时间
    private String uploadTime; //商品上传时间

}

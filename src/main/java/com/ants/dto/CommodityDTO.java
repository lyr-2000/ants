package com.ants.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * 我的闲置，我的租赁，我的寻求，我的赠送返回给前端的格式参数
 *
 * @Author czd
 * @Date:createed in
 * @Version: V1.0
 */
@Data
public class CommodityDTO {
    /** 商品编号 */
    private Integer goodsId;
    /** 商品名称 */
    private String goodsName;
    /** 商品图片名称 */
    private String goodsPicture;
    /** 商品价格 */
    private Double goodsPrice;
    /** 商品状态 */
    private Integer goodsState;
    /** 商品上传时间 */
    private String uploadTime;
    /** 商品库存 */
    private Integer repertory;
}

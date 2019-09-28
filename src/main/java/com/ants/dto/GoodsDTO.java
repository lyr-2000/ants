package com.ants.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * 副页面的数据传输对象，对应商品的后端返回的参数
 *
 * @Author czd
 * @Date:createed in
 * @Version: V1.0
 */
@Data
public class GoodsDTO {
    /** 商品id编号 */
    private Integer goodsId;
    /** 商品名称 */
    private String goodsName;
    /** 商品图片 */
    private String goodsPicture;
    /** 商品价格 */
    private Double goodsPrice;
    /** 商品是否可以议价 */
    private Integer goodsBargin;
    /** 商品发布时间 */
    private String uploadTime;
}

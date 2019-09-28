package com.ants.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * 大分类的数据传输对象，返回给前端的数据参数
 * @Author czd
 * @Date:createed in
 * @Version: V1.0
 */
@Data
public class ParentClassDTO {
    /** 大分类所属id */
    private Integer parentId;
    /** 大分类的名称 */
    private String parentName;
    /** 存放打分类的图片的名称 */
    private String parentPicture;
}

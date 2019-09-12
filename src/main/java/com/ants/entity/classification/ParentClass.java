package com.ants.entity.classification;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @Author czd
 * @Date:created in 2019/10/11
 * @Version: V1.0
 */
@Component
@Data
public class ParentClass {
    /** 父类id */
    private int parentId;
    /** 父类名称 */
    private String parentName;
    /** 父类对应的图片名称 */
    private String parentPicture;
}

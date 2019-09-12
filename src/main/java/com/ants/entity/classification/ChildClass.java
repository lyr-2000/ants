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
public class ChildClass {
    /** 子类id */
    private int subClassId;
    /** 子类名称 */
    private String subClassName;
    /** 子类所属的父类 */
    private int parentClass;
}

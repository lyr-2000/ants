package com.ants.entity.classification;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author czd
 */
@Component
@Data
public class ChildClass {
    private int subClassId;
    private String subClassName;
    private int parentClass;
}

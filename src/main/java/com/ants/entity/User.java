package com.ants.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author czd
 */
@Component
@Data
public class User {
    private int parentId;
    private String parentName;

}

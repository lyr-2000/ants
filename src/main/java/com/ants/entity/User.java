package com.ants.entity;

import org.springframework.stereotype.Component;

/**
 * @author czd
 */
@Component

public class User {
    private int parentId;
    private String parentName;

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    @Override
    public String toString() {
        return "User{" +
                "parentId=" + parentId +
                ", parentName='" + parentName + '\'' +
                '}';
    }
}

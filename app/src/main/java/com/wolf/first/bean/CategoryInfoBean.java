package com.wolf.first.bean;

import java.io.Serializable;

/**
 * Created by Wolf on 2017/6/4.
 */

public class CategoryInfoBean implements Serializable{

    /**
     * ctgId : 0010001002
     * name : 按菜品选择菜谱
     * parentId : 0010001001
     */

    private String ctgId;
    private String name;
    private String parentId;

    public String getCtgId() {
        return ctgId;
    }

    public void setCtgId(String ctgId) {
        this.ctgId = ctgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
}

package com.wolf.first.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.io.Serializable;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Wolf on 2017/6/4.
 */
@Entity
public class CategoryInfoBean implements Serializable {
   public static final long serialVersionUID = 536871008;
    /**
     * ctgId : 0010001002
     * name : 按菜品选择菜谱
     * parentId : 0010001001
     */
    @Id
    private Long id;
    private String ctgId;
    private String name;
    private String parentId;

    @Generated(hash = 2029565992)
    public CategoryInfoBean(Long id, String ctgId, String name, String parentId) {
        this.id = id;
        this.ctgId = ctgId;
        this.name = name;
        this.parentId = parentId;
    }

    @Generated(hash = 980431558)
    public CategoryInfoBean() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

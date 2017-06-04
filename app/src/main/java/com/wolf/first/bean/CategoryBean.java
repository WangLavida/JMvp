package com.wolf.first.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by W.J on 2017/6/2.
 */

public class CategoryBean implements Serializable{


    public CategoryInfoBean categoryInfo;
    public List<CategoryBean> childs;

    public CategoryInfoBean getCategoryInfo() {
        return categoryInfo;
    }

    public void setCategoryInfo(CategoryInfoBean categoryInfo) {
        this.categoryInfo = categoryInfo;
    }

    public List<CategoryBean> getChilds() {
        return childs;
    }

    public void setChilds(List<CategoryBean> childs) {
        this.childs = childs;
    }
}

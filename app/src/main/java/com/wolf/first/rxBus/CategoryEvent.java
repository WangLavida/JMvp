package com.wolf.first.rxBus;

import com.wolf.first.bean.CategoryInfoBean;

/**
 * Created by W.J on 2017/6/8.
 */

public class CategoryEvent {
    /**
     * 添加删除移动
     */
    public static final int ADD_EVENT = 1;
    public static final int DEL_EVENT = 2;
    public static final int MOVE_EVENT = 3;
    public CategoryInfoBean categoryInfoBean;
    public int event;
    public int to;
    public int from;

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public CategoryInfoBean getCategoryInfoBean() {
        return categoryInfoBean;
    }

    public void setCategoryInfoBean(CategoryInfoBean categoryInfoBean) {
        this.categoryInfoBean = categoryInfoBean;
    }

    public int getEvent() {
        return event;
    }

    public void setEvent(int event) {
        this.event = event;
    }

    public CategoryEvent(int event, CategoryInfoBean categoryInfoBean) {
        this.categoryInfoBean = categoryInfoBean;
        this.event = event;
    }

    public CategoryEvent(int event, int from, int to) {
        this.event = event;
        this.from = from;
        this.to = to;
    }
}

package com.wolf.first.base;

import android.content.Context;

/**
 * Created by W.J on 2017/5/22.
 */

public abstract class BasePresenter<V extends BaseView,M extends BaseModel> {
    public Context mContext;
    public V mView;
    public M mModel;
    public void setVM(V v,M m){
        this.mView = v;
        this.mModel = m;
    }
    public void start(){

    }
}

package com.wolf.first.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;


import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.wolf.first.ui.TestActivity;
import com.wolf.first.util.TUtil;

import butterknife.ButterKnife;

/**
 * Created by W.J on 2017/5/18.
 */

public abstract class BaseActivity<T extends BasePresenter, M extends BaseModel> extends RxAppCompatActivity {
    public abstract int getLayoutId();

    public abstract void initView();

    public abstract void initData();

    public abstract void initPresenter();

    public Context mContext;
    public T mPresenter;
    public M mModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        initView();
        mPresenter = TUtil.getT(this, 0);
        mModel = TUtil.getT(this, 1);
        initPresenter();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


}

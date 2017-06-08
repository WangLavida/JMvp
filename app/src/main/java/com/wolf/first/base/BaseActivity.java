package com.wolf.first.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.idescout.sql.SqlScoutServer;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
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

        mPresenter = TUtil.getT(this, 0);
        mModel = TUtil.getT(this, 1);
        initPresenter();
        initData();
        initView();
        //数据库插件
//        SqlScoutServer.create(this, getPackageName());

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


}

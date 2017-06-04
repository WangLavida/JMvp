package com.wolf.first.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wolf.first.util.TUtil;

import butterknife.ButterKnife;

/**
 * Created by W.J on 2017/6/2.
 */

public abstract class BaseFragment<T extends BasePresenter, M extends BaseModel> extends Fragment {
    public abstract void initPresenter();

    public Context mContext;
    public T mPresenter;
    public M mModel;

    /**
     * 布局
     */
    public abstract int setContent();

    public abstract void initView();
    public abstract void initData();

    public View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(setContent(), container, false);
        ButterKnife.bind(this, rootView);
        mContext = getActivity();
        mPresenter = TUtil.getT(this, 0);
        mModel = TUtil.getT(this, 1);
        initPresenter();
        initData();
        initView();
        return rootView;
    }


}

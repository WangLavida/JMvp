package com.wolf.first.ui.menu;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wolf.first.R;
import com.wolf.first.base.BaseFragment;
import com.wolf.first.ui.contract.CookContract;
import com.wolf.first.ui.model.CookModel;
import com.wolf.first.ui.presenter.CookPresenter;
import com.wolf.first.util.MyLog;


public class CookFragment extends BaseFragment<CookPresenter, CookModel> implements CookContract.View {

    public CookFragment() {
        // Required empty public constructor
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public int setContent() {
        return R.layout.fragment_cook;
    }

    @Override
    public void initView() {
    }

    @Override
    public void initData() {
        mPresenter.getCategory();
    }

    public static CookFragment newInstance(String param1, String param2) {
        CookFragment fragment = new CookFragment();
        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onSuccess(String msg) {
        MyLog.i("获取类别", msg);
    }

    @Override
    public void onLoad() {

    }

    @Override
    public void onError(String msg) {

    }
}

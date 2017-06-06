package com.wolf.first.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.blankj.utilcode.util.ToastUtils;
import com.wolf.first.R;
import com.wolf.first.base.BaseActivity;
import com.wolf.first.base.BaseBean;
import com.wolf.first.contract.TestContract;
import com.wolf.first.model.TestModel;
import com.wolf.first.presenter.TestPresenter;

import butterknife.Bind;
import butterknife.OnClick;

public class TestActivity extends BaseActivity<TestPresenter, TestModel> implements TestContract.View {
    @Bind(R.id.test)
    Button test;

    public static void startTest(Activity activity) {
        Intent intent = new Intent(activity, TestActivity.class);
        activity.startActivity(intent);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_test;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onSuccess(BaseBean baseBean) {
    }

    @Override
    public void onLoad() {

    }

    @Override
    public void onError(String msg) {
         ToastUtils.showLong(msg);
    }

    @OnClick(R.id.test)
    public void onViewClicked() {
        mPresenter.getNews();
    }
}

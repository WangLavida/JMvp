package com.wolf.first.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.wolf.first.R;
import com.wolf.first.base.BaseActivity;

import butterknife.Bind;

public class MenuActivity extends BaseActivity {

    @Bind(R.id.tool_bar)
    Toolbar toolBar;
    @Bind(R.id.draw_layout)
    DrawerLayout drawLayout;
    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    public int getLayoutId() {
        return R.layout.activity_menu;
    }

    @Override
    public void initView() {
        toolBar.setTitle("首页");
        setSupportActionBar(toolBar);
        getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //创建返回键，并实现打开关/闭监听
        mDrawerToggle = new ActionBarDrawerToggle(this, drawLayout, toolBar, R.string.open, R.string.close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        mDrawerToggle.syncState();
        drawLayout.setDrawerListener(mDrawerToggle);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public static void startTest(Activity activity) {
        Intent intent = new Intent(activity, MenuActivity.class);
        activity.startActivity(intent);
    }
}

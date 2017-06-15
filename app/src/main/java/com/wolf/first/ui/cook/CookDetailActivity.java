package com.wolf.first.ui.cook;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.wolf.first.R;
import com.wolf.first.app.Constant;
import com.wolf.first.base.BaseActivity;
import com.wolf.first.bean.CookInfo;

import butterknife.Bind;

public class CookDetailActivity extends BaseActivity {

    @Bind(R.id.name_text)
    TextView nameText;
    @Bind(R.id.tool_bar)
    Toolbar toolBar;
    private CookInfo cookInfo;

    @Override
    public int getLayoutId() {
        return R.layout.activity_cook_detail;
    }

    @Override
    public void initView() {
        toolBar.setTitle("");
        setSupportActionBar(toolBar);
        toolBar.setTitle("");
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        nameText.setText(cookInfo.getName());
    }

    @Override
    public void initData() {
        cookInfo = (CookInfo) getIntent().getExtras().get(Constant.COOK_INFO_KEY);
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}

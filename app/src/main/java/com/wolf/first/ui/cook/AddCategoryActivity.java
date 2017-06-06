package com.wolf.first.ui.cook;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.wolf.first.R;
import com.wolf.first.adapter.CategoryAdapter;
import com.wolf.first.app.Constant;
import com.wolf.first.base.BaseActivity;
import com.wolf.first.base.BaseBean;
import com.wolf.first.bean.CategoryInfoBean;
import com.wolf.first.contract.AddCategoryContract;
import com.wolf.first.model.AddCategoryModel;
import com.wolf.first.presenter.AddCategoryPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class AddCategoryActivity extends BaseActivity<AddCategoryPresenter, AddCategoryModel> implements AddCategoryContract.View {

    @Bind(R.id.tool_bar)
    Toolbar toolBar;
    @Bind(R.id.my_recycler_view)
    RecyclerView myRecyclerView;
    @Bind(R.id.all_recycler_view)
    RecyclerView allRecyclerView;
    private List<CategoryInfoBean> myList = new ArrayList<CategoryInfoBean>();
    private List<CategoryInfoBean> allList = new ArrayList<CategoryInfoBean>();
    private List<CategoryInfoBean> otherList = new ArrayList<CategoryInfoBean>();

    @Override
    public int getLayoutId() {
        return R.layout.activity_add_category;
    }

    @Override
    public void initView() {
        setSupportActionBar(toolBar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        myRecyclerView.setLayoutManager(new GridLayoutManager(this, 4, LinearLayoutManager.VERTICAL, false));
        myRecyclerView.setAdapter(new CategoryAdapter(R.layout.catergory_item, myList));
        allRecyclerView.setLayoutManager(new GridLayoutManager(this, 4, LinearLayoutManager.VERTICAL, false));
        allRecyclerView.setAdapter(new CategoryAdapter(R.layout.catergory_item1, allList));
    }

    @Override
    public void initData() {
        allList = (List<CategoryInfoBean>) getIntent().getExtras().getSerializable(Constant.ALL_LIST_KEY);
        myList.addAll(allList);
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

    }

    @Override
    public void onBackPressed() {
        finish();
    }
}

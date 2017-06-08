package com.wolf.first.ui.cook;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.wolf.first.R;
import com.wolf.first.adapter.CategoryAdapter;
import com.wolf.first.app.Constant;
import com.wolf.first.base.BaseActivity;
import com.wolf.first.base.BaseBean;
import com.wolf.first.bean.CategoryInfoBean;
import com.wolf.first.contract.AddCategoryContract;
import com.wolf.first.model.AddCategoryModel;
import com.wolf.first.presenter.AddCategoryPresenter;
import com.wolf.first.rxBus.RxBus;

import java.util.ArrayList;
import java.util.Iterator;
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
    private CategoryAdapter myAdapter;
    private CategoryAdapter allAdapter;

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
        initMyRecycler();
        initAllRecycler();
    }

    @Override
    public void initData() {
        allList = (List<CategoryInfoBean>) getIntent().getExtras().getSerializable(Constant.ALL_LIST_KEY);
        myList = (List<CategoryInfoBean>) getIntent().getExtras().getSerializable(Constant.MY_LIST_KEY);
        otherList.addAll(allList);
        Iterator<CategoryInfoBean> it = otherList.iterator();
        while (it.hasNext()) {
            CategoryInfoBean categoryInfoBean = it.next();
            for (CategoryInfoBean categoryInfoBean1 : myList) {
                if (categoryInfoBean.getName().equals(categoryInfoBean1.getName())) {
                    it.remove();
                }
            }
        }
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

    private void initMyRecycler() {
        View myEmptyView = LayoutInflater.from(mContext).inflate(R.layout.category_empty, null);
        myRecyclerView.setLayoutManager(new GridLayoutManager(this, 4, LinearLayoutManager.VERTICAL, false));
        myAdapter = new CategoryAdapter(R.layout.catergory_item, myList);
        TextView emptyText = (TextView) myEmptyView.findViewById(R.id.empty_text);
        emptyText.setText("快点点击下面添加啊");
        myAdapter.setEmptyView(myEmptyView);
        myAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                mPresenter.deleteCategory(myList.get(position));
                otherList.add(myList.get(position));
                myList.remove(position);
                notifyDataSetChanged();
            }
        });
        myRecyclerView.setAdapter(myAdapter);
    }

    private void initAllRecycler() {
        View allEmptyView = LayoutInflater.from(mContext).inflate(R.layout.category_empty, null);
        allRecyclerView.setLayoutManager(new GridLayoutManager(this, 4, LinearLayoutManager.VERTICAL, false));
        allAdapter = new CategoryAdapter(R.layout.catergory_item1, otherList);
        TextView emptyText = (TextView) allEmptyView.findViewById(R.id.empty_text);
        emptyText.setText("添加这么多干嘛");
        allAdapter.setEmptyView(allEmptyView);
        allAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                mPresenter.saveCategory(otherList.get(position));
                myList.add(otherList.get(position));
                otherList.remove(position);
                notifyDataSetChanged();
            }
        });
        allRecyclerView.setAdapter(allAdapter);
    }

    private void notifyDataSetChanged() {
        allAdapter.notifyDataSetChanged();
        myAdapter.notifyDataSetChanged();
    }
}

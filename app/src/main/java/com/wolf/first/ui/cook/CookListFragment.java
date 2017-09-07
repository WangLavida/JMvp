package com.wolf.first.ui.cook;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.wolf.first.R;
import com.wolf.first.adapter.CookListAdapter;
import com.wolf.first.app.Constant;
import com.wolf.first.base.BaseBean;
import com.wolf.first.base.BaseFragment;
import com.wolf.first.bean.CategoryInfoBean;
import com.wolf.first.bean.CookInfo;
import com.wolf.first.bean.CookResult;
import com.wolf.first.contract.CookListContract;
import com.wolf.first.model.CookListModel;
import com.wolf.first.presenter.CookListPresenter;
import com.wolf.first.view.MyDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


public class CookListFragment extends BaseFragment<CookListPresenter, CookListModel> implements CookListContract.View {

    @Bind(R.id.recycler_view)
    RecyclerView recyclerView;
    private CategoryInfoBean categoryInfoBean;
    private CookListAdapter cookListAdapter;
    private List<CookInfo> cookInfoList = new ArrayList<CookInfo>();
    private int page = 1;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            categoryInfoBean = (CategoryInfoBean) getArguments().get(Constant.CATEGORY_INFO_BEAN_KEY);
        }
    }

    public static CookListFragment newInstance(CategoryInfoBean categoryInfoBean) {
        CookListFragment fragment = new CookListFragment();
        Bundle args = new Bundle();
        args.putSerializable(Constant.CATEGORY_INFO_BEAN_KEY, categoryInfoBean);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public int setContent() {
        return R.layout.fragment_cook_list;
    }

    @Override
    public void initView() {
        initRecyclerView();
    }

    @Override
    public void initData() {
        mPresenter.getCoolInfo(categoryInfoBean.getCtgId(), page);
    }

    @Override
    public void onSuccess(BaseBean baseBean) {
        BaseBean<CookResult> successBaseBean = baseBean;
        cookListAdapter.addData(successBaseBean.getResult().getList(  ));
        cookListAdapter.notifyDataSetChanged();
        cookListAdapter.loadMoreComplete();
    }

    @Override
    public void onLoad() {

    }

    @Override
    public void onError(String msg) {

    }

    private void initRecyclerView() {
        cookListAdapter = new CookListAdapter(R.layout.cook_item, cookInfoList);
        cookListAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);
        cookListAdapter.isFirstOnly(false);
        cookListAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                page = page + 1;
                initData();
            }
        });
        cookListAdapter.setOnItemClickListener(cookListAdapter.getOnItemClickListener());
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(cookListAdapter);
        recyclerView.addItemDecoration(new MyDecoration(mContext, MyDecoration.VERTICAL_LIST));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}

package com.wolf.first.ui.menu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wolf.first.R;
import com.wolf.first.adapter.MyFragmentPagerAdapter;
import com.wolf.first.app.Constant;
import com.wolf.first.base.BaseBean;
import com.wolf.first.base.BaseFragment;
import com.wolf.first.bean.CategoryBean;
import com.wolf.first.bean.CategoryInfoBean;
import com.wolf.first.ui.contract.CookContract;
import com.wolf.first.ui.cook.CookListFragment;
import com.wolf.first.ui.model.CookModel;
import com.wolf.first.ui.presenter.CookPresenter;
import com.wolf.first.util.ViewUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


public class CookFragment extends BaseFragment<CookPresenter, CookModel> implements CookContract
        .View {

    @Bind(R.id.tab_layout)
    TabLayout tabLayout;
    @Bind(R.id.view_pager)
    ViewPager viewPager;
    private List<CategoryInfoBean> categoryInfoBeanList = new ArrayList<CategoryInfoBean>();
    private List<String> categoryNameList = new ArrayList<String>();
    private List<Fragment> fragmentList = new ArrayList<Fragment>();
    private BaseBean<CategoryBean> baseBean;

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
        initListFragment();
    }

    @Override
    public void initData() {
        List<CategoryInfoBean> test = new ArrayList<CategoryInfoBean>();
        for (CategoryBean categoryBean : baseBean.getResult().getChilds()) {
            for (CategoryBean categoryBean1 : categoryBean.getChilds()) {
                test.add(categoryBean1.getCategoryInfo());
            }
        }
        for (int i = 0; i <= 2; i++) {
            categoryInfoBeanList.add(test.get(i));
        }

    }

    public static CookFragment newInstance(BaseBean<CategoryBean> param1) {
        CookFragment fragment = new CookFragment();
        Bundle args = new Bundle();
        args.putSerializable(Constant.BASE_KEY, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            baseBean = (BaseBean<CategoryBean>) getArguments().get(Constant.BASE_KEY);
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    private void initListFragment() {
        for (CategoryInfoBean categoryInfoBean : categoryInfoBeanList) {
            categoryNameList.add(categoryInfoBean.getName());
            CookListFragment cookListFragment = new CookListFragment();
            fragmentList.add(cookListFragment);
        }
        MyFragmentPagerAdapter myFragmentPagerAdapter = new MyFragmentPagerAdapter
                (getChildFragmentManager(), fragmentList, categoryNameList);
        viewPager.setAdapter(myFragmentPagerAdapter);
        viewPager.setCurrentItem(0);
        tabLayout.setupWithViewPager(viewPager);
        ViewUtils.dynamicSetTabLayoutMode(tabLayout, mContext);
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);

        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}

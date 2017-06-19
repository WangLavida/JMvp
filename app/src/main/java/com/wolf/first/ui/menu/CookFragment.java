package com.wolf.first.ui.menu;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;

import com.wolf.first.R;
import com.wolf.first.adapter.MyFragmentPagerAdapter;
import com.wolf.first.app.Constant;
import com.wolf.first.base.BaseBean;
import com.wolf.first.base.BaseFragment;
import com.wolf.first.bean.CategoryBean;
import com.wolf.first.bean.CategoryInfoBean;
import com.wolf.first.contract.CookContract;
import com.wolf.first.model.CookModel;
import com.wolf.first.presenter.CookPresenter;
import com.wolf.first.rxBus.CategoryEvent;
import com.wolf.first.ui.cook.AddCategoryActivity;
import com.wolf.first.ui.cook.CookListFragment;
import com.wolf.first.util.MyLog;
import com.wolf.first.rxBus.RxBus;
import com.wolf.first.util.ViewUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

import static android.R.attr.name;
import static android.R.attr.y;


public class CookFragment extends BaseFragment<CookPresenter, CookModel> implements CookContract
        .View {

    @Bind(R.id.tab_layout)
    TabLayout tabLayout;
    @Bind(R.id.view_pager)
    ViewPager viewPager;
    @Bind(R.id.add_image)
    ImageView addImage;
    //所有的类别
    private List<CategoryInfoBean> categoryInfoBeanList = new ArrayList<CategoryInfoBean>();
    //tabLayout标题
    private List<String> categoryNameList = new ArrayList<String>();
    private List<Fragment> fragmentList = new ArrayList<Fragment>();
    //请求返回数据
    private BaseBean<CategoryBean> baseBean;
    //已经添加的类别
    private List<CategoryInfoBean> myList = new ArrayList<CategoryInfoBean>();
    private RxBus rxBus;
    private MyFragmentPagerAdapter myFragmentPagerAdapter;

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
        if (baseBean == null) {
            mPresenter.getCategory();
        } else {
            for (CategoryBean categoryBean : baseBean.getResult().getChilds().get(0).getChilds()) {
                categoryInfoBeanList.add(categoryBean.getCategoryInfo());
            }
            mPresenter.getDBCategory();
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
        initRxBus();

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    private void initListFragment() {
        for (CategoryInfoBean categoryInfoBean : myList) {
            categoryNameList.add(categoryInfoBean.getName());
            fragmentList.add(newFragment(categoryInfoBean));
        }
        myFragmentPagerAdapter = new MyFragmentPagerAdapter
                (getChildFragmentManager(), fragmentList, categoryNameList);
        viewPager.setAdapter(myFragmentPagerAdapter);
        viewPager.setCurrentItem(0);
        tabLayout.setupWithViewPager(viewPager);
        ViewUtils.dynamicSetTabLayoutMode(tabLayout, mContext);
    }

    private CookListFragment newFragment(CategoryInfoBean categoryInfoBean) {
        CookListFragment cookListFragment = CookListFragment.newInstance(categoryInfoBean);
        return cookListFragment;
    }

    @Override
    public void onSuccess(BaseBean baseBean) {
        this.baseBean = baseBean;
        initView();
    }

    @Override
    public void onLoad() {

    }

    @Override
    public void onError(String msg) {

    }


    private void initRxBus() {
        RxBus.getInstance().register(CategoryEvent.class).subscribe(new Consumer<CategoryEvent>() {
            @Override
            public void accept(@NonNull CategoryEvent categoryEvent) throws Exception {

                switch (categoryEvent.getEvent()) {
                    case CategoryEvent.ADD_EVENT:
                        String name = categoryEvent.getCategoryInfoBean().getName();
                        myFragmentPagerAdapter.addItem(newFragment(categoryEvent.getCategoryInfoBean()), name);
                        myList.add(categoryEvent.getCategoryInfoBean());
                        break;
                    case CategoryEvent.DEL_EVENT:
                        String name1 = categoryEvent.getCategoryInfoBean().getName();
                        viewPager.setCurrentItem(0);
                        myFragmentPagerAdapter.delItem(name1);
                        Iterator<CategoryInfoBean> it = myList.iterator();
                        while (it.hasNext()) {
                            CategoryInfoBean categoryInfoBean = it.next();
                            if (categoryInfoBean.getName().equals(name1)) {
                                it.remove();
                            }
                        }
                        break;
                    case CategoryEvent.MOVE_EVENT:
                        myFragmentPagerAdapter.swapItems(categoryEvent.getFrom(), categoryEvent
                                .getTo());
                        Collections.swap(myList, categoryEvent.getFrom(), categoryEvent
                                .getTo());
                        break;
                }
                ViewUtils.dynamicSetTabLayoutMode(tabLayout, mContext);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
        rxBus.unregisterAll();
    }

    @OnClick(R.id.add_image)
    public void onViewClicked() {
        Intent intent = new Intent(mContext, AddCategoryActivity.class);
        Bundle b = new Bundle();
        b.putSerializable(Constant.ALL_LIST_KEY, (Serializable) categoryInfoBeanList);
        b.putSerializable(Constant.MY_LIST_KEY, (Serializable) myList);
        intent.putExtras(b);
        startActivity(intent);
    }

    @Override
    public void getDBCategory(List<CategoryInfoBean> categoryInfoBeanList) {
        myList.addAll(categoryInfoBeanList);
        if (myList.size() == 0) {
            for (CategoryInfoBean categoryInfoBean : this.categoryInfoBeanList) {
                if (categoryInfoBean.getName().equals("荤菜")) {
                    myList.add(categoryInfoBean);
                    mPresenter.saveCategory(categoryInfoBean);
                }
            }
        }
        initListFragment();
    }
}

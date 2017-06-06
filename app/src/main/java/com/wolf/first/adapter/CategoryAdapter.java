package com.wolf.first.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wolf.first.R;
import com.wolf.first.bean.CategoryInfoBean;

import java.util.List;

/**
 * Created by W.J on 2017/6/6.
 */

public class CategoryAdapter extends BaseQuickAdapter<CategoryInfoBean, BaseViewHolder> {
    public CategoryAdapter(@LayoutRes int layoutResId, @Nullable List<CategoryInfoBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CategoryInfoBean item) {
        helper.setText(R.id.name_text, item.getName());
    }
}

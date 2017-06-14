package com.wolf.first.adapter;

import android.graphics.Color;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wolf.first.R;
import com.wolf.first.bean.CategoryInfoBean;

import java.util.List;

/**
 * Created by W.J on 2017/6/6.
 */

public class CategoryAdapter extends BaseQuickAdapter<CategoryInfoBean, BaseViewHolder> {
    private int layoutResId;
    public CategoryAdapter(@LayoutRes int layoutResId, @Nullable List<CategoryInfoBean> data) {
        super(layoutResId, data);
        this.layoutResId = layoutResId;
    }

    @Override
    protected void convert(BaseViewHolder helper, CategoryInfoBean item) {
        if (layoutResId == R.layout.catergory_item){
            if (item.getName().equals("荤菜")){
                TextView nameText = helper.getView(R.id.name_text);
                nameText.setTextColor(Color.parseColor("#5c5c5c"));
            }
        }
        helper.setText(R.id.name_text, item.getName());
    }
}

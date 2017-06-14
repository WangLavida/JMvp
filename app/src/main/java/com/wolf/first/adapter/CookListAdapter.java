package com.wolf.first.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wolf.first.R;
import com.wolf.first.bean.CookInfo;
import com.wolf.first.util.ImageUtil;
import com.wolf.first.util.MyLog;

import java.util.List;

/**
 * Created by W.J on 2017/6/14.
 */

public class CookListAdapter extends BaseQuickAdapter<CookInfo, BaseViewHolder> {
    public CookListAdapter(@LayoutRes int layoutResId, @Nullable List<CookInfo> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CookInfo item) {
        if (item.getThumbnail() == null){
            item.setThumbnail("");
        }
        ImageView imageView = helper.getView(R.id.image_view);
        ImageUtil.loadImage(mContext, imageView, item.getThumbnail(), R.mipmap.cook_error_icon, R.mipmap.cook_error_icon, R.mipmap.cook_error_icon, false);
        helper.setText(R.id.name_text, item.getName());
        helper.setText(R.id.sumary_text, item.getRecipe().getSumary());
    }
}

package com.wolf.first.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wolf.first.R;
import com.wolf.first.bean.ToolInfo;
import com.wolf.first.util.ImageUtil;

import java.util.List;

/**
 * Created by W.J on 2017/9/7.
 */

public class ToolAdapter extends BaseQuickAdapter<ToolInfo,BaseViewHolder>{
    public ToolAdapter(@LayoutRes int layoutResId, @Nullable List<ToolInfo> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ToolInfo item) {
        ImageView imageView = helper.getView(R.id.image_view);
        Glide.with(mContext).load(item.getIcon()).into(imageView);
        helper.setText(R.id.name_text, item.getName());
    }
}

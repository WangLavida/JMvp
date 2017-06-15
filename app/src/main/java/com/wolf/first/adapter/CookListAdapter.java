package com.wolf.first.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wolf.first.R;
import com.wolf.first.app.Constant;
import com.wolf.first.bean.CookInfo;
import com.wolf.first.ui.cook.CookDetailActivity;
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
        if (item.getThumbnail() == null) {
            item.setThumbnail("");
        }
        ImageView imageView = helper.getView(R.id.image_view);
        ImageUtil.loadImage(mContext, imageView, item.getThumbnail(), R.mipmap.cook_error_icon, R.mipmap.cook_error_icon, R.mipmap.cook_error_icon, false);
        helper.setText(R.id.name_text, item.getName());
        helper.setText(R.id.sumary_text, item.getRecipe().getSumary());
    }
    @Override
    public void setOnItemClickListener(@Nullable OnItemClickListener listener) {
        super.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ActivityOptionsCompat option = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity)mContext,
                        new Pair<View, String>(view.findViewById(R.id.image_view),((Activity)mContext).getString(R.string.image_view)));
                Intent intent = new Intent(mContext, CookDetailActivity.class);
                Bundle b = new Bundle();
                b.putSerializable(Constant.COOK_INFO_KEY, getData().get(position));
                intent.putExtras(b);
                ActivityCompat.startActivity(mContext, intent, option.toBundle());
            }
        });
    }
}

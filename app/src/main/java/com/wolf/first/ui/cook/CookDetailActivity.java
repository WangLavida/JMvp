package com.wolf.first.ui.cook;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.google.gson.Gson;
import com.wolf.first.R;
import com.wolf.first.app.Constant;
import com.wolf.first.base.BaseActivity;
import com.wolf.first.bean.CookInfo;
import com.wolf.first.util.ImageUtil;

import java.util.List;
import java.util.Map;

import butterknife.Bind;

public class CookDetailActivity extends BaseActivity {

    @Bind(R.id.tool_bar)
    Toolbar toolBar;
    @Bind(R.id.image_view)
    ImageView imageView;
    @Bind(R.id.title_text)
    TextView titleText;
    @Bind(R.id.ingredients)
    TextView ingredients;
    @Bind(R.id.table_layout)
    TableLayout tableLayout;
    @Bind(R.id.collapsing_toolbar_layout)
    CollapsingToolbarLayout collapsingToolbarLayout;
    private CookInfo cookInfo;
    private LayoutInflater layoutInflater;

    @Override
    public int getLayoutId() {
        return R.layout.activity_cook_detail;
    }

    @Override
    public void initView() {
        collapsingToolbarLayout.setTitle(cookInfo.getName());
        setSupportActionBar(toolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        if (cookInfo.getRecipe().getImg() == null) {
            cookInfo.getRecipe().setImg("");
        }
        ImageUtil.loadImage(mContext, imageView, cookInfo.getRecipe().getImg(), R.mipmap.cook_error_icon, R.mipmap.cook_error_icon, R.mipmap.cook_error_icon, false);
        titleText.setText(cookInfo.getRecipe().getTitle());
        if (cookInfo.getRecipe().getIngredients() == null) {
            cookInfo.getRecipe().setIngredients("");
        } else {
            String ingredientsStr = cookInfo.getRecipe().getIngredients();
            ingredientsStr = ingredientsStr.substring(2, ingredientsStr.length() - 2);
            ingredients.setText("准备：\n" + ingredientsStr);
        }
        Gson gson = new Gson();
        List<Map<String, String>> methodList = gson.fromJson(cookInfo.getRecipe().getMethod(), List.class);
        for (int i = 0; i < methodList.size(); i++) {
            TableRow tableRow = new TableRow(this);
            View rowView = layoutInflater.inflate(R.layout.method_row, null);
            ImageView imgView = (ImageView) rowView.findViewById(R.id.method_img);
            TextView stpeView = (TextView) rowView.findViewById(R.id.method_step);
            if (methodList.get(i).get("img") == null) {
                methodList.get(i).put("img", "");
            }
            ImageUtil.loadImage(mContext, imgView, methodList.get(i).get("img"), R.mipmap.cook_error_icon, R.mipmap.cook_error_icon, R.mipmap.cook_error_icon, false);
            stpeView.setText(methodList.get(i).get("step"));
            tableRow.addView(rowView);
            tableLayout.addView(tableRow);
        }
    }

    @Override
    public void initData() {
        layoutInflater = LayoutInflater.from(mContext);
        cookInfo = (CookInfo) getIntent().getExtras().get(Constant.COOK_INFO_KEY);
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}

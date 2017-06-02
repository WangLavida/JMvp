package com.wolf.first.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.CacheUtils;
import com.blankj.utilcode.util.StringUtils;
import com.luck.picture.lib.model.PictureConfig;
import com.wolf.first.R;
import com.wolf.first.base.BaseActivity;
import com.wolf.first.util.ImageUtil;
import com.wolf.first.util.MyLog;
import com.wolf.first.util.ToastUtil;
import com.yalantis.ucrop.entity.LocalMedia;

import java.util.List;

import butterknife.Bind;
import me.drakeet.materialdialog.MaterialDialog;

import static com.wolf.first.app.Constant.HEADER_KEY;
import static com.wolf.first.app.Constant.NAME_KEY;

public class MenuActivity extends BaseActivity {

    @Bind(R.id.tool_bar)
    Toolbar toolBar;
    @Bind(R.id.draw_layout)
    DrawerLayout drawLayout;
    @Bind(R.id.navigation_view)
    NavigationView navigationView;
    private ActionBarDrawerToggle mDrawerToggle;
    private View headerView;
    private ImageView headerImage;
    private TextView nameText;


    @Override
    public int getLayoutId() {
        return R.layout.activity_menu;
    }

    @Override
    public void initView() {
        //获取头布局文件
        headerView = navigationView.getHeaderView(0);
        headerImage = (ImageView) headerView.findViewById(R.id.header_image);
        nameText = (TextView) headerView.findViewById(R.id.name_text);
        headerImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageUtil.selPhoto(MenuActivity.this, resultCallback);

            }
        });
        nameText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setName();
            }
        });
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.set:
                        break;
                    case R.id.about:
                        break;
                }
                return true;
            }
        });
        showHeaderName();

        toolBar.setTitle("首页");
        setSupportActionBar(toolBar);
        getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //创建返回键，并实现打开关/闭监听
        mDrawerToggle = new ActionBarDrawerToggle(this, drawLayout, toolBar, R.string.open, R.string.close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        mDrawerToggle.syncState();
        drawLayout.setDrawerListener(mDrawerToggle);
        //去阴影
        drawLayout.setScrimColor(Color.TRANSPARENT);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public static void startTest(Activity activity) {
        Intent intent = new Intent(activity, MenuActivity.class);
        activity.startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(false);
    }

    /**
     * 图片回调方法
     */
    private PictureConfig.OnSelectResultCallback resultCallback = new PictureConfig.OnSelectResultCallback() {
        @Override
        public void onSelectSuccess(List<LocalMedia> resultList) {
            // 多选回调
        }

        @Override
        public void onSelectSuccess(LocalMedia media) {
            // 单选回调
            // 裁剪过
            String path = "";
            if (media.isCut() && !media.isCompressed()) {
                // 裁剪过
                path = media.getCutPath();
            } else if (media.isCompressed() || (media.isCut() && media.isCompressed())) {
                // 压缩过,或者裁剪同时压缩过,以最终压缩过图片为准
                path = media.getCompressPath();
            } else {
                // 原图地址
                path = media.getPath();
            }
            MyLog.i("裁剪返回", path + "");
            CacheUtils.get(mContext).put(HEADER_KEY, path);
            showHeaderName();
        }
    };

    /**
     * 显示头像姓名
     */
    private void showHeaderName() {
        String headerPath = CacheUtils.get(mContext).getAsString(HEADER_KEY);
        if (!StringUtils.isEmpty(headerPath)) {
            ImageUtil.loadImage(mContext, headerImage, headerPath, R.mipmap.header_icon, R.mipmap.header_icon, R.mipmap.header_icon, true);
        }
        String name = CacheUtils.get(mContext).getAsString(NAME_KEY);
        nameText.setText(TextUtils.isEmpty(name) ? "起个名吧" : name);

    }

    private void setName() {
        final EditText contentView = new EditText(this);
        contentView.setTextColor(Color.parseColor("#5c5c5c"));
        contentView.setSingleLine();
        final MaterialDialog mMaterialDialog = new MaterialDialog(this);
        mMaterialDialog
                .setContentView(contentView)
                .setPositiveButton("就这个了", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (TextUtils.isEmpty(contentView.getText().toString())) {
                            ToastUtil.showLong("写个名字啊");
                        } else {
                            mMaterialDialog.dismiss();
                            CacheUtils.get(mContext).put(NAME_KEY, contentView.getText().toString());
                            showHeaderName();
                        }
                    }
                }).setNegativeButton("不起了", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMaterialDialog.dismiss();
            }
        });
        mMaterialDialog.setTitle("起个名字吧");
        mMaterialDialog.show();
    }
}

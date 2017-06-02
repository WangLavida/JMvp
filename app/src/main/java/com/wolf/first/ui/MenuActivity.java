package com.wolf.first.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
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
import com.wolf.first.adapter.MyFragmentPagerAdapter;
import com.wolf.first.base.BaseActivity;
import com.wolf.first.ui.menu.CookFragment;
import com.wolf.first.ui.menu.ToolFragment;
import com.wolf.first.util.ImageUtil;
import com.wolf.first.util.MyLog;
import com.wolf.first.util.ToastUtil;
import com.yalantis.ucrop.entity.LocalMedia;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;
import me.drakeet.materialdialog.MaterialDialog;

import static com.wolf.first.R.id.set;
import static com.wolf.first.app.Constant.HEADER_KEY;
import static com.wolf.first.app.Constant.NAME_KEY;

public class MenuActivity extends BaseActivity {

    @Bind(R.id.tool_bar)
    Toolbar toolBar;
    @Bind(R.id.draw_layout)
    DrawerLayout drawLayout;
    @Bind(R.id.navigation_view)
    NavigationView navigationView;
    @Bind(R.id.cook_image)
    ImageView cookImage;
    @Bind(R.id.tool_image)
    ImageView toolImage;
    @Bind(R.id.view_pager)
    ViewPager viewPager;
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
        initHeaderView();
        initViewPager();
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

    private void initHeaderView() {
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
                    case set:
                        break;
                    case R.id.about:
                        break;
                }
                return true;
            }
        });
        showHeaderName();

//        toolBar.setTitle("首页");

        setSupportActionBar(toolBar);
        getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //去除默认Title显示
        getSupportActionBar().setDisplayShowTitleEnabled(false);
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

    private void initViewPager() {
        ArrayList<Fragment> fragmentList = new ArrayList<Fragment>();
        fragmentList.add(new CookFragment());
        fragmentList.add(new ToolFragment());
        MyFragmentPagerAdapter myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), fragmentList);
        viewPager.setAdapter(myFragmentPagerAdapter);
        viewPager.setOffscreenPageLimit(2);
        viewPager.setCurrentItem(0);
        cookImage.setSelected(true);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                onSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
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
     * ViewPager切换和点击图标
     *
     * @param position
     */
    private void onSelected(int position) {
        switch (position) {
            case 0:
                cookImage.setSelected(true);
                toolImage.setSelected(false);
                break;
            case 1:
                cookImage.setSelected(false);
                toolImage.setSelected(true);
                break;
        }
    }

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

    @OnClick({R.id.cook_image, R.id.tool_image})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.cook_image:
                onSelected(0);
                viewPager.setCurrentItem(0);
                break;
            case R.id.tool_image:
                onSelected(1);
                viewPager.setCurrentItem(1);
                break;
        }
    }
}

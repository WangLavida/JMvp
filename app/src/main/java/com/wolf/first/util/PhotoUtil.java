package com.wolf.first.util;

import android.Manifest;
import android.app.Activity;
import android.support.v4.content.ContextCompat;

import com.luck.picture.lib.model.FunctionConfig;
import com.luck.picture.lib.model.FunctionOptions;
import com.luck.picture.lib.model.PictureConfig;
import com.tbruyelle.rxpermissions2.RxPermissions;
import com.wolf.first.R;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;

import static com.luck.picture.lib.model.PictureConfig.resultCallback;

/**
 * Created by W.J on 2017/6/1.
 */

public class PhotoUtil {
    public static void selPhoto(final Activity activity) {
        RxPermissions rxPermissions = new RxPermissions(activity);
        rxPermissions
                .request(Manifest.permission.CAMERA,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE)
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        if (aBoolean) {

                            FunctionOptions options = new FunctionOptions.Builder()
                                    .setType(FunctionConfig.TYPE_IMAGE) // 图片or视频 FunctionConfig.TYPE_IMAGE  TYPE_VIDEO
                                    .setMaxSelectNum(1) // 可选择图片的数量
                                    .setMinSelectNum(1)// 图片或视频最低选择数量，默认代表无限制
                                    .setSelectMode(FunctionConfig.MODE_SINGLE) // 单选 or 多选 FunctionConfig.MODE_SINGLE FunctionConfig.MODE_MULTIPLE
                                    .setShowCamera(true) //是否显示拍照选项 这里自动根据type 启动拍照或录视频
                                    .setEnablePreview(true) // 是否打开预览选项
                                    .setEnableCrop(true) // 是否打开剪切选项
                                    .setCircularCut(true)// 是否采用圆形裁剪
                                    .setCustomQQ_theme(0)// 可自定义QQ数字风格，不传就默认是蓝色风格
//                                    .setPreviewColor() //预览字体颜色
                                    .setCompleteColor(R.color.textColorPrimary) //已完成字体颜色
//                                    .setPreviewTopBgColor()//预览图片标题背景色
//                                    .setPreviewBottomBgColor(R.color.colorWhite) //预览底部背景色
                                    .setBottomBgColor(R.color.colorWhite) //图片列表底部背景色
//                                    .setGrade() // 压缩档次 默认三档
                                    .setCheckNumMode(true) //QQ选择风格
//                                    .setCompressQuality() // 图片裁剪质量,默认无损
                                    .setImageSpanCount(3) // 每行个数
//                                    .setSelectMedia() // 已选图片，传入在次进去可选中，不能传入网络图片
//                                    .setCompressFlag() // 1 系统自带压缩 2 luban压缩
//                                    .setCompressW() // 压缩宽 如果值大于图片原始宽高无效
//                                    .setCompressH() // 压缩高 如果值大于图片原始宽高无效
                                    .setThemeStyle(ContextCompat.getColor(activity, R.color.colorPrimary)) // 设置主题样式
                                    .setPicture_title_color(R.color.colorWhite) // 设置标题字体颜色
                                    .setPicture_right_color(R.color.colorWhite) // 设置标题右边字体颜色
//                                    .setLeftBackDrawable() // 设置返回键图标
                                    .setStatusBar(R.color.colorPrimary) // 设置状态栏颜色，默认是和标题栏一致
                                    .setImmersive(false)// 是否改变状态栏字体颜色(黑色)
                                    .setNumComplete(false) // 0/9 完成  样式
//                                    .setClickVideo()// 点击声音
                                    .create();
                            PictureConfig.getInstance().init(options).openPhoto(activity, resultCallback);
                        } else {
                            ToastUtil.showLong("木有权限");
                        }
                    }
                });
    }
}

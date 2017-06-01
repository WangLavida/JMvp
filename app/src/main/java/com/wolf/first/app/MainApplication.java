package com.wolf.first.app;

import android.app.Application;
import android.content.Context;
import android.os.Environment;

import com.blankj.utilcode.util.FileUtils;
import com.blankj.utilcode.util.Utils;
import com.wolf.first.util.MyLog;


/**
 * Created by W.J on 2017/5/31.
 */

public class MainApplication extends Application {
    public static Context mainContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mainContext = getApplicationContext();
        Utils.init(mainContext);
        createFile();
    }

    /**
     * 创建项目所需文件
     */
    private void createFile() {
        FileUtils.createOrExistsDir(Constant.LOG_File);
        FileUtils.createOrExistsDir(Constant.HEADER_File);
        FileUtils.createOrExistsFile(Constant.LOG_File + Constant.LOG_NAME);
    }

    public static Context getContext() {
        return mainContext;
    }
}

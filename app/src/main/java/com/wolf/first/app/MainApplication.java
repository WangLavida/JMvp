package com.wolf.first.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;

import com.blankj.utilcode.util.FileUtils;
import com.blankj.utilcode.util.Utils;
import com.wolf.first.util.AppActivityManager;
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

    @Override
    public void registerActivityLifecycleCallbacks(ActivityLifecycleCallbacks callback) {
        super.registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                AppActivityManager.getAppActivityManager().addActivity(activity);
            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {

            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {

            }
        });

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

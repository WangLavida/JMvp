package com.wolf.first.util;

import android.util.Log;

import com.socks.library.KLog;
import com.wolf.first.app.Constant;
import com.wolf.first.app.MainApplication;

import java.io.File;

/**
 * Created by W.J on 2017/5/31.
 */

public class MyLog {
    public static void i(String TAG, String msg) {
        KLog.i(TAG, msg);
    }
    public static void d(String msg) {
        KLog.d(msg);
    }

    /**
     * 输出到sd卡
     *
     * @param TAG
     * @param msg
     */
    public static void f(String TAG, String msg) {
        KLog.i(TAG, msg);
        KLog.file(TAG, new File(Constant.LOG_File),Constant.LOG_NAME,msg);
    }
}

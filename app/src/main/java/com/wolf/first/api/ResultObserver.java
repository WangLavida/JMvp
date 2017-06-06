package com.wolf.first.api;

import com.blankj.utilcode.util.NetworkUtils;
import com.google.gson.Gson;
import com.wolf.first.base.BaseView;
import com.wolf.first.util.MyLog;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by W.J on 2017/5/25.
 */

public class ResultObserver<T> implements Observer<T> {
    private BaseView mView;

    public ResultObserver(BaseView mView) {
        this.mView = mView;
    }

    @Override
    public void onSubscribe(Disposable d) {
        if (!NetworkUtils.isConnected()) {
            mView.onError("网络无法连接");
            d.dispose();
        }
    }

    @Override
    public void onNext(T t) {
        Gson gson = new Gson();
        String tStr = gson.toJson(t, t.getClass());
        MyLog.i("返回数据", tStr);
    }

    @Override
    public void onError(Throwable e) {
        MyLog.i("onError",e.getMessage());

    }

    @Override
    public void onComplete() {

    }
}

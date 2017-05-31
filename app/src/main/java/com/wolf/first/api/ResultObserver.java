package com.wolf.first.api;

import android.util.Log;

import com.google.gson.Gson;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by W.J on 2017/5/25.
 */

public class ResultObserver<T> implements Observer<T> {
    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(T t) {
        Gson gson = new Gson();
        String tStr = gson.toJson(t,t.getClass());
        Log.i("返回数据",tStr);
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onComplete() {

    }
}

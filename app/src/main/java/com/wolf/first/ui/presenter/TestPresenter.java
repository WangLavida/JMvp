package com.wolf.first.ui.presenter;

import com.wolf.first.api.ResultObserver;
import com.wolf.first.bean.TestBean;
import com.wolf.first.ui.contract.TestContract;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by W.J on 2017/5/31.
 */

public class TestPresenter extends TestContract.Presenter{
    @Override
    public void getNews() {
        mModel.getNews().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new ResultObserver<TestBean>(){
            @Override
            public void onSubscribe(Disposable d) {
                super.onSubscribe(d);
            }

            @Override
            public void onNext(TestBean testBean) {
                super.onNext(testBean);
                mView.onSuccess(testBean.getList().get(0).getImgurl());
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
            }

            @Override
            public void onComplete() {
                super.onComplete();
            }
        });
    }
}

package com.wolf.first.presenter;

import com.wolf.first.api.ResultObserver;
import com.wolf.first.base.BaseBean;
import com.wolf.first.bean.CookResult;
import com.wolf.first.contract.CookListContract;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by W.J on 2017/6/14.
 */

public class CookListPresenter extends CookListContract.Presenter {
    @Override
    public void getCoolInfo(String cid, int page) {
        mModel.getCoolInfo(cid, page).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new ResultObserver<BaseBean<CookResult>>(mView) {
            @Override
            public void onSubscribe(Disposable d) {
                super.onSubscribe(d);
            }

            @Override
            public void onNext(BaseBean<CookResult> cookResultBaseBean) {
                super.onNext(cookResultBaseBean);
                mView.onSuccess(cookResultBaseBean);
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

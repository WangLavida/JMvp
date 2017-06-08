package com.wolf.first.presenter;

import com.wolf.first.bean.CategoryInfoBean;
import com.wolf.first.contract.AddCategoryContract;
import com.wolf.first.rxBus.CategoryEvent;
import com.wolf.first.rxBus.RxBus;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by W.J on 2017/6/6.
 */

public class AddCategoryPresenter extends AddCategoryContract.Presenter {
    @Override
    public void saveCategory(final CategoryInfoBean categoryInfoBean) {
        mModel.saveCategory(categoryInfoBean).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Object o) {

            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {
                CategoryEvent categoryEvent = new CategoryEvent(CategoryEvent.ADD_EVENT, categoryInfoBean);
                RxBus rxBus = RxBus.getInstance();
                if(rxBus.hasSubscribers()){
                    rxBus.post(categoryEvent);
                }
            }
        });
    }

    @Override
    public void deleteCategory(final CategoryInfoBean categoryInfoBean) {
        mModel.deleteCategory(categoryInfoBean).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Object o) {

            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {
                CategoryEvent categoryEvent = new CategoryEvent(CategoryEvent.DEL_EVENT, categoryInfoBean);
                RxBus rxBus = RxBus.getInstance();
                if(rxBus.hasSubscribers()){
                    rxBus.post(categoryEvent);
                }
            }
        });
    }
}

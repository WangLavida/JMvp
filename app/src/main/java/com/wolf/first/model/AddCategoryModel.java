package com.wolf.first.model;

import com.wolf.first.base.BaseModel;
import com.wolf.first.bean.CategoryInfoBean;
import com.wolf.first.bean.greendao.CategoryInfoBeanDao;
import com.wolf.first.contract.AddCategoryContract;
import com.wolf.first.dao.EntityManager;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;

/**
 * Created by W.J on 2017/6/6.
 */

public class AddCategoryModel implements AddCategoryContract.Model {
    @Override
    public Observable saveCategory(final CategoryInfoBean categoryInfoBean) {
        Observable observable = Observable.create(new ObservableOnSubscribe<Boolean>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Boolean> e) throws Exception {
                getDao().save(categoryInfoBean);
                e.onComplete();
            }
        });
        return observable;
    }

    @Override
    public Observable deleteCategory(final CategoryInfoBean categoryInfoBean) {

        Observable observable = Observable.create(new ObservableOnSubscribe<Boolean>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Boolean> e) throws Exception {
                getDao().delete(categoryInfoBean);
                e.onComplete();
            }
        });
        return observable;
    }

    @Override
    public Observable MoveCategory(int from, CategoryInfoBean formCategoryInfoBean, int to, CategoryInfoBean toCategoryInfoBean) {
        Observable observable = Observable.create(new ObservableOnSubscribe<Boolean>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Boolean> e) throws Exception {
                e.onComplete();
            }
        });
        return observable;
    }


    private CategoryInfoBeanDao getDao() {
        return EntityManager.getInstance().getCategoryInfoBeanDao();

    }
}

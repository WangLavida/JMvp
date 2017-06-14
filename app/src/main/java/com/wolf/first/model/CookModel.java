package com.wolf.first.model;

import com.wolf.first.api.Api;
import com.wolf.first.api.ApiCookService;
import com.wolf.first.app.Constant;
import com.wolf.first.base.BaseBean;
import com.wolf.first.bean.CategoryBean;
import com.wolf.first.bean.CategoryInfoBean;
import com.wolf.first.bean.greendao.CategoryInfoBeanDao;
import com.wolf.first.contract.CookContract;
import com.wolf.first.dao.EntityManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;

/**
 * Created by W.J on 2017/6/2.
 */

public class CookModel implements CookContract.Model {
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
    public Observable<BaseBean<CategoryBean>> getCategory() {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("key", Constant.APP_KEY);
        return Api.getInstance().createService(ApiCookService.class).getCategory(params);
    }

    @Override
    public Observable<List<CategoryInfoBean>> getDBCategory() {
        Observable<List<CategoryInfoBean>> observable = Observable.create(new ObservableOnSubscribe<List<CategoryInfoBean>>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<List<CategoryInfoBean>> e) throws Exception {
                List<CategoryInfoBean> categoryInfoBeanList = getDao().queryBuilder().build().list();
                e.onNext(categoryInfoBeanList);
            }
        });
        return observable;
    }

    private CategoryInfoBeanDao getDao() {
        return EntityManager.getInstance().getCategoryInfoBeanDao();

    }
}

package com.wolf.first.contract;

import com.wolf.first.base.BaseBean;
import com.wolf.first.base.BaseModel;
import com.wolf.first.base.BasePresenter;
import com.wolf.first.base.BaseView;
import com.wolf.first.bean.CategoryBean;
import com.wolf.first.bean.CategoryInfoBean;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by W.J on 2017/6/2.
 */

public interface CookContract {
    interface Model extends BaseModel {
        Observable<BaseBean<CategoryBean>> getCategory();
        Observable<List<CategoryInfoBean>> getDBCategory();
    }

    interface View extends BaseView {
        void getDBCategory(List<CategoryInfoBean> categoryInfoBeanList);
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getCategory();
        public abstract void getDBCategory();
    }
}

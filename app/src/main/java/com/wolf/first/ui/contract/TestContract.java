package com.wolf.first.ui.contract;

import com.wolf.first.base.BaseModel;
import com.wolf.first.base.BasePresenter;
import com.wolf.first.base.BaseView;
import com.wolf.first.bean.TestBean;

import io.reactivex.Observable;

/**
 * Created by W.J on 2017/5/31.
 */

public interface TestContract {
    interface View extends BaseView {

    }

    interface Model extends BaseModel {
        Observable<TestBean> getNews();
    }

    abstract class Presenter extends BasePresenter<View,Model> {
        public abstract void getNews();
    }
}

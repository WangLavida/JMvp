package com.wolf.first.contract;

import com.wolf.first.base.BaseBean;
import com.wolf.first.base.BaseModel;
import com.wolf.first.base.BasePresenter;
import com.wolf.first.base.BaseView;
import com.wolf.first.bean.CategoryBean;

import io.reactivex.Observable;

/**
 * Created by Wolf on 2017/6/4.
 */

public interface SplashContract {
    interface Model extends BaseModel{
        Observable<BaseBean<CategoryBean>> getCategory();
    }

    interface View extends BaseView{
    }

    abstract class  Presenter extends BasePresenter<View,Model>{
        public abstract void getCategory();
    }
}

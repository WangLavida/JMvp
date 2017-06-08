package com.wolf.first.contract;

import com.wolf.first.base.BaseModel;
import com.wolf.first.base.BasePresenter;
import com.wolf.first.base.BaseView;
import com.wolf.first.bean.CategoryInfoBean;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by W.J on 2017/6/6.
 */

public interface AddCategoryContract {
    interface Model extends BaseModel {
        Observable saveCategory(CategoryInfoBean categoryInfoBean);

        Observable deleteCategory(CategoryInfoBean categoryInfoBean);

    }


    interface View extends BaseView {

    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void saveCategory(CategoryInfoBean categoryInfoBean);
        public abstract void deleteCategory(CategoryInfoBean categoryInfoBean);

    }
}

package com.wolf.first.presenter;

import com.wolf.first.bean.CategoryInfoBean;
import com.wolf.first.contract.AddCategoryContract;

/**
 * Created by W.J on 2017/6/6.
 */

public class AddCategoryPresenter extends AddCategoryContract.Presenter {
    @Override
    public void saveCategory(CategoryInfoBean categoryInfoBean) {
        mModel.saveCategory(categoryInfoBean);
    }

    @Override
    public void deleteCategory(CategoryInfoBean categoryInfoBean) {
        mModel.deleteCategory(categoryInfoBean);
    }
}

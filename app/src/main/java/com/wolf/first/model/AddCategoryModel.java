package com.wolf.first.model;

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
    public void saveCategory(CategoryInfoBean categoryInfoBean) {
        getDao().save(categoryInfoBean);
    }

    @Override
    public void deleteCategory(CategoryInfoBean categoryInfoBean) {
        getDao().delete(categoryInfoBean);
    }



    private CategoryInfoBeanDao getDao() {
        return EntityManager.getInstance().getCategoryInfoBeanDao();

    }
}

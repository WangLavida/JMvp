package com.wolf.first.contract;

import com.wolf.first.base.BaseModel;
import com.wolf.first.base.BasePresenter;
import com.wolf.first.base.BaseView;

/**
 * Created by W.J on 2017/5/31.
 */

public interface MenuContract {
    interface Model extends BaseModel{
    }

    interface View extends BaseView{
    }

    abstract class Presenter extends BasePresenter<View,Model>{
    }
}

package com.wolf.first.contract;

import com.wolf.first.base.BaseBean;
import com.wolf.first.base.BaseModel;
import com.wolf.first.base.BasePresenter;
import com.wolf.first.base.BaseView;
import com.wolf.first.bean.CookResult;

import io.reactivex.Observable;

/**
 * Created by W.J on 2017/6/14.
 */

public interface CookListContract {
    interface Model extends BaseModel{
        Observable<BaseBean<CookResult>> getCoolInfo(String cid, int page);
    }

    interface View extends BaseView{
    }

    abstract class Presenter extends BasePresenter<View,Model>{
        public abstract void getCoolInfo(String cid,int page);
    }
}

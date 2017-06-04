package com.wolf.first.base;

/**
 * Created by W.J on 2017/5/22.
 */

public interface BaseView<T extends BasePresenter> {
    void onSuccess(BaseBean baseBean);

    void onLoad();

    void onError(String msg);
}

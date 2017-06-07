package com.wolf.first.model;

import com.wolf.first.api.Api;
import com.wolf.first.api.ApiCookService;
import com.wolf.first.app.Constant;
import com.wolf.first.base.BaseBean;
import com.wolf.first.bean.CategoryBean;
import com.wolf.first.contract.SplashContract;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;

/**
 * Created by Wolf on 2017/6/4.
 */

public class SplashModel implements SplashContract.Model {
    @Override
    public Observable<BaseBean<CategoryBean>> getCategory() {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("key", Constant.APP_KEY);
        return Api.getInstance().createService(ApiCookService.class).getCategory(params);
    }
}

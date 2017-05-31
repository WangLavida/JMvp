package com.wolf.first.ui.model;

import com.wolf.first.api.Api;
import com.wolf.first.api.ApiService;
import com.wolf.first.bean.TestBean;
import com.wolf.first.ui.contract.TestContract;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;

/**
 * Created by W.J on 2017/5/31.
 */

public class TestModel implements TestContract.Model{
    @Override
    public Observable<TestBean> getNews() {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("type", "war");
        params.put("page", 1);
        params.put("limit", 10);
        return Api.getInstance().createService(ApiService.class).getNews(params);
    }
}

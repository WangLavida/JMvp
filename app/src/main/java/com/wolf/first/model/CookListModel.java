package com.wolf.first.model;

import com.wolf.first.api.Api;
import com.wolf.first.api.ApiCookService;
import com.wolf.first.app.Constant;
import com.wolf.first.base.BaseBean;
import com.wolf.first.bean.CookResult;
import com.wolf.first.contract.CookListContract;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;

/**
 * Created by W.J on 2017/6/14.
 */

public class CookListModel implements CookListContract.Model {

    @Override
    public Observable<BaseBean<CookResult>> getCoolInfo(String cid, int page) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("key", Constant.APP_KEY);
        params.put("cid", cid);
        params.put("page", page);
        params.put("page", page);
        params.put("size", Constant.SIZE);
        return Api.getInstance().createService(ApiCookService.class).searchMenu(params);
    }
}

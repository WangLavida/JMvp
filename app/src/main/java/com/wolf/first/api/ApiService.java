package com.wolf.first.api;


import com.wolf.first.bean.TestBean;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by W.J on 2017/5/23.
 * http://wangyi.butterfly.mopaasapp.com/news/api?type=war&page=1&limit=10
 */

public interface ApiService {
    String BASE_URL = Url.BASE_URL;
    @GET("news/api")
    io.reactivex.Observable<TestBean> getNews(@QueryMap Map<String, Object> params);
}

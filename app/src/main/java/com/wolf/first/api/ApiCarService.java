package com.wolf.first.api;

import com.wolf.first.bean.TestBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by W.J on 2017/6/2.
 */

public interface ApiCarService {
    String BASE_URL = Url.CAR_BASE_URL;

    /**
     * 查询所有汽车品牌、车系名称
     *
     * @param params
     * @return
     */
    @GET("car/brand/query")
    Observable<TestBean> getBrand(@QueryMap Map<String, Object> params);

    /**
     * 根据车系名称查询车型
     *
     * @param params
     * @return
     */
    @GET("car/seriesname/query")
    Observable<TestBean> getSeriesname(@QueryMap Map<String, Object> params);

    /**
     * 根据车系id查询车型详细信息。 所有车型详细信息 0：未配置；1：标配。
     *
     * @param params
     * @return
     */
    @GET("car/series/query")
    Observable<TestBean> getSeries(@QueryMap Map<String, Object> params);
}

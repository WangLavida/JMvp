package com.wolf.first.api;

import com.wolf.first.base.BaseBean;
import com.wolf.first.bean.CategoryBean;
import com.wolf.first.bean.CookResult;
import com.wolf.first.bean.TestBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by W.J on 2017/6/2.
 */

public interface ApiCookService {
    String BASE_URL = Url.COOK_BASE_URL;

    /**
     * 查询菜谱的所有分类
     *
     * @param params
     * @return
     */
    @GET("v1/cook/category/query")
    Observable<BaseBean<CategoryBean>> getCategory(@QueryMap Map<String, Object> params);

    /**
     * 根据标签ID/菜谱名称查询菜谱详情。
     *
     * @param params
     * @return
     */
    @GET("v1/cook/menu/search")
    Observable<BaseBean<CookResult>> searchMenu(@QueryMap Map<String, Object> params);

    /**
     * 根据菜谱ID查询菜谱详情。
     *
     * @param params
     * @return
     */
    @GET("v1/cook/menu/query")
    Observable<TestBean> queryMenu(@QueryMap Map<String, Object> params);
}

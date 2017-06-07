package com.wolf.first.dao;

import com.wolf.first.bean.greendao.CategoryInfoBeanDao;

/**
 * Created by W.J on 2017/6/7.
 */

public class EntityManager {
    private static EntityManager entityManager;
    public CategoryInfoBeanDao categoryInfoBeanDao;

    /**
     * 创建单例
     */
    public static EntityManager getInstance() {
        if (entityManager == null) {
            entityManager = new EntityManager();
        }
        return entityManager;
    }

    /**
     * 获取CategoryInfo表实例
     */
    public CategoryInfoBeanDao getCategoryInfoBeanDao() {
        categoryInfoBeanDao = DaoManger.getInstance().getDaoSession().getCategoryInfoBeanDao();
        return categoryInfoBeanDao;
    }

}

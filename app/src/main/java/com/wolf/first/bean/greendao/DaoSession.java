package com.wolf.first.bean.greendao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.wolf.first.bean.CategoryInfoBean;

import com.wolf.first.bean.greendao.CategoryInfoBeanDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig categoryInfoBeanDaoConfig;

    private final CategoryInfoBeanDao categoryInfoBeanDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        categoryInfoBeanDaoConfig = daoConfigMap.get(CategoryInfoBeanDao.class).clone();
        categoryInfoBeanDaoConfig.initIdentityScope(type);

        categoryInfoBeanDao = new CategoryInfoBeanDao(categoryInfoBeanDaoConfig, this);

        registerDao(CategoryInfoBean.class, categoryInfoBeanDao);
    }
    
    public void clear() {
        categoryInfoBeanDaoConfig.clearIdentityScope();
    }

    public CategoryInfoBeanDao getCategoryInfoBeanDao() {
        return categoryInfoBeanDao;
    }

}

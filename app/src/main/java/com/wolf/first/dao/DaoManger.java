package com.wolf.first.dao;

import com.wolf.first.app.MainApplication;
import com.wolf.first.bean.greendao.DaoMaster;
import com.wolf.first.bean.greendao.DaoSession;

/**
 * Created by W.J on 2017/6/7.
 */

public class DaoManger {
    private static DaoManger daoManger;
    private DaoMaster daoMaster;
    private DaoSession daoSession;

    private DaoManger() {
        // 通过 DaoMaster 的内部类 DevOpenHelper，你可以得到一个便利的 SQLiteOpenHelper 对象。
        // 可能你已经注意到了，你并不需要去编写「CREATE TABLE」这样的 SQL 语句，因为 greenDAO 已经帮你做了。
        // 注意：默认的 DaoMaster.DevOpenHelper 会在数据库升级时，删除所有的表，意味着这将导致数据的丢失。
        // 所以，在正式的项目中，你还应该做一层封装，来实现数据库的安全升级。

        // 注意：该数据库连接属于 DaoMaster，所以多个 Session 指的是相同的数据库连接。
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(MainApplication.getContext(), "cate-db", null);
        daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        daoSession = daoMaster.newSession();
    }

    public DaoMaster getDaoMaster() {
        return daoMaster;
    }

    public void setDaoMaster(DaoMaster daoMaster) {
        this.daoMaster = daoMaster;
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

    public void setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
    }

    public static DaoManger getInstance() {
        if (daoManger == null) {
            daoManger = new DaoManger();
        }
        return daoManger;
    }
}

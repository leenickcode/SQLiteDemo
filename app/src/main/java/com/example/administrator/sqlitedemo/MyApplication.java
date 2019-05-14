package com.example.administrator.sqlitedemo;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import greendao.datebase.DaoMaster;
import greendao.datebase.DaoSession;

/**
 * Created by Administrator on 2019/5/11 0011.
 *
 * @author Administrator
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initGreenDao();
    }

    /**
     * 初始化GreenDao,直接在Application中进行初始化操作
     */
    private void initGreenDao() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "testaa.db");
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }

    private static DaoSession daoSession;
    public static DaoSession getDaoSession() {
        return daoSession;
    }

}

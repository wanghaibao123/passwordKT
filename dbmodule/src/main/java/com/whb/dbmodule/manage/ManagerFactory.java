package com.whb.dbmodule.manage;

import android.content.Context;

import com.whb.dbmodule.greendao.GreenDaoManager;

/**
 * Created by whb on 2019/1/24.
 * Email:18720982457@163.com
 */
public class ManagerFactory {
    /**
     * 每一个BeanManager都管理着数据库中的一个表，我将这些管理者在ManagerFactory中进行统一管理
     */
    PasswordManager passwordManager;

    private static ManagerFactory mInstance = null;

    /**
     * 获取DaoFactory的实例
     *
     * @return
     */
    public static ManagerFactory getInstance() {
        if (mInstance == null) {
            synchronized (ManagerFactory.class) {
                if (mInstance == null) {
                    mInstance = new ManagerFactory();
                }
            }
        }
        return mInstance;
    }

    public synchronized PasswordManager getPasswordManager(Context context) {
        if (passwordManager == null) {
            passwordManager = new PasswordManager(GreenDaoManager.getInstance(context).getDaoSession().getPasswordBeanDao());
        }
        return passwordManager;
    }
}

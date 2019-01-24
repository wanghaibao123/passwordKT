package com.whb.dbmodule.manage;

import com.whb.dbmodule.greendao.bean.PasswordBean;

import org.greenrobot.greendao.AbstractDao;

/**
 * Created by whb on 2019/1/24.
 * Email:18720982457@163.com
 */
public class PasswordManager extends BaseBeanManager<PasswordBean, Long> {

    public PasswordManager(AbstractDao dao) {
        super(dao);
    }
}

package com.kotlin.whbvac.passwordkt.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.kotlin.whbvac.passwordkt.R
import com.kotlin.whbvac.passwordkt.adapter.PasswordAdapter
import com.whb.dbmodule.greendao.bean.PasswordBean
import com.whb.dbmodule.manage.ManagerFactory
import com.whb.dbmodule.manage.PasswordManager
import kotlinx.android.synthetic.main.activity_main_new.*

class MainNewActivity : BaseActivity() {
    val passwordManager by lazy { ManagerFactory.getInstance().getPasswordManager(this) }
    val passwords = ArrayList<PasswordBean>()
    var mAdapter: PasswordAdapter? = null
    override fun layoutId(): Int {
        return R.layout.activity_main_new
    }

    override fun getIntentData() {

    }

    override fun initView() {
        rlv_password.layoutManager = LinearLayoutManager(this)
        mAdapter = PasswordAdapter(this,passwords)
        rlv_password.adapter = mAdapter
    }

    override fun initData() {
        var list =passwordManager.queryAll()
        if(list !=null) {
            passwords.clear()
            passwords.addAll(list)
        }
        mAdapter?.notifyDataSetChanged()
    }

}

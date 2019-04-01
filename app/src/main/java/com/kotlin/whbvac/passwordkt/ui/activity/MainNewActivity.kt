package com.kotlin.whbvac.passwordkt.ui.activity

import android.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.kotlin.whbvac.passwordkt.R
import com.kotlin.whbvac.passwordkt.adapter.PasswordAdapter
import com.whb.dbmodule.greendao.bean.PasswordBean
import com.whb.dbmodule.manage.ManagerFactory
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
        mAdapter = PasswordAdapter(this, passwords)
        rlv_password.adapter = mAdapter
        fab_addPassword.setOnClickListener({
            addPassword(it)
        })

        mAdapter?.onClickLister = object : PasswordAdapter.onCallBack<PasswordBean> {
            override fun onLongItemCallBack(t: PasswordBean) {
                AlertDialog.Builder(this@MainNewActivity)
                        .setCancelable(true)
                        .setTitle("删除")
                        .setMessage("是否真的删除这条密码信息")
                        .setPositiveButton("确定") { dialog, which ->
                            passwordManager.delete(t)
                            mAdapter?.notifyItemRemoved(passwords.indexOf(t))
                            dialog.dismiss()

                        }
                        .setNegativeButton("关闭") { dialog, which ->
                            dialog.dismiss()
                        }
                        .create()
                        .show()
            }

            override fun onItemCallBack(t: PasswordBean) {
                startActivity(AddPasswordActivity.getIntent(this@MainNewActivity, AddPasswordActivity.TYPE_SHOW, t))
            }

        }
    }

    override fun initData() {
        var list = passwordManager.queryAll()
        if (list != null) {
            passwords.clear()
            passwords.addAll(list)
        }
        mAdapter?.notifyDataSetChanged()
    }

    override fun onResume() {
        super.onResume()
        initData()
    }

    fun addPassword(view: View) {
        startActivity(AddPasswordActivity.getIntent(this, AddPasswordActivity.TYPE_ADD, null))
    }

}

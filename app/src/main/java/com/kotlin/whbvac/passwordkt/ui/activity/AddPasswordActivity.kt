package com.kotlin.whbvac.passwordkt.ui.activity

import android.content.Context
import android.content.Intent
import android.text.TextUtils
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import com.kotlin.whbvac.passwordkt.R
import com.whb.dbmodule.greendao.bean.PasswordBean
import com.whb.dbmodule.manage.ManagerFactory
import com.whb.dbmodule.manage.PasswordManager
import kotlinx.android.synthetic.main.activity_add_password.*

class AddPasswordActivity : BaseActivity() {
    var passwordBean: PasswordBean? = null

    var type = TYPE_SHOW

    val passwordManager: PasswordManager by lazy { ManagerFactory.getInstance().getPasswordManager(baseContext) }

    override fun layoutId(): Int = R.layout.activity_add_password

    override fun getIntentData() {
        intent?.let {
            type = it.getIntExtra("type", TYPE_SHOW)
            if (type == TYPE_SHOW) {
                passwordBean = it.getSerializableExtra("bean") as PasswordBean?
            }
        }
    }

    override fun initView() {
        switch(type)
        iv_back.setOnClickListener({
            finish()
        })

        tv_edit.setOnClickListener({

        })

        bt_save.setOnClickListener({
            if (type == TYPE_ADD) {
                save()
            }
        })
    }

    fun save() {
        val passwordBean = PasswordBean()
        passwordBean.userside = et_title.text.toString()
        passwordBean.name = et_username.text.toString()
        passwordBean.passsord = et_password.text.toString()
        passwordBean.desc = et_desc.toString()
        passwordBean.time = System.currentTimeMillis()
        if (TextUtils.isEmpty(passwordBean.userside)) {
            Toast.makeText(baseContext, "请填写标题", Toast.LENGTH_SHORT).show()
            return
        }
        if (TextUtils.isEmpty(passwordBean.name)) {
            Toast.makeText(baseContext, "请填写用户名", Toast.LENGTH_SHORT).show()
            return
        }
        if (TextUtils.isEmpty(passwordBean.passsord)) {
            Toast.makeText(baseContext, "请填写密码", Toast.LENGTH_SHORT).show()
            return
        }
        passwordManager.saveOrUpdate(passwordBean)
        Toast.makeText(baseContext, "保存成功", Toast.LENGTH_SHORT).show()
        finish()
    }

    fun switch(type: Int) {
        this.type = type

        when (type) {
            TYPE_ADD -> {
                tv_title.text = "添加密码"
                tv_edit.visibility = GONE
                bt_save.visibility = VISIBLE
            }
            TYPE_EDIT -> {
                tv_title.text = "修改密码"
                tv_edit.visibility = VISIBLE
                bt_save.visibility = VISIBLE

            }
            TYPE_SHOW -> {
                tv_title.text = "密码"
                tv_edit.visibility = GONE
                bt_save.visibility = GONE
            }
        }
    }

    override fun initData() {
    }

    companion object {
        val TYPE_ADD = 1
        val TYPE_EDIT = 2
        val TYPE_SHOW = 3
        fun getIntent(context: Context, type: Int): Intent {
            return Intent(context, AddPasswordActivity::class.java).apply {
                putExtra("type", type)
            }
        }
    }
}

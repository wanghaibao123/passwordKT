package com.kotlin.whbvac.passwordkt.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.kotlin.whbvac.passwordkt.R
import com.kotlin.whbvac.passwordkt.adapter.PasswordAdapter
import com.kotlin.whbvac.passwordkt.ui.activity.AddPasswordActivity
import com.whb.dbmodule.greendao.bean.PasswordBean
import com.whb.dbmodule.manage.ManagerFactory
import kotlinx.android.synthetic.main.fragment_password.*


class PassWordFragment : Fragment() {

    val passwordManager by lazy { ManagerFactory.getInstance().getPasswordManager(context) }
    var passwordBeans = ArrayList<PasswordBean>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_password, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initData()
        fab_addPassword.setOnClickListener {
            addPassword(it)
        }
    }

    fun initView() {
        rlv_password.layoutManager = LinearLayoutManager(context)
        val adapter = context?.let { PasswordAdapter(it, passwordBeans) }

        adapter?.onClickLister = object : PasswordAdapter.onCallBack<PasswordBean> {
            override fun onItemCallBack(t: PasswordBean) {
                startActivity(context?.let { AddPasswordActivity.getIntent(it, AddPasswordActivity.TYPE_SHOW, t) })
            }
        }
        rlv_password.adapter = adapter
    }

    fun initData() {
        passwordBeans.addAll(passwordManager.queryAll())
        rlv_password.adapter.notifyDataSetChanged()
    }

    companion object {
        fun newInstance() = PassWordFragment()
    }

    fun addPassword(view: View) {
        startActivity(context?.let { AddPasswordActivity.getIntent(it, AddPasswordActivity.TYPE_ADD, null) })
    }
}


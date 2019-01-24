package com.kotlin.whbvac.passwordkt.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.kotlin.whbvac.passwordkt.R
import com.whb.dbmodule.manage.ManagerFactory


class PassWordFragment : Fragment() {

    val passwordManager by lazy { ManagerFactory.getInstance().getPasswordManager(context) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_password, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        fun newInstance() = PassWordFragment()
    }
}
}

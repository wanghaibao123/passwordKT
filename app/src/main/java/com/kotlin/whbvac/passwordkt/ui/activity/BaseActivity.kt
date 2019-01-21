package com.kotlin.whbvac.passwordkt.ui.activity

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId())
        getIntentData()
        initView()
        initData()
    }

    abstract fun layoutId():Int

    abstract fun getIntentData()

    abstract fun initView()

    abstract fun initData()
}
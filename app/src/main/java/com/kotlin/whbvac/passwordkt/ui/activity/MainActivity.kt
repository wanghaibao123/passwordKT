package com.kotlin.whbvac.passwordkt.ui.activity

import android.support.v4.app.Fragment
import com.flyco.tablayout.listener.CustomTabEntity
import com.kotlin.whbvac.passwordkt.R
import com.kotlin.whbvac.passwordkt.entity.TabEntity
import com.kotlin.whbvac.passwordkt.ui.fragment.PassWordFragment
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : BaseActivity() {

    override fun getIntentData() {
    }

    override fun initView() {
        initTabLayout()
    }

    override fun layoutId(): Int {
        return R.layout.activity_main //To change body of created functions use File | Settings | File Templates.
    }

    override fun initData() {

    }

    fun initTabLayout() {
        val password = TabEntity(R.mipmap.action_home_n, R.mipmap.action_home_f, "密码")
        val personCenter = TabEntity(R.mipmap.action_me_n, R.mipmap.action_me_f, "我的")
        var tabEntitys: ArrayList<CustomTabEntity> = ArrayList()
        tabEntitys.add(password)
        tabEntitys.add(personCenter)
        val passwordFragment = PassWordFragment.newInstance()
        val personCenterFragment = PassWordFragment.newInstance()
        val fragments: ArrayList<Fragment> = ArrayList()
        fragments.add(passwordFragment)
        fragments.add(personCenterFragment)
        ctl_bottom.setTabData(tabEntitys, this, R.id.fl_container, fragments)
    }
}

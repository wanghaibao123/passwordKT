package com.kotlin.whbvac.passwordkt.entity

import com.flyco.tablayout.listener.CustomTabEntity

/**
 * Created by whb on 2019/1/21.
 * Email:18720982457@163.com
 */
class TabEntity(val unSelectIcon: Int, val selectIcon: Int, val title: String) : CustomTabEntity {

    override fun getTabUnselectedIcon(): Int {
        return unSelectIcon
    }

    override fun getTabSelectedIcon(): Int {
        return selectIcon
    }

    override fun getTabTitle(): String {
        return title
    }
}
package com.kotlin.whbvac.passwordkt.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.kotlin.whbvac.passwordkt.R
import com.whb.dbmodule.greendao.bean.PasswordBean

/**
 * Created by whb on 2019/1/25.
 * Email:18720982457@163.com
 */
class PasswordAdapter(var context: Context, var data: List<PasswordBean>) : RecyclerView.Adapter<PasswordAdapter.ViewHolder>() {

    var onClickLister: onCallBack<PasswordBean>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_password_card, parent, false))

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var passwordBean = data.get(position)
        holder.password.text = passwordBean.passsord
        holder.title.text = passwordBean.userside
        holder.time.text = passwordBean.time.toString()
        holder.username.text = passwordBean.name
        holder.itemView.setOnClickListener(View.OnClickListener {
            onClickLister?.onItemCallBack(passwordBean)
        })
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var title = view.findViewById<TextView>(R.id.main_item_title)
        var time = view.findViewById<TextView>(R.id.main_item_date)
        var username = view.findViewById<TextView>(R.id.main_item_name)
        var password = view.findViewById<TextView>(R.id.main_item_password)
    }

    interface onCallBack<T> {
        fun onItemCallBack(t: T)
    }

    fun setOnClick(callback: onCallBack<PasswordBean>) {
        this.onClickLister = callback
    }

}
package com.im.im.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.im.im.data.AddFriendItem
import com.im.im.widget.AddFriendListItemView

/**
 * Created by Administrator on 2018/3/30 0030.
 */
class AddFriendListAdapter(val context: Context, val addFrienditems: MutableList<AddFriendItem>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        val addFriendListItemView = holder?.itemView as AddFriendListItemView
        addFriendListItemView.bindView(addFrienditems[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        return AddFriendListItemViewViewHolder(AddFriendListItemView(context))
    }
    override fun getItemCount(): Int =addFrienditems.size

    class AddFriendListItemViewViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

    }
}
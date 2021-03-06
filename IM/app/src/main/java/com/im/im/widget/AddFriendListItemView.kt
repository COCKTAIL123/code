package com.im.im.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.im.im.R
import com.im.im.data.AddFriendItem
import kotlinx.android.synthetic.main.view_add_friend_item.view.*


/**
 * Created by Administrator on 2018/3/30 0030.
 */
class AddFriendListItemView(context: Context?, attrs: AttributeSet?=null) : RelativeLayout(context, attrs) {
    init {
        View.inflate(context, R.layout.view_add_friend_item,this)

    }

    fun bindView(addFriendItem: AddFriendItem) {
        userName.text = addFriendItem.userName
        timestamp.text = addFriendItem.timestamp
    }
}
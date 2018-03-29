package com.im.im.presenter

import cn.bmob.v3.BmobQuery
import cn.bmob.v3.BmobUser
import cn.bmob.v3.exception.BmobException
import cn.bmob.v3.listener.FindListener
import com.hyphenate.chat.EMClient
import com.im.im.contract.AddFriendContract
import com.im.im.data.AddFriendItem
import org.jetbrains.anko.doAsync

/**
 * Created by Administrator on 2018/3/30 0030.
 */
class AddFriendPresenter(val view:AddFriendContract.View):AddFriendContract.Prenter{
    val addFrienditems = mutableListOf<AddFriendItem>()
    override fun search(key: String) {

        val query = BmobQuery<BmobUser>()
        query.addWhereContains("username",key).addWhereNotEqualTo("username",EMClient.getInstance().currentUser)
        query.findObjects(object :FindListener<BmobUser>(){
            override fun done(p0: MutableList<BmobUser>?, p1: BmobException?) {
                if (p1==null){
                    doAsync {
                        p0?.forEach {
                           val addFriendItem = AddFriendItem(it.username,it.createdAt)
                            addFrienditems.add(addFriendItem)
                        }

                    }
                    view.onSearchSucess()
                }else view.onSearchFailed()
            }

        })

    }

}
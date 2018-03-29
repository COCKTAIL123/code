package com.im.im.presenter

import com.im.im.contract.ContactContract
import com.hyphenate.chat.EMClient
import com.hyphenate.exceptions.HyphenateException
import com.im.im.data.ContactListItem
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread


/**
 * Created by Administrator on 2018/3/29 0029.
 */
class ContactPresenter(val view:ContactContract.View):ContactContract.Presenter{
    //mutableListOf长度可变的  可修改的
    val contactListItems = mutableListOf<ContactListItem>()
    override fun loadContacts() {

        doAsync {
            //清空集合
            contactListItems.clear()
            try {

                val usernames = EMClient.getInstance().contactManager().allContactsFromServer
                usernames.sortBy { it[0] }
                usernames.forEachIndexed{index,s->
                    //判断是否显示首字符
                    val showFirstLetter = index==0||s[0]!=usernames[index-1][0]
                    val contactListItem = ContactListItem(s,s[0].toUpperCase(),showFirstLetter)
                    contactListItems.add(contactListItem)

                }

                uiThread { view.onLoadContactSuccess()  }

            }catch (e:HyphenateException){
                uiThread { view.onLoadContactFailed() }
            }
        }
    }

}
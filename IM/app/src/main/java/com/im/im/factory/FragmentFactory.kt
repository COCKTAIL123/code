package com.im.im.factory

import android.support.v4.app.Fragment
import com.im.im.R
import com.im.im.ui.fragment.ContactsFragment
import com.im.im.ui.fragment.ConversationFragment
import com.im.im.ui.fragment.DynamicFragment

/**
 * Created by hameisi on 18/3/29.
 */
class FragmentFactory private constructor(){
    val conversation by lazy { ConversationFragment()}
    val contact by lazy { ContactsFragment() }
    val dynamic by lazy { DynamicFragment() }
    companion object {
        val instance = FragmentFactory()
    }
    fun getFragment(tabId:Int):Fragment?{
        when(tabId){
            R.id.tab_conversation->return conversation
            R.id.tab_contacts->return contact
            R.id.tab_dynamic->return  dynamic
        }
        return null

    }
}
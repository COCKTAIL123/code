package com.im.im.ui.fragment

import com.hyphenate.chat.EMClient
import com.im.im.R
import kotlinx.android.synthetic.main.fragment_dynamic.*
import kotlinx.android.synthetic.main.header.*

/**
 * Created by hameisi on 18/3/29.
 */
class DynamicFragment : BaseFragment(){
    override fun getfragmentView(): Int = R.layout.fragment_dynamic
    override fun init() {
        super.init()
        headerTitle.text = getString(R.string.dynamic)
        val logoutString = String.format(getString(R.string.logout),EMClient.getInstance().currentUser)
        logout.text = logoutString
    }

}
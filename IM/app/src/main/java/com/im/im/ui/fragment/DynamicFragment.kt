package com.im.im.ui.fragment

import com.hyphenate.chat.EMClient
import com.im.im.R
import kotlinx.android.synthetic.main.fragment_dynamic.*
import kotlinx.android.synthetic.main.header.*
import com.hyphenate.EMCallBack
import com.im.im.adapter.EMCallBackAdapter
import com.im.im.ui.activity.LoginActivity
import org.jetbrains.anko.runOnUiThread
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast


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
        logout.setOnClickListener{loginout()}
    }

     fun loginout() {
         EMClient.getInstance().logout(true, object : EMCallBackAdapter() {

             override fun onSuccess() {
                 context.runOnUiThread {
                     toast(R.string.logout_success)
                     context.startActivity<LoginActivity>()
                     activity.finish()
                 }

             }

             override fun onError(p0: Int, p1: String?) {
                 super.onError(p0, p1)
                 context.runOnUiThread { toast(R.string.logout_failed) }
             }
         })
    }

}
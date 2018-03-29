package com.im.im.presenter


import com.hyphenate.chat.EMClient
import com.im.im.adapter.EMCallBackAdapter
import com.im.im.contract.LoginContract
import com.im.im.extentions.isValidPassWorld
import com.im.im.extentions.isValidUserName

/**
 * Created by hameisi on 18/3/29.
 * @author wb
 */
class LoginPresenter(val view:LoginContract.View):LoginContract.Presenter {
    /**
     * login
     */
    override fun login(userName: String, password: String) {
        if (userName.isValidUserName()){
//            用户名合法，继续校验密码
            if (password.isValidPassWorld()){
//                密码合法，开始登陆
                view.onStartLogin()
//                登录到环信
                loginEaseMob(userName,password)
            }else view.onPassWorldError()
        }else view.onUserNameError()
    }
    /**
     * loginEaseMob
     */
    private fun loginEaseMob(userName: String, password: String) {
            EMClient.getInstance().login(userName,password, object :EMCallBackAdapter() {
                override fun onSuccess() {
                    EMClient.getInstance().groupManager().loadAllGroups()
                    EMClient.getInstance().chatManager().loadAllConversations()
                    uiThread { view.onLoggedInSuccess() }

                }

                override fun onError(p0: Int, p1: String?) {
                    super.onError(p0, p1)
                    uiThread { view.onLonggedInFailed() }
                }

            }

            )
    }
}
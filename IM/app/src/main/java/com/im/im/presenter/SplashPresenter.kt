package com.im.im.presenter

import com.hyphenate.chat.EMClient
import com.im.im.contract.SplashContract

/**
 * Created by hameisi on 18/3/29.
 */
class SplashPresenter(val view:SplashContract.View):SplashContract.Presenter{
    override fun checkLoginStatus() {
        if( isLoggedIn()) view.onLoggedIn()else view.onNotLoggedIn()

    }

    private fun isLoggedIn(): Boolean =
            EMClient.getInstance().isConnected&&EMClient.getInstance().isLoggedInBefore


}
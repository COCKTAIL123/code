package com.im.im.contract

/**
 * Created by hameisi on 18/3/29.
 */
interface SplashContract {
    interface Presenter:BasePresenter{
        fun checkLoginStatus()//检查登录状态
    }
    interface View{
        fun onNotLoggedIn()
        fun onLoggedIn()
    }
}
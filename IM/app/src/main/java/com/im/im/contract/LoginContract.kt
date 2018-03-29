package com.im.im.contract

/**
 * Created by hameisi on 18/3/29.
 */
interface LoginContract {
    interface Presenter:BasePresenter{
        fun login(userName:String,password:String)
    }
    interface View{
        fun onUserNameError()
        fun onPassWorldError()
        fun onStartLogin()
        fun onLoggedInSuccess()
        fun onLonggedInFailed()

    }
}
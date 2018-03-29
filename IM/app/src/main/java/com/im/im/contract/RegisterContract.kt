package com.im.im.contract

/**
 * Created by hameisi on 18/3/29.
 */
interface RegisterContract{
    interface Presenter :BasePresenter{
        fun register(userName:String,password:String,confirmpassword:String)
    }
    interface  View{
        fun onUserNameError()
        fun onPasswordError()
        fun onConfirmPasswordError()
        fun onStartRegister()
        fun onRegisterSuccess()
        fun onRegisterFailed()
        fun onUserExist()
    }
}
package com.im.im.presenter

import cn.bmob.v3.BmobUser
import cn.bmob.v3.exception.BmobException
import cn.bmob.v3.listener.SaveListener
import com.hyphenate.chat.EMClient
import com.hyphenate.exceptions.HyphenateException
import com.im.im.contract.RegisterContract
import com.im.im.extentions.isValidPassWorld
import com.im.im.extentions.isValidUserName
import org.jetbrains.anko.doAsync

/**
 * Created by hameisi on 18/3/29.
 */
class RegisterPresenter(val view:RegisterContract.View):RegisterContract.Presenter{
    override fun register(userName: String, password: String, confirmpassword: String) {
        if (userName.isValidUserName()){
            if (password.isValidPassWorld()){
                if (password.equals(confirmpassword)){
                    view.onStartRegister()
//                    开始注册到Bomb
                    registerBmob(userName,password)
                }else view.onConfirmPasswordError()
            }else view.onPasswordError()
        }else view.onUserNameError()
    }

    /**
     * RegisterBmob
     */
    private fun registerBmob(userName: String, password: String) {
        val bom = BmobUser()
        bom.username = userName
        bom.setPassword(password)
        bom.signUp(object : SaveListener<BmobUser>() {
            override fun done(p0: BmobUser?, p1: BmobException?) {
                if (p1==null){
//                    注册成功
//                    注册到环信
                    registerEaseMob(userName,password)
                }else{
//                    注册失败
                if(p1.errorCode==202)view.onUserExist()
                    view.onRegisterFailed()


                }

            }

        })
    }

    /**
     * RegisterEaseMob
     */
    private fun registerEaseMob(userName: String, password: String) {
        doAsync {
            try {
            EMClient.getInstance().createAccount(userName,password)
                uiThread { view.onRegisterSuccess() }
            }catch (e:HyphenateException){
                uiThread { view.onRegisterFailed() }
            }
        }
    }
}
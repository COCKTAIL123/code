package com.im.im.ui.activity

import android.Manifest
import android.content.pm.PackageManager
import android.support.v4.app.ActivityCompat
import com.im.im.R
import com.im.im.contract.LoginContract
import com.im.im.presenter.LoginPresenter
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

/**
 * Created by hameisi on 18/3/29.
 */
class LoginActivity: BaseActivity(),LoginContract.View{
    val presenter = LoginPresenter(this)
    override fun init() {
        super.init()
//        注册
        newUser.setOnClickListener{
            startActivity<RegisterActivity>()
        }

//        登录
        login.setOnClickListener{
            login()
            password.setOnEditorActionListener{p0,p1,p2->
                login()
                true
            }
        }
    }

    fun login(){

//        隐藏软键盘
        hideSofKeyboard()
//        动态权限申请
        if(hasWriteExternalStiragePermission()){

        val userNmaeString = userName.text.trim().toString()
        val passworldString = password.text.trim().toString()
        presenter.login(userNmaeString,passworldString)
        }else applyWriteExteranlStoragePermissino()
    }

    private fun applyWriteExteranlStoragePermissino() {
    val permissions  = arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        ActivityCompat.requestPermissions(this,permissions,0)
    }
//检查是否有写磁盘的权限
    private fun hasWriteExternalStiragePermission(): Boolean {
        val result = ActivityCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE)
        return result==PackageManager.PERMISSION_GRANTED
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if (grantResults[0]==PackageManager.PERMISSION_GRANTED){
            //用户同意权限，开始登录
            login()
        }else toast(R.string.permission_denied)
    }

    override fun getResViewId(): Int = R.layout.activity_login

    override fun onUserNameError() {
    userName.error=getString(R.string.user_name_error)
    }

    override fun onPassWorldError() {
    password.error = getString(R.string.password_error)
    }

    override fun onStartLogin() {
//        开始登录弹出进度
        showProgress(getString(R.string.logging))
    }

    override fun onLoggedInSuccess() {
//        登录成功隐藏进度
        dismissProgress()
//        跳转主界面
        startActivity<MainActivity>()
//        销毁当前窗口
        finish()
    }

    override fun onLonggedInFailed() {
//        登录失败隐藏进度
        dismissProgress()
//        弹出吐司，提示用户
        toast(R.string.login_failed)
    }
}
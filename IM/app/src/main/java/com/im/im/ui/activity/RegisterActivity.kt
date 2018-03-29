package com.im.im.ui.activity


import com.im.im.R
import com.im.im.contract.RegisterContract
import com.im.im.presenter.RegisterPresenter
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

/**
 * Created by hameisi on 18/3/29.
 */
class RegisterActivity: BaseActivity(),RegisterContract.View{


    val presenter = RegisterPresenter(this)
    override fun init() {
        super.init()
        register.setOnClickListener{
            register()
            confirmPassword.setOnEditorActionListener { p0, p1, p2 ->
                register()
                true
            }
        }
    }
    fun register(){
        hideSofKeyboard()
        val userNameString = userName.text.trim().toString()
        val passWordString = password.text.trim().toString()
        val confirmPassWorldString = confirmPassword.text.trim().toString()
        presenter.register(userNameString,passWordString,confirmPassWorldString)
    }
    override fun getResViewId(): Int = R.layout.activity_register

    override fun onUserNameError() {
        userName.error = getString(R.string.user_name_error)
    }

    override fun onPasswordError() {
        password.error = getString(R.string.password_error)
    }

    override fun onConfirmPasswordError() {
        confirmPassword.error = getString(R.string.confirm_password_error)
    }

    override fun onStartRegister() {
        showProgress(getString(R.string.registering))
    }


    override fun onRegisterSuccess() {
        dismissProgress()
        startActivity<LoginActivity>()
        toast(R.string.register_success)
    }

    override fun onRegisterFailed() {
    dismissProgress()
        toast(R.string.register_failed)
    }
    override fun onUserExist() {
        dismissProgress()
        toast(R.string.user_already_exist)
    }
}
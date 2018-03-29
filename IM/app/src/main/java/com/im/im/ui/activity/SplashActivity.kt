package com.im.im.ui.activity

import android.os.Handler
import com.im.im.R
import com.im.im.contract.SplashContract
import com.im.im.presenter.SplashPresenter
import org.jetbrains.anko.startActivity

/**
 * Created by hameisi on 18/3/29.
 */
class SplashActivity: BaseActivity(),SplashContract.View{
    val presenter = SplashPresenter(this)
    companion object {
        val DELAY = 2000L
    }
    val handler by lazy {
        Handler()
    }

    override fun init() {
        super.init()
        presenter.checkLoginStatus()
    }
    override fun getResViewId(): Int {
        return R.layout.activity_splash
    }
//    延时两秒，跳转到登录界面
    override fun onNotLoggedIn() {
        handler.postDelayed({
            startActivity<LoginActivity>()
            finish()
        }, DELAY)
    }
    override fun onLoggedIn() {
    startActivity<MainActivity>()
    finish()
    }

}
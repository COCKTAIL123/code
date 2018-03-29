package com.im.im.contract

import android.os.Handler
import android.os.Looper

/**
 * Created by hameisi on 18/3/29.
 */
interface BasePresenter {
    companion object {
        val handler by lazy {
            Handler(Looper.getMainLooper())
        }
    }
    fun uiThread(f:()->Unit){
        handler.post { f() }
    }
}
package com.im.im.ui.activity

import android.app.ProgressDialog
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.inputmethod.InputMethodManager
import android.widget.ProgressBar

/**
 * 所有activity的基类
 */
abstract class BaseActivity:AppCompatActivity(){
    val proggress by lazy {
        ProgressDialog(this)
    }
    val inputMethodManager by lazy {
        getSystemService(Context.INPUT_METHOD_SERVICE) as  InputMethodManager
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getResViewId())
        init()
    }

    open fun init() {

    }

    abstract fun getResViewId(): Int
    fun showProgress(msg:String){
        proggress.setMessage(msg)
        proggress.show()
    }
    fun dismissProgress(){
        proggress.dismiss()
    }
    fun hideSofKeyboard(){
        inputMethodManager.hideSoftInputFromWindow(currentFocus.windowToken,0)
    }
}
package com.im.im.ui.activity


import com.im.im.R
import com.im.im.factory.FragmentFactory
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity(){

    override fun getResViewId(): Int {
       return R.layout.activity_main
    }

    override fun init() {
        super.init()
        bottomBar.setOnTabSelectListener{tabId ->
            val beginTransaction = supportFragmentManager.beginTransaction()
            beginTransaction.replace(R.id.fragment_frame,FragmentFactory.instance.getFragment(tabId))
            beginTransaction.commit()
        }
    }

}

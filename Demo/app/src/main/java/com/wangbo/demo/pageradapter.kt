package com.wangbo.demo

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Created by Administrator on 2018/7/14 0014.
 */
class pageradapter(var fm:FragmentManager, var lsit:List<Fragment> ): FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
    return lsit.get(position)
    }

    override fun getCount(): Int {
    return lsit.size
    }
}
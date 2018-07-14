package com.wangbo.demo.homepagerfragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wangbo.demo.R

/**
 * Created by Administrator on 2018/7/14 0014.
 */
class faragment2 : Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return View.inflate(context, R.layout.fragment2, null)
    }
}
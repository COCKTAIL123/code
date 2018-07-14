package com.wangbo.demo.fragment

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wangbo.demo.R
import com.wangbo.demo.homepagerfragment.faragment1
import com.wangbo.demo.homepagerfragment.faragment2
import com.wangbo.demo.homepagerfragment.faragment3
import com.wangbo.demo.pageradapter
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * Created by Administrator on 2018/7/14 0014.
 */
class homefragment:Fragment() {
    val fg1 by lazy { faragment1() }
    val fg2 by lazy { faragment2() }
    val fg3 by lazy { faragment3() }
    override fun onAttach(context: Context?) {
        Log.e("TAG","onAttach")
        super.onAttach(context)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.e("TAG","onCreate")
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.e("TAG","onCreateView")
        return View.inflate(context, R.layout.fragment_home,null)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.e("TAG","onActivityCreated")
    }
    override fun onStart() {
        super.onStart()
        Log.e("TAG","onStart")
        val list = ArrayList<Fragment>()
        list.add(fg1)
        list.add(fg2)
        list.add(fg3)
        viewpager.adapter = pageradapter(childFragmentManager,list)
        viewpager.currentItem = 0

    }

    override fun onResume() {
        super.onResume()

        Log.e("TAG","onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("TAG","onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("TAG","onStop")
    }

    override fun onDestroyView() {
        Log.e("TAG","onDestroyView")
        super.onDestroyView()
        Log.e("TAG","onDestroyView")
    }

    override fun onDestroy() {
        Log.e("TAG","onDestroy")
        super.onDestroy()
    }

    override fun onDetach() {
        Log.e("TAG","onDetach")
        super.onDetach()
    }
}
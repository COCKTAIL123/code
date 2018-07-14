package com.wangbo.demo.homepagerfragment

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wangbo.demo.R
import com.wangbo.demo.pageradapter
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * Created by Administrator on 2018/7/14 0014.
 */
class faragment1:Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.e("TAG","onCreateView1")

        return View.inflate(context, R.layout.fragment1,null)
    }
    override fun onAttach(context: Context?) {
        Log.e("TAG","onAttach1")
        super.onAttach(context)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.e("TAG","onCreate1")
        super.onCreate(savedInstanceState)

    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.e("TAG","onActivityCreated1")
    }
    override fun onStart() {
        super.onStart()
        Log.e("TAG","onStart1")
    }

    override fun onResume() {
        super.onResume()
        Log.e("TAG","onResume1")
    }

    override fun onPause() {
        super.onPause()
        Log.e("TAG","onPause1")
    }

    override fun onStop() {
        super.onStop()
        Log.e("TAG","onStop1")
    }

    override fun onDestroyView() {
        Log.e("TAG","onDestroyView1")
        super.onDestroyView()
        Log.e("TAG","onDestroyView1")
    }

    override fun onDestroy() {
        Log.e("TAG","onDestroy1")
        super.onDestroy()
    }

    override fun onDetach() {
        Log.e("TAG","onDetach1")
        super.onDetach()
    }
}
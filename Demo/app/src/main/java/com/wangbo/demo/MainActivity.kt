package com.wangbo.demo

import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.wangbo.demo.R.id.tab_home

import com.wangbo.demo.fragment.camerafragment
import com.wangbo.demo.fragment.homefragment
import com.wangbo.demo.fragment.musicfragment
import com.wangbo.demo.fragment.videofragment
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by Administrator on 2018/7/14 0014.
 */

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var home: homefragment? = null
    private var music: musicfragment? = null
    private var camera: camerafragment? = null
    private var video: videofragment? = null
    private var fm: FragmentManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        fm = supportFragmentManager
        showFragment(1)
    }

    private fun initView() {

        tab_home.setOnClickListener(this)
        tab_music.setOnClickListener(this)
        tab_video.setOnClickListener(this)
        tab_camera.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.tab_home -> showFragment(1)
            R.id.tab_music -> showFragment(2)
            R.id.tab_camera -> showFragment(3)
            R.id.tab_video -> showFragment(4)
        }
    }
    private fun showFragment(index: Int) {
        val ft = fm!!.beginTransaction()
        hideFragments(ft)
        when (index) {
            1 ->
                if (home != null)
                    ft.show(home)
                else {
                    home = homefragment()
                    ft.add(R.id.contentContainer, home)
                }
            2 -> if (music != null)
                ft.show(music)
            else {
                music = musicfragment()
                ft.add(R.id.contentContainer, music)
            }
            3 -> if (camera != null)
                ft.show(camera)
            else {
                camera = camerafragment()
                ft.add(R.id.contentContainer, camera)
            }
            4 -> if (video != null)
                ft.show(video)
            else {
                video = videofragment()
                ft.add(R.id.contentContainer, video)
            }
        }
        ft.commit()
    }

    private fun hideFragments(ft: FragmentTransaction) {
        if (home != null)
            ft.hide(home)
        if (music != null)
            ft.hide(music)
        if (camera != null)
            ft.hide(camera)
        if (video != null)
            ft.hide(video)
    }
}

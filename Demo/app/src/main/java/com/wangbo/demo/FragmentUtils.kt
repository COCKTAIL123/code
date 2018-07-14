package com.wangbo.demo

import android.support.v4.app.Fragment
import com.wangbo.demo.fragment.camerafragment
import com.wangbo.demo.fragment.homefragment
import com.wangbo.demo.fragment.musicfragment
import com.wangbo.demo.fragment.videofragment

/**
 * Created by Administrator on 2018/7/14 0014.
 */
class FragmentUtils private constructor(){
    val home by lazy { homefragment() }
    val camera by lazy { camerafragment() }
    val video by lazy { videofragment() }
    val music by lazy { musicfragment() }
    companion object {
        val fragmentutils by lazy { FragmentUtils() }
    }
    fun getfragment(tabId:Int):Fragment?{
        when(tabId){
           R.id.tab_camera -> return  camera
            R.id.tab_home -> return  home
            R.id.tab_video -> return  video
            R.id.tab_music -> return  music

        }
        return null
    }
}
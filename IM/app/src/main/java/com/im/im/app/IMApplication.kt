package com.im.im.app

import android.app.Application
import cn.bmob.v3.Bmob
import com.hyphenate.chat.EMClient
import com.hyphenate.chat.EMOptions
import com.im.im.BuildConfig

/**
 * Created by hameisi on 18/3/29.
 */
class IMApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        //初始化
        EMClient.getInstance().init(applicationContext, EMOptions());
        //在做打包混淆时，关闭debug模式，避免消耗不必要的资源
        EMClient.getInstance().setDebugMode(BuildConfig.DEBUG);
        Bmob.initialize(applicationContext, "55adeeded8c57b744d560c0a16becad2");
    }
}
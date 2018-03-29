package com.im.im.contract

/**
 * Created by Administrator on 2018/3/30 0030.
 */
interface AddFriendContract {
    interface Prenter:BasePresenter{
        fun search(key:String)
    }
    interface View{
        fun onSearchSucess()
        fun onSearchFailed()
    }
}
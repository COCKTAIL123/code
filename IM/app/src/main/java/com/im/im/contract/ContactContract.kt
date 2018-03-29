package com.im.im.contract

/**
 * Created by Administrator on 2018/3/29 0029.
 */
interface ContactContract {
    interface Presenter:BasePresenter{
        /**
         * 加载联系人
         */
        fun loadContacts()
    }
    interface View{
        /**
         * 加载联系人成功
         */
        fun onLoadContactSuccess()

        /**
         * 加载联系人失败
         */
        fun onLoadContactFailed()
    }
}
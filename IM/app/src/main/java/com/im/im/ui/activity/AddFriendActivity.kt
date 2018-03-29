package com.im.im.ui.activity

import android.support.v7.widget.LinearLayoutManager
import com.im.im.R
import com.im.im.adapter.AddFriendListAdapter
import com.im.im.contract.AddFriendContract
import com.im.im.presenter.AddFriendPresenter
import kotlinx.android.synthetic.main.activity_add_friend.*

import kotlinx.android.synthetic.main.header.*
import org.jetbrains.anko.toast

/**
 * Created by Administrator on 2018/3/30 0030.
 */
class AddFriendActivity: BaseActivity() ,AddFriendContract.View{
    val presenter = AddFriendPresenter(this)
    override fun getResViewId(): Int  = R.layout.activity_add_friend
    override fun init() {
        headerTitle.text = getString(R.string.add_friend)
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter =AddFriendListAdapter(context,presenter.addFrienditems)

        }
        search.setOnClickListener { search() }
       userName.setOnEditorActionListener{p0,p1,p2->
           search()
           true
       }


    }
    fun search(){
        hideSofKeyboard()
        showProgress(getString(R.string.searching))
        val key = userName.text.trim().toString()
        presenter.search(key)

    }
    override fun onSearchSucess() {
        dismissProgress()
        toast(R.string.search_success)
        recyclerView.adapter.notifyDataSetChanged()
    }


    override fun onSearchFailed() {
        dismissProgress()
        toast(R.string.search_failed)
    }

}
package com.im.im.ui.fragment

import android.annotation.SuppressLint
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.hyphenate.chat.EMClient
import com.im.im.R
import com.im.im.adapter.ContactListAdapter
import com.im.im.adapter.EMContactListenerAdapter
import com.im.im.contract.ContactContract
import com.im.im.presenter.ContactPresenter
import com.im.im.ui.activity.AddFriendActivity
import com.im.im.widget.SlideBar
import com.im.im.widget.SlideBar.OnSectionChangeListener
import kotlinx.android.synthetic.main.fragment_contacts.*
import kotlinx.android.synthetic.main.header.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

/**
 * Created by hameisi on 18/3/29.
 */
class ContactsFragment : BaseFragment(),ContactContract.View{




    override fun getfragmentView(): Int=R.layout.fragment_contacts

    val presenter = ContactPresenter(this)


    @SuppressLint("ResourceAsColor")
    override fun init() {
        super.init()
        headerTitle.text = getString(R.string.contact)
        add.visibility = View.VISIBLE
        add.setOnClickListener{
            context.startActivity<AddFriendActivity>()
        }



        swipeRefreshLayout.apply {
            setColorSchemeColors(R.color.qq_blue)
            swipeRefreshLayout.isRefreshing = true
            setOnRefreshListener { presenter.loadContacts() }
        }
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = ContactListAdapter(context,presenter.contactListItems)
        }
        //删除联系人监听
        EMClient.getInstance().contactManager().setContactListener(object : EMContactListenerAdapter(){
            override fun onContactDeleted(p0: String?) {
                //刷新界面，重新获取联系人数据

                presenter.loadContacts()

            }
        })
        slideBar.onsectionChangeListener = object: OnSectionChangeListener  {
            override fun OnSectionChange(firstLetter: String) {
                section.visibility = View.VISIBLE
                section.text = firstLetter
                recyclerView.smoothScrollToPosition(getPosition(firstLetter))

            }

            override fun onSlideFinish() {
                section.visibility = View.GONE
            }

        }

        presenter.loadContacts()
    }

    private fun getPosition(firstLetter: String): Int =
        presenter.contactListItems.binarySearch {
            contactListItem -> contactListItem.firstLetter.minus(firstLetter[0])

        }



    override fun onLoadContactSuccess() {
        swipeRefreshLayout.isRefreshing = false

    }

    override fun onLoadContactFailed() {
        swipeRefreshLayout.isRefreshing = false
        recyclerView.adapter.notifyDataSetChanged()
        context.toast(R.string.load_contacts_failed)
    }

}
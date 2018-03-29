package com.im.im.data.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.im.im.app.IMApplication
import org.jetbrains.anko.db.*

/**
 * Created by Administrator on 2018/3/30 0030.
 */
class DatabaseHelper(ctx: Context = IMApplication.instance) : ManagedSQLiteOpenHelper(ctx, NAME, null, VERSION) {


    override fun onCreate(db: SQLiteDatabase?) {
        db?.createTable(ContactTable.NAME,true,
                ContactTable.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
                ContactTable.CONTACT to TEXT)

    }
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.dropTable(ContactTable.NAME,true)
        onCreate(db)
    }

    companion object {
        val NAME = "im.db"
        val VERSION = 1
    }
}
package adong.org.modiproject.adapter

import android.content.Context
import ninja.sakib.pultusorm.core.PultusORM

class DBAdapter(val context : Context? = null) {
    lateinit var loginORM : PultusORM
    fun loginDBCreate(){
        val appPath: String = context!!.getFilesDir().getAbsolutePath()
        loginORM = PultusORM("modi.db", appPath)
    }
}
package adong.org.modiproject.adapter

import android.content.Context
import ninja.sakib.pultusorm.core.PultusORM

class DBAdapter {
    lateinit var loginDB : PultusORM
    fun createDB(context: Context){
        val appPath = context.filesDir.absolutePath
        loginDB = PultusORM("modi.db", appPath)
    }
}
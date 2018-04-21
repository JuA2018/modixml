package adong.org.modiproject.adapter

import android.content.Context
import ninja.sakib.pultusorm.core.PultusORM

class DBAdapter(context : Context? = null) {
    val appPath: String = context!!.getFilesDir().getAbsolutePath()
    val loginORM = PultusORM("modi.db", appPath)
}
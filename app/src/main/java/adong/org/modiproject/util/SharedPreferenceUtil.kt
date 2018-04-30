package adong.org.modiproject.util

import adong.org.modiproject.data.Token
import android.content.Context
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity

//간단한 SQLite
object SharedPreferenceUtil : AppCompatActivity() {
    lateinit var preferences : SharedPreferences
    lateinit var editor : SharedPreferences.Editor
    fun creatPreference(){
        preferences = getSharedPreferences("modi", Context.MODE_PRIVATE)
        editor = preferences.edit()
    }
    fun getPreference() : String = preferences.getString("token", "")

    fun savePreference(){
        creatPreference()
        editor.putString("token", Token().data)
        editor.commit()
    }
    fun removePreference(){
        creatPreference()
        editor.remove("token")
        editor.commit()
    }
}
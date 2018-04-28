package adong.org.modiproject.util

import adong.org.modiproject.data.Token
import android.content.Context
import android.support.v7.app.AppCompatActivity

//간단한 SQLite
object SharedPreferenceUtil : AppCompatActivity() {
    val preferences = getSharedPreferences("modi", Context.MODE_PRIVATE)
    val editor = preferences.edit()
    fun getPreference(){
        preferences.getString("token", "")
    }
    fun savePreference(){
        editor.putString("token", Token().data)
        editor.commit()
    }
    fun removePreference(){
        editor.remove("token")
        editor.commit()
    }
}
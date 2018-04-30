package adong.org.modiproject.util

import android.content.Context
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View

class CusTomBarUtil(val context : Context, val layout : Int, val actionBar: ActionBar?) : AppCompatActivity() {
    lateinit var actionbarview : View
    fun creatcustombar(){
        actionBar!!.setDisplayShowCustomEnabled(true)
        actionBar.setDisplayHomeAsUpEnabled(false)
        actionBar.setDisplayShowHomeEnabled(false)
        actionBar.setDisplayShowTitleEnabled(false)

        actionbarview = LayoutInflater.from(context).inflate(layout, null)
        actionBar.setCustomView(actionbarview)

        val parent : Toolbar = actionbarview.parent as Toolbar
        parent.setContentInsetsAbsolute(0, 0)
    }

    fun getcustomlayoutview() : View = actionbarview

}
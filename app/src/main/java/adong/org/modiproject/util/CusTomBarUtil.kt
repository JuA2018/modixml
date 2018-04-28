package adong.org.modiproject.util

import android.content.Context
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View

class CusTomBarUtil : AppCompatActivity() {
    fun creatcustombar(context : Context, layout : Int, actionBar: ActionBar?){

        actionBar!!.setDisplayShowCustomEnabled(true)
        actionBar.setDisplayHomeAsUpEnabled(false)
        actionBar.setDisplayShowHomeEnabled(false)
        actionBar.setDisplayShowTitleEnabled(false)

        val actionbarview : View = LayoutInflater.from(context).inflate(layout, null)
        actionBar.setCustomView(actionbarview)

        val parent : Toolbar = actionbarview.parent as Toolbar
        parent.setContentInsetsAbsolute(0, 0)
    }
}
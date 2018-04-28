package adong.org.modiproject

import adong.org.modiproject.util.SharedPreferenceUtil
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    lateinit var toolbar: Toolbar
    lateinit var fab : FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fab = findViewById(R.id.fab)
        fab.setOnClickListener({
            startActivity(Intent(applicationContext, WriteActivity::class.java))
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item!!.itemId) {
            R.id.action_logout -> {
                Toast.makeText(applicationContext, "로그아웃", Toast.LENGTH_SHORT).show()
                SharedPreferenceUtil.removePreference()
                return true
            }
            R.id.action_abote -> {
                Toast.makeText(applicationContext, "도움말", Toast.LENGTH_SHORT).show()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}

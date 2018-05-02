package adong.org.modiproject

import adong.org.modiproject.Adapter.MyAdapter
import adong.org.modiproject.data.ListData
import adong.org.modiproject.util.SharedPreferenceUtil
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var toolbar: Toolbar
    lateinit var fab : FloatingActionButton
    lateinit var includelist : View

    lateinit var diarylist : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        includelist = findViewById(R.id.includelist)
        diarylist = includelist.findViewById(R.id.diarylist)
        val llm = LinearLayoutManager(applicationContext)
        diarylist.layoutManager = llm


        val listarraydata = arrayListOf(
                ListData("2018 / 04.25", "(진짜) (나는) (도형) (어떻게할지) (모르겠다)", "일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다"),
                ListData("2018 / 04.26", "(진짜) (나는) (도형) (어떻게할지) (모르겠다)", "일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다"),
                ListData("2018 / 04.27", "(진짜) (나는) (도형) (어떻게할지) (모르겠다)", "일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다"),
                ListData("2018 / 04.28", "(진짜) (나는) (도형) (어떻게할지) (모르겠다)", "일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다"),
                ListData("2018 / 04.29", "(진짜) (나는) (도형) (어떻게할지) (모르겠다)", "일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다"),
                ListData("2018 / 04.30", "(진짜) (나는) (도형) (어떻게할지) (모르겠다)", "일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다"),
                ListData("2018 / 05.01", "(진짜) (나는) (도형) (어떻게할지) (모르겠다)", "일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다")
        )

        val adapter = MyAdapter(listarraydata)
        diarylist.adapter = adapter

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


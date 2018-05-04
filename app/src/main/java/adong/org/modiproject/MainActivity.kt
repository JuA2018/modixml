package adong.org.modiproject

import adong.org.modiproject.Adapter.MyAdapter
import adong.org.modiproject.data.Diarielist
import adong.org.modiproject.data.DiariesGet
import adong.org.modiproject.service.APIService
import adong.org.modiproject.service.RetrofitService
import adong.org.modiproject.util.SharedPreferenceUtil
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"

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
                SharedPreferenceUtil.removePreference(applicationContext)
                Log.d(TAG, "${SharedPreferenceUtil.getPreference(applicationContext)}")
                startActivity(Intent(applicationContext, LoginActivity :: class.java))
                finish()
                return true
            }
            R.id.action_abote -> {
                Toast.makeText(applicationContext, "도움말", Toast.LENGTH_SHORT).show()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun inputdiary(){
        val apiService = RetrofitService().creatService(APIService :: class.java)
        val call = apiService.getdiary()
        call.enqueue(object : Callback<DiariesGet> {

            override fun onFailure(call: Call<DiariesGet>?, t: Throwable?) {
                Snackbar.make(window.decorView.rootView, "알 수 없는 오류가 발생했습니다.", Snackbar.LENGTH_SHORT).show()
                Log.d("WriteAcitivity", t!!.message)
            }

            override fun onResponse(call: Call<DiariesGet>?, response: Response<DiariesGet>?) {
                val status = response!!.body()!!.status
                if(status.success){
                    val diaries = response.body()!!.diaries
                    val listarraydata : ArrayList<Diarielist> = ArrayList()
                    for(i in diaries.indices){
                        val dayDate = diaries.get(i).createdAt
                        val contents = diaries.get(i).contents
                        val teg = diaries.get(i).tags
                        val tags = StringBuffer()
                        val taglist = arrayListOf("")
                        tags.append(teg)
                        var str : String
                        var startindex = 0
                        var endindex : Int
                        try {
                            for (i in tags){
                                endindex = tags.indexOf(",", startindex)
                                str = tags.substring(startindex, endindex - 1)
                                startindex = endindex + 1
                                taglist.add(str)
                            }
                        } catch (e : ArrayIndexOutOfBoundsException){
                            val diarielist = Diarielist(dayDate, taglist, contents)
                            listarraydata.add(diarielist)
                        }
                    }
                    val adapter = MyAdapter(listarraydata)
                    diarylist.adapter = adapter

                } else {
                    Snackbar.make(window.decorView.rootView, status.message, Snackbar.LENGTH_SHORT).show()
                }
            }

        })
    }

}


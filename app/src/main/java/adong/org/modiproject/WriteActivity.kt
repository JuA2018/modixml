package adong.org.modiproject

import adong.org.modiproject.data.Diaries
import adong.org.modiproject.data.DiariesGet
import adong.org.modiproject.service.APIService
import adong.org.modiproject.service.RetrofitService
import adong.org.modiproject.util.CusTomBarUtil
import adong.org.modiproject.util.SharedPreferenceUtil
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import me.originqiu.library.EditTag
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*

class WriteActivity : AppCompatActivity() {

    val TAG = WriteActivity::class.toString()

    lateinit var setedittag : EditTag
    lateinit var textSize: TextView
    lateinit var content: EditText
    val taglist : MutableList<String> = ArrayList()
    val tagstringbuffe = StringBuffer()

    lateinit var customlayoutview : View

    lateinit var customlayout_backbutton : ImageButton
    lateinit var customlayout_checkbutton : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write)

        val custombar = CusTomBarUtil(applicationContext, R.layout.custom_actionbar, supportActionBar)
        custombar.creatcustombar()
        customlayoutview = custombar.getcustomlayoutview()
        customlayout_backbutton = customlayoutview.findViewById(R.id.btnBack)
        customlayout_checkbutton = customlayoutview.findViewById(R.id.btnselect)

        customlayout_backbutton.setOnClickListener{
            Toast.makeText(applicationContext,"일기작성이 종료 되었습니다.", Toast.LENGTH_SHORT).show()
            finish()
        }
        customlayout_checkbutton.setOnClickListener {
            finishdiary()
        }


        textSize = findViewById(R.id.textsize)
        content = findViewById(R.id.editcontent)

        content.addTextChangedListener(object : TextWatcher {
            var str: String = ""

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                str = s.toString()
            }

            override fun afterTextChanged(s: Editable?) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s!!.length > 2000) {
                    content.setText(str)
                    content.setSelection(start)
                } else
                    textSize.setText(s.length.toString())
            }
        })

        setedittag = findViewById(R.id.setedittag)
        setedittag.setTagAddCallBack(object : EditTag.TagAddCallback{
            override fun onTagAdd(p0: String?): Boolean {
                tagstringbuffe.append("${p0},")
                return true
            }
        })
        setedittag.setTagDeletedCallback(object : EditTag.TagDeletedCallback{
            override fun onTagDelete(p0: String?) {
                Log.d(TAG, "$p0 삭제")
            }
        })

    }

    fun finishdiary(){
        val day = System.currentTimeMillis()
        val date = Date(day)
        val format = SimpleDateFormat("yyyy / MM.dd")
        val dayDate = format.format(date)
        val diary = Diaries(tagstringbuffe.toString(), content.text.toString(), dayDate)
        Log.d(TAG, "${tagstringbuffe}, ${content.text}")
        val token = SharedPreferenceUtil.getPreference(applicationContext)
        val apiService = RetrofitService().creatService(APIService :: class.java, token)
        val call = apiService.diarywrite(diary)
        call.enqueue(object : Callback<DiariesGet>{
            override fun onFailure(call: Call<DiariesGet>?, t: Throwable?) {
                Snackbar.make(window.decorView.rootView, "알 수 없는 오류가 발생했습니다.", Snackbar.LENGTH_SHORT).show()
                Log.d("WriteAcitivity", t!!.message)
            }

            override fun onResponse(call: Call<DiariesGet>?, response: Response<DiariesGet>?) {
                val status = response!!.body()!!.status
                if(status.success){
                    Toast.makeText(applicationContext, "일기 작성 완료", Toast.LENGTH_SHORT).show()
                    finish()
                } else {
                    Snackbar.make(window.decorView.rootView, status.message, Snackbar.LENGTH_SHORT).show()
                }
            }
        })
    }
}

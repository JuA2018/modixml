package adong.org.modiproject

import adong.org.modiproject.util.CusTomBarUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast

class WriteActivity : AppCompatActivity() {

    lateinit var edittag : EditText
    lateinit var textSize: TextView
    lateinit var content: EditText

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
        edittag = findViewById(R.id.edittag)

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



    }

    fun finishdiary(){
        Toast.makeText(applicationContext,"ㅇㅅㅇ",Toast.LENGTH_SHORT).show()
        finish()
    }


}

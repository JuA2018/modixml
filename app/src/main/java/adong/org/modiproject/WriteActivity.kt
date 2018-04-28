package adong.org.modiproject

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class WriteActivity : AppCompatActivity() {

    lateinit var textSize : TextView
    lateinit var content : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //엑션바 설정
        val actionBar = supportActionBar
        actionBar!!.setIcon(R.drawable.backbutton)
        actionBar.setDisplayUseLogoEnabled(true)
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setTitle("일기작성")
        setContentView(R.layout.activity_write)

        textSize = findViewById(R.id.textsize)
        content = findViewById(R.id.editcontent)

        content.addTextChangedListener(object : TextWatcher{
            var str : String = ""

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                str = s.toString()
            }

            override fun afterTextChanged(s: Editable?) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s!!.length > 2000){
                    content.setText(str)
                    content.setSelection(start)
                } else
                    textSize.setText(s.length)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.writeactionbar_confirm, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when(item!!.itemId) {
            R.id.confirm -> {
                Toast.makeText(applicationContext, "일기 작성을 완료 했습니다.", Toast.LENGTH_LONG).show()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}

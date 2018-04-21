package adong.org.modiproject

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class LoginActivity : AppCompatActivity(),View.OnClickListener {
    lateinit var loginid : EditText

    lateinit var loginpasswd : EditText
    lateinit var loginbutton : Button
    lateinit var signbutton : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        loginbutton = findViewById(R.id.loginbutton)
        signbutton = findViewById(R.id.signbutton)
        loginid = findViewById(R.id.loginid)
        loginpasswd = findViewById(R.id.loginpasswd)
        loginbutton.setOnClickListener(this)
        signbutton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val Lid = loginid.text.toString()
        val Lpasswd = loginpasswd.text.toString()
        when (v!!.id){
            R.id.signbutton -> {
                val signup = Intent(applicationContext,SignUpActivity::class.java)
                startActivity(signup)
            }
            R.id.loginbutton -> {

            }
        }
    }
}

package adong.org.modiproject

import adong.org.modiproject.data.Result
import adong.org.modiproject.data.User
import adong.org.modiproject.data.UserGet
import adong.org.modiproject.service.APIService
import adong.org.modiproject.service.RetrofitService
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity(),View.OnClickListener {

    val TAG = "LoginActivity"
    lateinit var loginid : EditText
    lateinit var loginpassword : EditText
    lateinit var loginbutton : Button
    lateinit var signbutton : Button
    lateinit var view : View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        loginbutton = findViewById(R.id.loginbutton)
        signbutton = findViewById(R.id.signbutton)
        loginid = findViewById(R.id.loginid)
        loginpassword = findViewById(R.id.loginpassword)
        view = window.decorView.rootView
        loginbutton.setOnClickListener(this)
        signbutton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val Lid = loginid.text.toString()
        val Lpasswd = loginpassword.text.toString()
        val user = User(Lid, Lpasswd)
        when (v!!.id){
            R.id.signbutton -> {
                val signup = Intent(applicationContext,SignUpActivity::class.java)
                startActivity(signup)
            }
            R.id.loginbutton -> {
                val apiservice = RetrofitService().creatService(APIService :: class.java)
                val call = apiservice.login(user)
                call.enqueue(object : Callback<UserGet> {
                    override fun onResponse(call: Call<UserGet>?, response: Response<UserGet>?) {
                        val status : Result = response!!.body()!!.status
                        if (status.success){
                            Toast.makeText(applicationContext,"로그인 성공", Toast.LENGTH_SHORT).show()
                            startActivity(Intent(applicationContext, MainActivity::class.java))
                            finish()
                        }else{
                            Snackbar.make(view, status.message, Snackbar.LENGTH_LONG).show()
                        }
                    }

                    override fun onFailure(call: Call<UserGet>?, t: Throwable?) {
                        Snackbar.make(view, "알수 없는 오류가 발생했습니다.", Snackbar.LENGTH_LONG).show()
                        Log.d(TAG,t!!.message)
                    }
                })
            }
        }
    }
}

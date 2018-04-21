package adong.org.modiproject

import adong.org.modiproject.adapter.DBAdapter
import adong.org.modiproject.adapter.LoginDB
import adong.org.modiproject.data.User
import adong.org.modiproject.data.UserGet
import adong.org.modiproject.service.APIService
import adong.org.modiproject.service.RetrofitService
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import android.widget.Button
import android.widget.EditText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity(),View.OnClickListener {

    lateinit var loginid : EditText
    lateinit var loginpasswd : EditText
    lateinit var loginbutton : Button
    lateinit var signbutton : Button

    lateinit var apiservice : APIService
    lateinit var call : Call<UserGet>

    lateinit var view : View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        loginbutton = findViewById(R.id.loginbutton)
        signbutton = findViewById(R.id.signbutton)
        loginid = findViewById(R.id.loginid)
        loginpasswd = findViewById(R.id.loginpasswd)
        view = window.decorView.rootView
        DBAdapter(applicationContext).loginDBCreate()
        loginbutton.setOnClickListener(this)
        signbutton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val Lid = loginid.text.toString()
        val Lpasswd = loginpasswd.text.toString()
        val user = User(Lid, Lpasswd)
        when (v!!.id){
            R.id.signbutton -> {
                val signup = Intent(applicationContext,SignUpActivity::class.java)
                startActivity(signup)
            }
            R.id.loginbutton -> {
                apiservice = RetrofitService.getClient().create(APIService :: class.java)
                call = apiservice.login(user)
                call.enqueue(object : Callback<UserGet>{
                    override fun onResponse(call: Call<UserGet>?, response: Response<UserGet>?) {
                        if (response!!.isSuccessful){
                            val logindb = LoginDB()
                            logindb.token = response.body()!!.token
                            logindb.user = response.body()!!.user
                            DBAdapter().loginORM.save(logindb)
                            Snackbar.make(view,"로그인 성공", Snackbar.LENGTH_SHORT).show()
                            startActivity(Intent(applicationContext, MainActivity::class.java))
                        }else{
                            Snackbar.make(view, response.message(), Snackbar.LENGTH_LONG).show()
                        }
                    }

                    override fun onFailure(call: Call<UserGet>?, t: Throwable?) {
                        Snackbar.make(view, t!!.message!!, Snackbar.LENGTH_LONG).show()
                    }

                })
            }
        }
    }
}

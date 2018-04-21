package adong.org.modiproject

import adong.org.modiproject.data.User
import adong.org.modiproject.service.APIService
import adong.org.modiproject.service.RetrofitService
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity(),View.OnClickListener {

    val TAG = "SignUpActivity"

    lateinit var signupid : EditText
    lateinit var signpassword1 : EditText
    lateinit var signpassword2 : EditText
    lateinit var signupbutton : Button

    lateinit var apiservice : APIService
    lateinit var view : View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        signupid = findViewById(R.id.signupid)
        signpassword1 = findViewById(R.id.signpassword1)
        signpassword2 = findViewById(R.id.signpassword2)
        signupbutton = findViewById(R.id.signupbutton)
        view = window.decorView.rootView
        signupbutton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val Sid = signupid.text.toString()
        val Spwd = signpassword1.text.toString()
        val Srpwd = signpassword2.text.toString()
        if(Spwd.equals(Srpwd)){
            val user = User(Sid, Spwd)
            apiservice = RetrofitService().retrofit.create(APIService::class.java)
            val call : Call<User> = apiservice.signup(user)
            call.enqueue(object : Callback<User>{
                override fun onResponse(call: Call<User>?, response: Response<User>?) {
                    if (response!!.isSuccessful) {
                        Snackbar.make(view, "회원가입 완료", Snackbar.LENGTH_SHORT).show()
                    } else {
                        Snackbar.make(view, response.message(), Snackbar.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<User>?, t: Throwable?) {
                    Snackbar.make(view, t!!.message!!, Snackbar.LENGTH_SHORT).show()
                }
            })
        } else {
            Snackbar.make(view, "비밀번호가 다릅니다.", Snackbar.LENGTH_SHORT).show()
        }
    }
}

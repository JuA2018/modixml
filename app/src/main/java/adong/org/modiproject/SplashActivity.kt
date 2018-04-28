package adong.org.modiproject

import adong.org.modiproject.util.SharedPreferenceUtil
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed({
            val token = SharedPreferenceUtil.getPreference()
            if(!token.equals("")) startActivity(Intent(applicationContext, MainActivity::class.java))
            else startActivity(Intent(applicationContext, LoginActivity::class.java))
        }, 1500)
    }
}

package adong.org.modiproject

import adong.org.modiproject.util.SharedPreferenceUtil
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.util.Log

class SplashActivity : AppCompatActivity() {

    val TAG = "SplashActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val token = SharedPreferenceUtil.getPreference(applicationContext)
        Log.d(TAG, SharedPreferenceUtil.getPreference(applicationContext))
        Handler().postDelayed({
            if (token.equals("")) startActivity(Intent(applicationContext, LoginActivity::class.java))
            else startActivity(Intent(applicationContext, MainActivity::class.java))
            finish()
        }, 1200)
    }
}

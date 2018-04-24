package adong.org.modiproject

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed({
            val login = Intent(applicationContext, LoginActivity::class.java)
            startActivity(login)
            finish()
        }, 1500)
    }
}

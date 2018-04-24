package adong.org.modiproject

import adong.org.modiproject.adapter.DBAdapter
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //DB생성
        DBAdapter().createDB(applicationContext)

    }
}

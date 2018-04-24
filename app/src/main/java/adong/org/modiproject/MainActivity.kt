package adong.org.modiproject

import adong.org.modiproject.adapter.TabAdapter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.widget.TableLayout
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    lateinit var tabs : TabLayout
    lateinit var viewPager : ViewPager
    lateinit var adapter : TabAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = TabAdapter(supportFragmentManager)
        viewPager = findViewById(R.id.viewpager)
        viewPager.adapter = adapter
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))

        tabs = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)
        tabs.addTab(tabs.newTab().setIcon(R.drawable.list))
        tabs.addTab(tabs.newTab().setIcon(R.drawable.pencil))
        tabs.addTab(tabs.newTab().setIcon(R.drawable.question))
        tabs.tabGravity = TabLayout.GRAVITY_CENTER

    }
}

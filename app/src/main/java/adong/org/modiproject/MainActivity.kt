package adong.org.modiproject

import adong.org.modiproject.adapter.TabAdapter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.widget.TableLayout

class MainActivity : AppCompatActivity() {

    lateinit var tabs : TabLayout
    lateinit var viewPager : ViewPager
    lateinit var adapter : TabAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tabs = findViewById(R.id.tabs)
        tabs.addTab(tabs.newTab().setIcon(R.drawable.list))
        tabs.addTab(tabs.newTab().setIcon(R.drawable.pencil))
        tabs.addTab(tabs.newTab().setIcon(R.drawable.question))
        tabs.tabGravity = TabLayout.GRAVITY_CENTER

        adapter = TabAdapter(supportFragmentManager)
        viewPager = findViewById(R.id.viewpager)
        viewPager.adapter = adapter
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))

        tabs.setOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                viewPager.currentItem = tab!!.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })


    }
}

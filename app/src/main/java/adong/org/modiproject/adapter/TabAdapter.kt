package adong.org.modiproject.adapter

import adong.org.modiproject.About
import adong.org.modiproject.ListDiary
import adong.org.modiproject.WriteDiary
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class TabAdapter(fm : FragmentManager) : FragmentPagerAdapter(fm) {

    val PAGE_COUNT = 3

    override fun getItem(position: Int): Fragment? {
        when(position){
            0 -> return ListDiary()
            1 -> return WriteDiary()
            2 -> return About()
            else -> return null
        }
    }

    override fun getCount(): Int = PAGE_COUNT
}
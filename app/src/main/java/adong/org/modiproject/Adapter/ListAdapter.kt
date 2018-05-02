package adong.org.modiproject.Adapter

import adong.org.modiproject.R
import adong.org.modiproject.data.ListData
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView

class MyListAdapter(val con : Context, val arrayList: ArrayList<ListData>) : BaseAdapter() {

    val TAG = "MyListAdapter"

    override fun getItem(position: Int): Any {
        return arrayList[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }


    override fun getCount(): Int {
        return arrayList.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        //R.layout.image_activity접근
        val layoutview : View = LayoutInflater.from(con).inflate(R.layout.image_activity, null)

        val days : TextView = layoutview.findViewById(R.id.days)
        val tags : TextView = layoutview.findViewById(R.id.tags)
        val contents : TextView = layoutview.findViewById(R.id.contents)
        val listData : ListData = arrayList.get(position)

        //값넣기
        days.setText(listData.day)
        tags.setText(listData.tag)
        contents.setText(listData.diary)
        return layoutview
    }

    fun setAdapter(adapter : MyListAdapter, listView : ListView){

    }
}


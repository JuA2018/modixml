package adong.org.modiproject.Adapter

import adong.org.modiproject.R
import adong.org.modiproject.data.ListData
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class MyAdapter(val adapterlist : ArrayList<ListData>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutview = LayoutInflater.from(parent.context).inflate(R.layout.image_activity, parent,false)
        val viewHolder = ViewHolder(itemview = layoutview)
        return viewHolder
    }

    override fun getItemCount(): Int = adapterlist.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.days.setText(adapterlist.get(position).days)
        holder.tags.setText(adapterlist.get(position).tags)
        holder.contents.setText(adapterlist.get(position).contents)
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
    }

    class ViewHolder(itemview : View) : RecyclerView.ViewHolder(itemview) {
        var cv : CardView
        var days : TextView
        var tags : TextView
        var contents : TextView

        init {
            cv = itemview.findViewById(R.id.cv)
            days = itemview.findViewById(R.id.days)
            tags = itemview.findViewById(R.id.tags)
            contents = itemview.findViewById(R.id.contents)
        }

    }


}


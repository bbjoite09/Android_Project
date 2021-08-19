package com.example.tmm

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.danger_sub_item.view.*

class RecyclerAdapterDangerSub(private val context: Context, private val items: ArrayList<DataDangerSub>) :
    RecyclerView.Adapter<RecyclerAdapterDangerSub.ViewHolder>() {
    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        val listener = View.OnClickListener { it ->
            Toast.makeText(it.context, "Clicke:" + item.allSubName, Toast.LENGTH_SHORT).show()
        }
//        holder.apply {
//            bind(listener, item)
//            itemView.tag = item
//        }
        holder.bind(listener, item)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val inflatedView =
            LayoutInflater.from(context).inflate(R.layout.danger_sub_item, parent, false)
        return ViewHolder(inflatedView)
    }

    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        private var view: View = v
        fun bind(listener: View.OnClickListener, item: DataDangerSub) {
            view.setOnClickListener(listener)
            view.xml_station_name.text = item.allSubName
        }

    }
}
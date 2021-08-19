package com.example.tmm

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.danger_item.view.*
import com.example.tmm.RecyclerAdapterDangerSub as RecyclerAdapterDangerSub

class RecyclerAdapterDanger(private val context: Context, private val items: ArrayList<DataDangerLine>) :
    RecyclerView.Adapter<RecyclerAdapterDanger.ViewHolder>() {

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        val listener = View.OnClickListener { it ->
            Toast.makeText(it.context, "Clicke:" + item.lineName, Toast.LENGTH_SHORT).show()
        }
        holder.apply {
            bind(listener, item)
            itemView.tag = item
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val inflatedView1 =
            LayoutInflater.from(context).inflate(R.layout.danger_item, parent, false)

        return ViewHolder(inflatedView1)
    }

    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        private var view: View = v


        fun bind(listener: View.OnClickListener, item: DataDangerLine) {
            view.xml_line_img.setImageDrawable(item.lineImg)
            view.xml_line_name.text = item.lineName
            view.setOnClickListener(listener)


            val s = itemView?.findViewById<RecyclerView>(R.id.xml_danger_sub)
            val mAdapter = RecyclerAdapterDangerSub(context, item.dangerSub)
            s.adapter = mAdapter
            val layoutmanager = LinearLayoutManager(context)
            s.layoutManager = layoutmanager
            s.setHasFixedSize(true)


        }
    }
}
package com.example.tmm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.danger_item.view.*

class RecyclerAdapterDanger(private val items: ArrayList<DataDangerLine>) :
    RecyclerView.Adapter<RecyclerAdapterDanger.ViewHolder>() {

//    val context = context
//    var data = mutableListOf<DataDangerLine>()
//
//    inner class DangerHolder(itemView: View): RecyclerView.ViewHolder(itemView){
//        fun setData(data: DataDangerLine){
//            itemView.xml_line_name.text = data.lineName
//
//            val RecyclerAdapterDangerSub = RecyclerAdapterDangerSub()
//            val dangerSubData = data.itemList
//            RecyclerAdapterDangerSub.data = dangerSubData
//
////            itemView.xml_danger_sub.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
//
//            itemView.xml_danger_sub.adapter = RecyclerAdapterDangerSub
//            RecyclerAdapterDangerSub.notifyDataSetChanged()
//        }
//    }

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
        val inflatedView =
            LayoutInflater.from(parent.context).inflate(R.layout.danger_item, parent, false)
        return ViewHolder(inflatedView)
    }

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        private var view: View = v
        fun bind(listener: View.OnClickListener, item: DataDangerLine) {
            view.xml_line_img.setImageDrawable(item.lineImg)
            view.xml_line_name.text = item.lineName
            view.setOnClickListener(listener)

            val moreInfo = view.findViewById<ImageButton>(R.id.img_more)
            val layoutExpand = view.findViewById<LinearLayout>(R.id.expand_recyclerView)



        }
    }
}
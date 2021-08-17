package com.example.tmm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.danger_item.view.*

class RecyclerAdapterDanger_temp(private val items: ArrayList<DataDangerLine>) :
    RecyclerView.Adapter<RecyclerAdapterDanger_temp.ViewHolder>() {

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

            moreInfo.setOnClickListener {
                val show = toggleLayout(!item.isExpanded, it, layoutExpand)
                item.isExpanded = show
            }

        }

        private fun toggleLayout(isExpanded: Boolean, view: View, layoutExpand: LinearLayout): Boolean {
            // 2
            ToggleAnimation.toggleArrow(view, isExpanded)
            if (isExpanded) {
                ToggleAnimation.expand(layoutExpand)
            } else {
                ToggleAnimation.collapse(layoutExpand)
            }
            return isExpanded
        }


    }
}

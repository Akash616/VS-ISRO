package com.kotlinpratice.vs_isro.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kotlinpratice.vs_isro.R

class RvIsroAdapter(val list: ArrayList<String>, val listener: RvOnItemClick) :
    RecyclerView.Adapter<RvIsroAdapter.RvIsroViewHolder>() {

    class RvIsroViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvEndPoints = itemView.findViewById<TextView>(R.id.tvEndPoints)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvIsroViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rvisro_item, parent, false)
        val viewHolder = RvIsroViewHolder(view)

        viewHolder.itemView.setOnClickListener {
            listener.onItemClicked(viewHolder.adapterPosition)
        }

        return viewHolder
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RvIsroViewHolder, position: Int) {
        holder.tvEndPoints.text = list[position]
    }

}

interface RvOnItemClick {
    fun onItemClicked(position: Int)
}
package com.kotlinpratice.vs_isro.rvontapfragment.adapter.centers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kotlinpratice.vs_isro.databinding.RvontapCenterItemsBinding
import com.kotlinpratice.vs_isro.models.Centers.Centre

class RvCentersAdapter(val list: List<Centre>) : RecyclerView.Adapter<RvCentersAdapter.RvCentersViewHolder>() {

    inner class RvCentersViewHolder(val binding: RvontapCenterItemsBinding) : RecyclerView.ViewHolder(binding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvCentersViewHolder {
        val binding = RvontapCenterItemsBinding.inflate(LayoutInflater.from(parent.context))
        val rvCentersViewHolder = RvCentersViewHolder(binding)
        return rvCentersViewHolder
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RvCentersViewHolder, position: Int) {
        holder.binding.tvCentersId.text = list.get(position).id.toString()
        holder.binding.tvCentersName.text = list.get(position).name.toString()
        holder.binding.tvCentersPlace.text = list.get(position).Place.toString()
        holder.binding.tvCentersState.text = list.get(position).State.toString()
    }

}
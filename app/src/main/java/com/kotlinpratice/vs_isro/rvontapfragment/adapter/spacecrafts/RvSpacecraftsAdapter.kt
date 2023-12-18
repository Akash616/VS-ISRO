package com.kotlinpratice.vs_isro.rvontapfragment.adapter.spacecrafts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kotlinpratice.vs_isro.databinding.RvontapCustomerSatellitesItemsBinding
import com.kotlinpratice.vs_isro.databinding.RvontapSpacecraftsItemsBinding
import com.kotlinpratice.vs_isro.models.Spacecrafts.Spacecraft

class RvSpacecraftsAdapter(private val list: List<Spacecraft>): RecyclerView.Adapter<RvSpacecraftsAdapter.RvSpacecraftsViewHolder>() {

    inner class RvSpacecraftsViewHolder(val binding: RvontapSpacecraftsItemsBinding) : RecyclerView.ViewHolder(binding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvSpacecraftsViewHolder {
        val binding = RvontapSpacecraftsItemsBinding.inflate(LayoutInflater.from(parent.context))
        val rvSpacecraftsViewHolder = RvSpacecraftsViewHolder(binding)
        return rvSpacecraftsViewHolder
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RvSpacecraftsViewHolder, position: Int) {
        holder.binding.tvSpacecraftsId.text = list.get(position).id.toString()
        holder.binding.tvSpacecraftsName.text = list.get(position).name
    }
}
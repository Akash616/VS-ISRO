package com.kotlinpratice.vs_isro.rvontapfragment.adapter.launchers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kotlinpratice.vs_isro.databinding.RvontapCustomerSatellitesItemsBinding
import com.kotlinpratice.vs_isro.databinding.RvontapLaunchersItemsBinding
import com.kotlinpratice.vs_isro.models.Launchers.Launcher

class RvLaunchersAdapter(private val list: List<Launcher>) : RecyclerView.Adapter<RvLaunchersAdapter.RvLaunchersViewHolder>() {

    inner class RvLaunchersViewHolder(val binding: RvontapLaunchersItemsBinding) : RecyclerView.ViewHolder(binding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvLaunchersViewHolder {
        val binding = RvontapLaunchersItemsBinding.inflate(LayoutInflater.from(parent.context))
        val rvLaunchersViewHolder = RvLaunchersViewHolder(binding)
        return rvLaunchersViewHolder
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RvLaunchersViewHolder, position: Int) {
        holder.binding.tvLaunchersId.text = list.get(position).id
        holder.binding.tvLaunchersSerialNumber.text = (position+1).toString()
    }
}
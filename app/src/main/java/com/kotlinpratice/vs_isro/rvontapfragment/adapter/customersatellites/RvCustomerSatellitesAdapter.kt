package com.kotlinpratice.vs_isro.rvontapfragment.adapter.customersatellites

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kotlinpratice.vs_isro.databinding.RvontapCustomerSatellitesItemsBinding
import com.kotlinpratice.vs_isro.models.CustomerSatellites.CustomerSatellite

class RvCustomerSatellitesAdapter(val list: List<CustomerSatellite>) : RecyclerView.Adapter<RvCustomerSatellitesAdapter.RvCustomerSatellitesViewHolder>() {

    inner class RvCustomerSatellitesViewHolder(val binding: RvontapCustomerSatellitesItemsBinding) : RecyclerView.ViewHolder(binding.root) {}

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RvCustomerSatellitesViewHolder {
        val binding = RvontapCustomerSatellitesItemsBinding.inflate(LayoutInflater.from(parent.context))
        val rvCustomerSatellitesViewHolder = RvCustomerSatellitesViewHolder(binding)
        return rvCustomerSatellitesViewHolder
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RvCustomerSatellitesViewHolder, position: Int) {
        holder.binding.tvCSatellitesId.text = list.get(position).id
        holder.binding.tvCSatellitesCountry.text = list.get(position).country
        holder.binding.tvCSatellitesLaunchDate.text = list.get(position).launch_date
        holder.binding.tvCSatellitesMass.text = list.get(position).mass
        holder.binding.tvCSatellitesLauncher.text = list.get(position).launcher

        holder.binding.tvSerialNumber.text = (position+1).toString()

    }
}
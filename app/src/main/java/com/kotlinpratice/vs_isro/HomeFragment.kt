package com.kotlinpratice.vs_isro

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.kotlinpratice.vs_isro.adapter.RvIsroAdapter
import com.kotlinpratice.vs_isro.adapter.RvOnItemClick
import com.kotlinpratice.vs_isro.databinding.FragmentHomeBinding
import com.kotlinpratice.vs_isro.databinding.FragmentSplashScreenBinding

class HomeFragment : Fragment(), RvOnItemClick {

    lateinit var binding: FragmentHomeBinding
    var list = arrayListOf<String>("Spacecrafts", "Launchers", "Customer\nSatellites", "Centres")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvIsro.layoutManager = GridLayoutManager(requireContext(), 2)
        val adapter = RvIsroAdapter(list, this)
        binding.rvIsro.adapter = adapter

        binding.ivMoreInfo.setOnClickListener {
            val builder = AlertDialog.Builder(requireContext())
            builder.setMessage("Developed by Akash Gupta\n\nSpecial thanks for providing Open Source API for " +
                    "Launched Spacecrafts & Rockets data of ISRO https://isro.vercel.app/")
            builder.setTitle("VS-ISRO")
            builder.setCancelable(true)
            val alertDialog = builder.create()
            alertDialog.show()
        }

    }

    override fun onItemClicked(position: Int) {
        when(position){
            0 -> findNavController().navigate(R.id.action_homeFragment_to_spacecraftsFragment)
            1 -> findNavController().navigate(R.id.action_homeFragment_to_launchersFragment)
            2 -> findNavController().navigate(R.id.action_homeFragment_to_customerSatellitesFragment)
            3 -> findNavController().navigate(R.id.action_homeFragment_to_centresFragment)
        }
    }

}
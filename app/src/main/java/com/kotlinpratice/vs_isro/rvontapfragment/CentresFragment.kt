package com.kotlinpratice.vs_isro.rvontapfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.kotlinpratice.vs_isro.R
import com.kotlinpratice.vs_isro.adapter.RvIsroAdapter
import com.kotlinpratice.vs_isro.api.APIClient
import com.kotlinpratice.vs_isro.api.RetrofitHelper
import com.kotlinpratice.vs_isro.databinding.FragmentCentresBinding
import com.kotlinpratice.vs_isro.databinding.FragmentHomeBinding
import com.kotlinpratice.vs_isro.models.Centers.Centre
import com.kotlinpratice.vs_isro.repository.IsroApiRepository
import com.kotlinpratice.vs_isro.rvontapfragment.adapter.centers.RvCentersAdapter
import com.kotlinpratice.vs_isro.viewmodel.RvIsroViewModel
import com.kotlinpratice.vs_isro.viewmodel.RvIsroViewModelFactory

class CentresFragment : Fragment() {

    private var _binding: FragmentCentresBinding? = null
    private val binding get() = _binding!! //!! - NPE bec. non-null value
    lateinit var rvIsroViewModel: RvIsroViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCentresBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val apiClient = RetrofitHelper.getInstance().create(APIClient::class.java)
        val isroApiRepository = IsroApiRepository(apiClient)
        rvIsroViewModel = ViewModelProvider(this, RvIsroViewModelFactory(isroApiRepository)).get(RvIsroViewModel::class.java)

        binding.rvCenters.layoutManager = LinearLayoutManager(requireContext())
        binding.pBarCenter.visibility = View.VISIBLE

        rvIsroViewModel.centers.observe(viewLifecycleOwner, Observer {
            if (it.centres.isNotEmpty()){
                binding.pBarCenter.visibility = View.GONE
                val adapter = RvCentersAdapter(it.centres)
                binding.rvCenters.adapter = adapter
            }
        })

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}
package com.kotlinpratice.vs_isro.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kotlinpratice.vs_isro.models.Centers.CentersModel
import com.kotlinpratice.vs_isro.models.CustomerSatellites.CustomerSatellitesModel
import com.kotlinpratice.vs_isro.models.Launchers.LaunchersModel
import com.kotlinpratice.vs_isro.models.Spacecrafts.SpacecraftsModel
import com.kotlinpratice.vs_isro.repository.IsroApiRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RvIsroViewModel(private val rvIsroApiRepository: IsroApiRepository) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            rvIsroApiRepository.getCenters()
            rvIsroApiRepository.getCustomerSatellites()
            rvIsroApiRepository.getLaunchers()
            rvIsroApiRepository.getSpacecrafts()
        }
    }

    val centers : LiveData<CentersModel>
        get() = rvIsroApiRepository.centersLiveData

    val customerSatellites : LiveData<CustomerSatellitesModel>
        get() = rvIsroApiRepository.customerSatellitesLiveData

    val launchers : LiveData<LaunchersModel>
        get() = rvIsroApiRepository.launchersLiveData

    val spacecrafts : LiveData<SpacecraftsModel>
        get() = rvIsroApiRepository.spacecraftsLiveData

}
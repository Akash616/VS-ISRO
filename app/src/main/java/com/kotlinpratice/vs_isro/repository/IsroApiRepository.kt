package com.kotlinpratice.vs_isro.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kotlinpratice.vs_isro.api.APIClient
import com.kotlinpratice.vs_isro.models.Centers.CentersModel
import com.kotlinpratice.vs_isro.models.CustomerSatellites.CustomerSatellitesModel
import com.kotlinpratice.vs_isro.models.Launchers.LaunchersModel
import com.kotlinpratice.vs_isro.models.Spacecrafts.SpacecraftsModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class IsroApiRepository(private val apiClient: APIClient) {

    private val _centersLiveData = MutableLiveData<CentersModel>()
    val centersLiveData : LiveData<CentersModel>
        get() = _centersLiveData

    private val _customerSatellitesLiveData = MutableLiveData<CustomerSatellitesModel>()
    val customerSatellitesLiveData : LiveData<CustomerSatellitesModel>
        get() = _customerSatellitesLiveData

    private val _launchersLiveData = MutableLiveData<LaunchersModel>()
    val launchersLiveData : LiveData<LaunchersModel>
        get() = _launchersLiveData

    private val _spacecraftsLiveData = MutableLiveData<SpacecraftsModel>()
    val spacecraftsLiveData : LiveData<SpacecraftsModel>
        get() = _spacecraftsLiveData


    suspend fun getCenters(){
        val response = apiClient.getCenters()
        if (response.isSuccessful && response.body() != null){
            _centersLiveData.postValue(response.body())
        }
//        call.enqueue(object : Callback<CentersModel>{
//            override fun onResponse(call: Call<CentersModel>, response: Response<CentersModel>) {
//                if (response.isSuccessful){
//                    _centersLiveData.postValue(response.body())
//                }
//            }
//
//            override fun onFailure(call: Call<CentersModel>, t: Throwable) {
//                Log.d("onFailure getCenters: ", t.message.toString())
//            }

//        })
    }

    suspend fun getCustomerSatellites(){
        val response = apiClient.getCustomerSatellites()
        if (response.isSuccessful && response.body() != null){
            _customerSatellitesLiveData.postValue(response.body())
        }
    }

    suspend fun getLaunchers(){
        val response = apiClient.getLaunchers()
        if (response.isSuccessful && response.body() != null){
            _launchersLiveData.postValue(response.body())
        }
    }

    suspend fun getSpacecrafts(){
        val response = apiClient.getSpacecrafts()
        if (response.isSuccessful && response.body() != null){
            _spacecraftsLiveData.postValue(response.body())
        }
    }

}
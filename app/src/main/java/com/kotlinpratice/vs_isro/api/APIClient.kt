package com.kotlinpratice.vs_isro.api

import com.kotlinpratice.vs_isro.models.Centers.CentersModel
import com.kotlinpratice.vs_isro.models.CustomerSatellites.CustomerSatellitesModel
import com.kotlinpratice.vs_isro.models.Launchers.LaunchersModel
import com.kotlinpratice.vs_isro.models.Spacecrafts.SpacecraftsModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface APIClient {

    @GET("centres")
    suspend fun getCenters() : Response<CentersModel>

    @GET("customer_satellites")
    suspend fun getCustomerSatellites() : Response<CustomerSatellitesModel>

    @GET("launchers")
    suspend fun getLaunchers() : Response<LaunchersModel>

    @GET("spacecrafts")
    suspend fun getSpacecrafts() : Response<SpacecraftsModel>

}
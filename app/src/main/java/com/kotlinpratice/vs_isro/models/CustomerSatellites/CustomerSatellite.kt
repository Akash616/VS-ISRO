package com.kotlinpratice.vs_isro.models.CustomerSatellites

data class CustomerSatellite(
    val country: String,
    val id: String,
    val launch_date: String,
    val launcher: String,
    val mass: String
)
package com.weatherapp.model

import com.google.android.gms.maps.model.LatLng

data class City(
    val name : String,
    val location: LatLng? = null
)

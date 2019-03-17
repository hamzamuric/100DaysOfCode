package com.hart.onoff

import retrofit2.Call
import retrofit2.http.GET

interface OnOffApi {

    @GET("on")
    fun turnOn(): Call<String>

    @GET("off")
    fun turnOff(): Call<String>
}
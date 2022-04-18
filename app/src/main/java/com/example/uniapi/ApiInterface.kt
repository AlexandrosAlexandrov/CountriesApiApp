package com.example.uniapi

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("all")
    fun getData(): Call<List<CountriesItem>>


    @GET("search")
    fun getUnis(@Query("country")country: String): Call<List<CountryUnisItem>>
}
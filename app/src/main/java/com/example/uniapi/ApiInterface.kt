package com.example.uniapi

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("all")
    fun getData(): Call<List<CountriesItem>>

    @GET("search")
    fun getUnis(): Call<List<CountryUnisItem>>
}
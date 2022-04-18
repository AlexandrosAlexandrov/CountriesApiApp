package com.example.uniapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL2 = "http://universities.hipolabs.com/"

class show_unis : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_unis)

        getUnis()
    }

    private fun getUnis() {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL2)
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getData()

        retrofitData.enqueue(object : Callback<List<CountriesItem>?> {
            override fun onResponse(
                call: Call<List<CountriesItem>?>,
                response: Response<List<CountriesItem>?>
            ) {
                val responseBody = response.body()
            }

            override fun onFailure(call: Call<List<CountriesItem>?>, t: Throwable) {
                Log.d("Main Activity", "on Failure: " + t.message)
            }
        })
    }

}
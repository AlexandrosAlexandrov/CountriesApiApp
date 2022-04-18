package com.example.uniapi

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.StringBuilder

const val BASE_URL = "https://restcountries.com/v3.1/"

class MainActivity : AppCompatActivity() {

    lateinit var myAdapter: myAdapter
    lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var recyclerview_countries: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerview_countries = findViewById(R.id.recyclerview_countries)
        recyclerview_countries.setHasFixedSize(true)

        linearLayoutManager = LinearLayoutManager(this)
        recyclerview_countries.layoutManager = linearLayoutManager

        getMyData()
    }

    private fun getMyData() {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getData()

        retrofitData.enqueue(object : Callback<List<CountriesItem>?> {
            override fun onResponse(
                call: Call<List<CountriesItem>?>,
                response: Response<List<CountriesItem>?>
            ) {
                val responseBody = response.body()!!

                myAdapter = myAdapter(baseContext, responseBody)
                myAdapter.notifyDataSetChanged()
                recyclerview_countries.adapter = myAdapter

            }

            override fun onFailure(call: Call<List<CountriesItem>?>, t: Throwable) {
                d("Main Activity", "on Failure: "+t.message)
            }
        })
    }

}
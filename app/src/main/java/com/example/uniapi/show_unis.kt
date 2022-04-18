package com.example.uniapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL2 = "http://universities.hipolabs.com/"

class show_unis : AppCompatActivity() {

    lateinit var myAdapter: AdapterUni
    lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var recyclerview_unis: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_unis)

        recyclerview_unis = findViewById(R.id.recyclerview_unis)
        recyclerview_unis.setHasFixedSize(true)

        linearLayoutManager = LinearLayoutManager(this)
        recyclerview_unis.layoutManager = linearLayoutManager

        getUnis()
    }

    private fun getUnis() {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL2)
            .build()
            .create(ApiInterface::class.java)

        val country = intent.getStringExtra(country)!!

        val retrofitData = retrofitBuilder.getUnis(country)

        retrofitData.enqueue(object : Callback<List<CountryUnisItem>?> {
            override fun onResponse(
                call: Call<List<CountryUnisItem>?>,
                response: Response<List<CountryUnisItem>?>
            ) {
                val responseBody = response.body()!!

                myAdapter = AdapterUni(baseContext, responseBody)
                myAdapter.notifyDataSetChanged()
                recyclerview_unis.adapter = myAdapter
            }

            override fun onFailure(call: Call<List<CountryUnisItem>?>, t: Throwable) {
                Log.d("Main Activity", "on Failure: " + t.message)
            }
        })
    }

}
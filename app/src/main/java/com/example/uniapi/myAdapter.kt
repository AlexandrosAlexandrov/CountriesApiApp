package com.example.uniapi

import android.app.ProgressDialog.show
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.RecyclerView

class myAdapter(val context: Context, val countryList: List<CountriesItem>): RecyclerView.Adapter<myAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var countryName: TextView
        var countryButton: Button

        init {
            countryName = itemView.findViewById(R.id.country_name)
            countryButton = itemView.findViewById(R.id.country_button)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var itemView = LayoutInflater.from(context).inflate(R.layout.row_items, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.countryName.text = countryList[position].name.common
        holder.countryButton.setOnClickListener{
            Toast.makeText(context, "Clicked "+holder.countryName.text, Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return countryList.size
    }
}
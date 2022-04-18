package com.example.uniapi

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class AdapterUni(val context: Context, val UniList: List<CountryUnisItem>): RecyclerView.Adapter<AdapterUni.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var uniName: TextView
        init {
            uniName = itemView.findViewById(R.id.uni_name)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var itemView = LayoutInflater.from(context).inflate(R.layout.uni_row_items, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.uniName.text = UniList[position].name
    }

    override fun getItemCount(): Int {
        return UniList.size
    }
}
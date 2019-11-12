package com.ismin.opendataapp

import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StarbucksViewHolder(rootView: View, onItemClickListener: AdapterView.OnItemClickListener) : RecyclerView.ViewHolder(rootView) {
    var cityToChange: TextView
    var streetToChange: TextView
    var details: Button

    init {
        this.cityToChange = rootView.findViewById(R.id.r_icon_txv_citytoChange)
        this.streetToChange = rootView.findViewById(R.id.r_icon_txv_streetToChange)
        this.details = rootView.findViewById(R.id.r_icon_details)
        this.details.setOnClickListener {
            onItemClickListener.onItemClick(null, it, adapterPosition, 0L)
        }
    }
}
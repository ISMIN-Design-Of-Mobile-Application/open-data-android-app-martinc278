package com.ismin.opendataapp

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView

class StarbucksAdapter(private val starbucks: ArrayList<Starbucks>, private val onItemClickListener: AdapterView.OnItemClickListener) : RecyclerView.Adapter<StarbucksViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StarbucksViewHolder {
        val row = LayoutInflater.from(parent.context).inflate(R.layout.row_starbucks, parent,
            false)

        return StarbucksViewHolder(row, onItemClickListener)
    }

    override fun onBindViewHolder(viewholder: StarbucksViewHolder, position: Int) {
        val (city, street) = this.starbucks[position]

        viewholder.cityToChange.text = city
        viewholder.streetToChange.text = street
    }

    override fun getItemCount(): Int {
        return this.starbucks.size
    }
}
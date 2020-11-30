package com.uid.project.sportify.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.uid.project.sportify.R
import com.uid.project.sportify.holders.SimpleItemViewHolder
import com.uid.project.sportify.models.Sport

class SportsListAdapter(private val dataSet: List<Sport>) :
    RecyclerView.Adapter<SimpleItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return SimpleItemViewHolder(inflater, parent, R.color.purple_sportify)
    }

    override fun onBindViewHolder(holder: SimpleItemViewHolder, position: Int) {
        val sport: Sport = dataSet[position]
        holder.bind(sport.name + " " + sport.level.toString().toLowerCase().capitalize())
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}
package com.uid.project.sportify.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.uid.project.sportify.R
import com.uid.project.sportify.holders.DeletableItemViewHolder
import com.uid.project.sportify.holders.SimpleItemViewHolder
import com.uid.project.sportify.models.Registry
import com.uid.project.sportify.models.Sport

class DeletableSportsListAdapter(private val dataSet: MutableList<Sport>) : RecyclerView.Adapter<DeletableItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeletableItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return DeletableItemViewHolder(inflater, parent, R.color.purple_sportify)
    }

    override fun onBindViewHolder(holder: DeletableItemViewHolder, position: Int) {
        val sport: Sport = dataSet[position]
        holder.bind(sport.name + " " + sport.level.toString().toLowerCase().capitalize())
        holder.deleteButton?.setOnClickListener{
            Registry.user1Manager.sports.removeAt(position)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}
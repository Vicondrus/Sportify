package com.uid.project.sportify.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.uid.project.sportify.R
import com.uid.project.sportify.holders.DeletableItemViewHolder
import com.uid.project.sportify.models.Sport

class DeletableSportsListAdapter(
    val dataSet: MutableList<Sport>,
    private val context: Context
) : RecyclerView.Adapter<DeletableItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeletableItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return DeletableItemViewHolder(inflater, parent, R.color.purple_sportify)
    }

    override fun onBindViewHolder(holder: DeletableItemViewHolder, position: Int) {
        val sport: Sport = dataSet[position]
        holder.bind(sport.name + " " + sport.level.toString().toLowerCase().capitalize())
        holder.setClickListener {
            dataSet.removeAt(position)
            notifyDataSetChanged()
            Toast.makeText(context, "Sport deleted", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}
package com.uid.project.sportify.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.uid.project.sportify.holders.ParticipationItemViewHolder
import com.uid.project.sportify.models.Participation

class ParticipationListAdapter(private val dataSet: List<Participation>) : RecyclerView.Adapter<ParticipationItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParticipationItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ParticipationItemViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: ParticipationItemViewHolder, position: Int) {
        val participation: Participation = dataSet[position]
        holder.bind(participation)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}
package com.uid.project.sportify.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.uid.project.sportify.holders.GroupItemViewHolder
import com.uid.project.sportify.holders.ParticipationItemViewHolder
import com.uid.project.sportify.models.Group
import com.uid.project.sportify.models.Participation

class GroupsListAdapter(private val dataSet: List<Group>, private val context : Context) :
        RecyclerView.Adapter<GroupItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return GroupItemViewHolder(inflater, parent, context)
    }

    override fun onBindViewHolder(holder: GroupItemViewHolder, position: Int) {
        val group: Group = dataSet[position]
        holder.bind(group)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}
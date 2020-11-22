package com.uid.project.sportify.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.uid.project.sportify.R
import com.uid.project.sportify.holders.DeletableItemViewHolder
import com.uid.project.sportify.holders.SimpleItemViewHolder
import com.uid.project.sportify.models.Registry
import com.uid.project.sportify.models.Sport

class DeletableTagsListAdapter(private val dataSet: MutableList<String>) : RecyclerView.Adapter<DeletableItemViewHolder>() {
    var listener: ((String) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeletableItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return DeletableItemViewHolder(inflater, parent, R.color.dark_tone_sportify)
    }

    override fun onBindViewHolder(holder: DeletableItemViewHolder, position: Int) {
        val tag: String = dataSet[position]
        holder.bind(tag)
        holder.deleteButton?.setOnClickListener{
            Registry.user1Manager.tags.removeAt(position)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}
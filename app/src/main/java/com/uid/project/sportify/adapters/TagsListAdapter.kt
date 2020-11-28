package com.uid.project.sportify.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.uid.project.sportify.R
import com.uid.project.sportify.holders.SimpleItemViewHolder

class TagsListAdapter(private val dataSet: List<String>) :
        RecyclerView.Adapter<SimpleItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return SimpleItemViewHolder(inflater, parent, R.color.dark_tone_sportify)
    }

    override fun onBindViewHolder(holder: SimpleItemViewHolder, position: Int) {
        val text: String = dataSet[position]
        holder.bind(text)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}
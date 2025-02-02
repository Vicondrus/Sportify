package com.uid.project.sportify.holders

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.uid.project.sportify.R

class SimpleItemViewHolder(inflater: LayoutInflater, parent: ViewGroup, color: Int) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.simple_list_item, parent, false)) {
    var title: Button? = null


    init {
        title = itemView.findViewById(R.id.itemContainer) as Button
        title!!.backgroundTintList = parent.context.resources.getColorStateList(color)
    }

    fun bind(text: String) {
        title?.text = text
    }
}
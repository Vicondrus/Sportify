package com.uid.project.sportify.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.uid.project.sportify.R
import com.uid.project.sportify.holders.EventPhotoItemViewHolder


class EventPhotoItemAdapter(private val dataSet: ArrayList<Int>) : RecyclerView.Adapter<EventPhotoItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventPhotoItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.event_photo_item, parent, false)
        return EventPhotoItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: EventPhotoItemViewHolder, position: Int) {
        val image: Int = dataSet[position]
        holder.bind(image)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

}

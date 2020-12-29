package com.uid.project.sportify.holders

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.uid.project.sportify.R

class EventPhotoItemViewHolder(private val view: View) :
        RecyclerView.ViewHolder(view) {
    private var eventImage: ImageView? = null

    init {
        eventImage = itemView.findViewById(R.id.eventPhotoFromGallery) as ImageView
    }

    fun bind(image: Int) {
        eventImage?.setImageResource(image)
    }
}
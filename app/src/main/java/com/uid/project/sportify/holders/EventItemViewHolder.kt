package com.uid.project.sportify.holders

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.uid.project.sportify.R
import com.uid.project.sportify.models.Event
import java.time.format.DateTimeFormatter

class EventItemViewHolder(inflater: LayoutInflater, private var parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.event_list_item_organizer, parent, false)) {
    private var eventName: TextView? = null
    private var eventDate: TextView? = null
    var eventImage: FrameLayout? = null


    init {
        eventName = itemView.findViewById(R.id.listItemEventName)
        eventDate = itemView.findViewById(R.id.listItemEventDate)
        eventName = itemView.findViewById(R.id.listItemEventImage)
    }

    fun bind(event: Event) {
        eventName?.text = event.name
        eventDate?.text = event.date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
        eventImage?.background = ResourcesCompat.getDrawable(parent.resources, event.image, null)
    }
}
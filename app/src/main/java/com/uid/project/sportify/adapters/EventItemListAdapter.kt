package com.uid.project.sportify.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.uid.project.sportify.EventPageOrganizerActivity
import com.uid.project.sportify.holders.EventItemViewHolder
import com.uid.project.sportify.models.Event

class EventItemListAdapter(private val dataSet: List<Event>, private val context: Context) :
        RecyclerView.Adapter<EventItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return EventItemViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: EventItemViewHolder, position: Int) {
        val event: Event = dataSet[position]
        holder.bind(event)
        holder.eventImage?.setOnClickListener {
            val intent = Intent(context, EventPageOrganizerActivity::class.java)
            intent.putExtra("event", event)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}
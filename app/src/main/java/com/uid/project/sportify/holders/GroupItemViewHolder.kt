package com.uid.project.sportify.holders

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.uid.project.sportify.R
import com.uid.project.sportify.models.Group

class GroupItemViewHolder(inflater: LayoutInflater, private var parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.event_list_item, parent, false)) {
    private var eventName: TextView? = null
    private var participationType: TextView? = null
    private var date: TextView? = null
    private var whole: FrameLayout? = null


    init {
        eventName = itemView.findViewById(R.id.activityNameTextView)
        participationType = itemView.findViewById(R.id.participationTypeTextView)
        date = itemView.findViewById(R.id.activityDateTextView)
        whole = itemView.findViewById(R.id.participationBackground)
    }

    fun bind(group: Group) {
        if (group.image != -1) {
            whole?.background =
                    ResourcesCompat.getDrawable(parent.resources, group.image, null)
        } else {
            whole?.background =
                    ResourcesCompat.getDrawable(parent.resources, R.drawable.generic_group, null)
        }
        eventName?.text = group.name
        participationType?.text = group.description

        date?.text = group.location
    }
}
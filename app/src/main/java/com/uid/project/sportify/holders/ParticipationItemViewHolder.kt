package com.uid.project.sportify.holders

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.uid.project.sportify.R
import com.uid.project.sportify.models.Participation
import java.text.SimpleDateFormat

class ParticipationItemViewHolder(inflater: LayoutInflater, private var parent: ViewGroup) :
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

    fun bind(participation: Participation) {
        whole?.background =
            ResourcesCompat.getDrawable(parent.resources, participation.activity.image, null)
        eventName?.text = participation.activity.name
        participationType?.text = participation.type.toString()

        val pattern = "EEE, dd LLL"
        val simpleDateFormat = SimpleDateFormat(pattern)
        val dateAux = simpleDateFormat.format(participation.activity.date)

        date?.text = dateAux.toString()
    }
}
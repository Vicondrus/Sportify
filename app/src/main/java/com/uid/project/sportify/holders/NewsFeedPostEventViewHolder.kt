package com.uid.project.sportify.holders

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.uid.project.sportify.R
import com.uid.project.sportify.models.NewsFeedPost
import com.uid.project.sportify.models.NewsFeedPostEvent

class NewsFeedPostEventViewHolder(private val view: View) :
        RecyclerView.ViewHolder(view), View.OnClickListener {
    private var friendName: TextView? = null
    private var friendImage: ImageView? = null
    private var eventName: TextView? = null
    private var eventImage: ImageView? = null
    private var eventDate: TextView? = null
    private var eventTimeStart: TextView? = null
    private var eventTimeEnd: TextView? = null
    private var eventDescription: TextView? = null
    private var eventLocation: TextView? = null
    private var eventNbOfPeople: TextView? = null
    var eventDetailsBtn: Button? = null

    init {
        friendName = itemView.findViewById(R.id.newsFriendName1) as TextView
        friendImage = itemView.findViewById(R.id.placeBookedImg) as ImageView
        eventName = itemView.findViewById(R.id.newsEventName1) as TextView
        eventImage = itemView.findViewById(R.id.newsEventImage1) as ImageView
        eventDate = itemView.findViewById(R.id.newsEventDate1) as TextView
        eventTimeStart = itemView.findViewById(R.id.newsEventStart1) as TextView
        eventTimeEnd = itemView.findViewById(R.id.newsEventEnd1) as TextView
        eventDescription = itemView.findViewById(R.id.newsEventDescription1) as TextView
        eventLocation = itemView.findViewById(R.id.newsEventLocation1) as TextView
        eventNbOfPeople = itemView.findViewById(R.id.newsEventNbOfPeople1) as TextView
        eventDetailsBtn = itemView.findViewById(R.id.newsEventDetailsBtn1) as Button
    }

    fun bind(newsFeedPost: NewsFeedPost) {
        val newsFeedPostEvent = newsFeedPost as NewsFeedPostEvent
        friendName?.text = newsFeedPostEvent.friendName
        friendImage?.setImageResource(newsFeedPostEvent.friendImage)
        eventName?.text = newsFeedPostEvent.eventName
        eventImage?.setImageResource(newsFeedPostEvent.eventImage)
        eventDate?.text = newsFeedPostEvent.eventDate
        eventTimeStart?.text = newsFeedPostEvent.eventTimeStart
        eventTimeEnd?.text = newsFeedPostEvent.eventTimeEnd
        eventDescription?.text = newsFeedPostEvent.eventDescription
        eventLocation?.text = newsFeedPostEvent.eventLocation
        eventNbOfPeople?.text = newsFeedPostEvent.eventNbOfPeople
    }

    override fun onClick(view: View?) {
    }

}
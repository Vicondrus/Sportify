package com.uid.project.sportify

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.uid.project.sportify.adapters.RequirementsListAdapter
import com.uid.project.sportify.adapters.SportsListAdapter
import com.uid.project.sportify.adapters.TagsListAdapter
import com.uid.project.sportify.models.Event
import de.hdodenhof.circleimageview.CircleImageView

class EventPageOrganizerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_page_organizer)

        supportActionBar?.hide()

        val event = this.intent.getSerializableExtra("event") as Event

        val eventName = findViewById<TextView>(R.id.eventPageOrganizerEventName)
        eventName.text = event.name
        val eventImage = findViewById<CircleImageView>(R.id.eventPageOrganizerEventImage)
        eventImage.setCircleBackgroundColorResource(event.image)
        val eventDescription = findViewById<TextView>(R.id.eventPageOrganizerEventDescription)
        eventDescription.text = event.description
        val eventDate = findViewById<TextView>(R.id.eventPageOrganizerEventDate)
        eventDate.text = event.date.toString()
        val eventTime = findViewById<TextView>(R.id.eventPageOrganizerEventTime)
        eventTime.text = event.time.toString()
        val eventNbOfPeople = findViewById<TextView>(R.id.eventPageOrganizerEventNbOfPeople)
        eventNbOfPeople.text = event.nbOfPeople.toString()
        val eventAttendanceFee = findViewById<TextView>(R.id.eventPageOrganizerEventAttendanceFee)
        eventAttendanceFee.text = event.attendanceFee.toString()
        val eventLocation = findViewById<TextView>(R.id.eventPageOrganizerEventLocation)
        eventLocation.text = event.location
        val eventSports = findViewById<RecyclerView>(R.id.eventPageOrganizerEventSports)
        val sportsListAdapter = SportsListAdapter(event.sports)
        eventSports.adapter = sportsListAdapter
        val eventRequirements = findViewById<RecyclerView>(R.id.eventPageOrganizerEventRequirements)
        val requirementListAdapter = RequirementsListAdapter(event.requirements)
        eventRequirements.adapter = requirementListAdapter
        val eventTags = findViewById<RecyclerView>(R.id.eventPageOrganizerEventTags)
        val tagsListAdapter = TagsListAdapter(event.tags)
        eventTags.adapter = tagsListAdapter
    }
}
package com.uid.project.sportify

import android.net.Uri
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.huawei.hms.maps.HuaweiMap
import com.uid.project.sportify.adapters.RequirementsListAdapter
import com.uid.project.sportify.adapters.SportsListAdapter
import com.uid.project.sportify.adapters.TagsListAdapter
import com.uid.project.sportify.models.Registry
import de.hdodenhof.circleimageview.CircleImageView
import java.time.format.DateTimeFormatter

class EventPageOrganizerActivity : AppCompatActivity() {

    private lateinit var mMap: HuaweiMap
    private lateinit var sportsListAdapter: SportsListAdapter
    private lateinit var tagsListAdapter: TagsListAdapter
    private lateinit var requirementsListAdapter: RequirementsListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_page_organizer)

        supportActionBar?.hide()

//        val event = this.intent.getSerializableExtra("event") as Event
        val event = Registry.event1Manager

        val eventName = findViewById<TextView>(R.id.eventPageOrganizerEventName)
        eventName.text = event.name
        val eventImage = findViewById<CircleImageView>(R.id.eventPageOrganizerEventImage)
        eventImage.setImageURI(Uri.parse(event.imageUri))
        val eventDescription = findViewById<TextView>(R.id.eventPageOrganizerEventDescription)
        eventDescription.text = event.description
        val eventDate = findViewById<TextView>(R.id.eventPageOrganizerEventDate)
        eventDate.text = event.date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
        val eventTimeStart = findViewById<TextView>(R.id.eventPageOrganizerEventTimeStart)
        eventTimeStart.text = event.timeStart.format(DateTimeFormatter.ofPattern("HH:mm"))
        val eventTimeEnd = findViewById<TextView>(R.id.eventPageOrganizerEventTimeEnd)
        eventTimeEnd.text = event.timeEnd.format(DateTimeFormatter.ofPattern("HH:mm"))
        val eventNbOfPeople = findViewById<TextView>(R.id.eventPageOrganizerEventNbOfPeople)
        eventNbOfPeople.text = event.nbOfPeople.toString()
        val eventAttendanceFee = findViewById<TextView>(R.id.eventPageOrganizerEventAttendanceFee)
        eventAttendanceFee.text = event.attendanceFee.toString()
        val eventLocation = findViewById<TextView>(R.id.eventPageOrganizerEventLocation)
        eventLocation.text = event.location

        val layoutManagerSports = LinearLayoutManager(
            this@EventPageOrganizerActivity,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        val layoutManagerTags = LinearLayoutManager(
            this@EventPageOrganizerActivity,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        val layoutManagerRequirements = LinearLayoutManager(
            this@EventPageOrganizerActivity,
            LinearLayoutManager.HORIZONTAL,
            false
        )

        val sportsRecyclerView = findViewById<RecyclerView>(R.id.eventPageOrganizerEventSports)
        sportsRecyclerView.layoutManager = layoutManagerSports
        sportsListAdapter = SportsListAdapter(event.sports)
        sportsRecyclerView.adapter = sportsListAdapter

        val requirementsRecyclerView =
            findViewById<RecyclerView>(R.id.eventPageOrganizerEventRequirements)
        requirementsRecyclerView.layoutManager = layoutManagerRequirements
        requirementsListAdapter = RequirementsListAdapter(event.requirements)
        requirementsRecyclerView.adapter = requirementsListAdapter

        val tagsRecyclerView = findViewById<RecyclerView>(R.id.eventPageOrganizerEventTags)
        tagsRecyclerView.layoutManager = layoutManagerTags
        tagsListAdapter = TagsListAdapter(event.tags)
        tagsRecyclerView.adapter = tagsListAdapter
    }
}
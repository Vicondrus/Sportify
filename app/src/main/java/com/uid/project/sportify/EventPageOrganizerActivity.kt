package com.uid.project.sportify

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.huawei.hms.maps.HuaweiMap
import com.uid.project.sportify.adapters.RequirementsListAdapter
import com.uid.project.sportify.adapters.SportsListAdapter
import com.uid.project.sportify.adapters.TagsListAdapter
import com.uid.project.sportify.models.Event
import com.uid.project.sportify.models.Registry
import de.hdodenhof.circleimageview.CircleImageView
import java.time.format.DateTimeFormatter

class EventPageOrganizerActivity : AppCompatActivity() {

    private lateinit var mMap: HuaweiMap
    private lateinit var sportsListAdapter: SportsListAdapter
    private lateinit var tagsListAdapter: TagsListAdapter
    private lateinit var requirementsListAdapter: RequirementsListAdapter
    private lateinit var eventImage : CircleImageView
    private lateinit var event: Event
    private val editEventId = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_page_organizer)

        supportActionBar?.hide()

        event = intent.getSerializableExtra("event") as Event

        val eventName = findViewById<TextView>(R.id.eventPageOrganizerEventName)
        eventName.text = event.name
        val eventImage = findViewById<CircleImageView>(R.id.eventPageOrganizerEventImage)
        if (event.imageUri == null) {
            eventImage.setImageResource(event.image)
        } else {
            eventImage.setImageURI(Uri.parse(event.imageUri))
        }
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
        eventLocation.text = event.location.location
        val eventNeighborhood = findViewById<TextView>(R.id.eventPageOrganizerEventNeighborhood)
        eventNeighborhood.text = event.location.neighborhood

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


        val editEventButton = findViewById<ImageButton>(R.id.editEventButton)
        editEventButton.setOnClickListener {
            val intent = Intent(this, EditEventActivity::class.java)
            intent.putExtra("event", event)
            startActivityForResult(intent, editEventId)
        }

        val delegateFriendButton = findViewById<Button>(R.id.eventDelegateFriendBtn)
        delegateFriendButton.setOnClickListener {
            val intent = Intent(this, FriendListActivity::class.java)
            intent.putExtra("activityName", "Delegate friend")
            intent.putExtra("eventName", event.name)
            startActivity(intent)
        }

        val scanQRCodeButton = findViewById<Button>(R.id.eventScanQRCodeBtn)
        scanQRCodeButton.setOnClickListener {
            val intent1 = Intent(this, ScanActivity::class.java)
            intent1.putExtra("eventName", event.name)
            intent1.putExtra("eventDate", event.date.toString())
            intent1.putExtra("timeStart", event.timeStart.toString())
            intent1.putExtra("timeEnd", event.timeEnd.toString())
            intent1.putExtra("eventLocation", event.location.location)
            if (event.imageUri == null) {
                intent1.putExtra("image", event.image)
            } else {
                intent1.putExtra("image", event.imageUri)
            }
            startActivity(intent1)
        }

        val backButton = findViewById<ImageButton>(R.id.eventPageOrganizerBackBtn)
        backButton.setOnClickListener {
            val intent = Intent(this, NewsFeedActivity::class.java)
            startActivity(intent)
            this.finish()
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == editEventId) {
            if (resultCode == Activity.RESULT_OK) {
                // Remove the event from the registry
                Registry.listOfOrganizedEvents.removeIf { ev -> ev.name == event.name }
                // Get the edited event
                event = data?.getSerializableExtra("eventEdited") as Event
                // Add the edited event to registry
                Registry.listOfOrganizedEvents.add(event)
                // Update fields
                val eventName = findViewById<TextView>(R.id.eventPageOrganizerEventName)
                eventName.text = event.name
                eventImage = findViewById(R.id.eventPageOrganizerEventImage)
                if (event.imageUri == null) {
                    eventImage.setImageResource(event.image)
                } else {
                    eventImage.setImageURI(Uri.parse(event.imageUri))
                }
                val eventDescription =
                        findViewById<TextView>(R.id.eventPageOrganizerEventDescription)
                eventDescription.text = event.description
                val eventDate = findViewById<TextView>(R.id.eventPageOrganizerEventDate)
                eventDate.text = event.date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                val eventTimeStart = findViewById<TextView>(R.id.eventPageOrganizerEventTimeStart)
                eventTimeStart.text = event.timeStart.format(DateTimeFormatter.ofPattern("HH:mm"))
                val eventTimeEnd = findViewById<TextView>(R.id.eventPageOrganizerEventTimeEnd)
                eventTimeEnd.text = event.timeEnd.format(DateTimeFormatter.ofPattern("HH:mm"))
                val eventNbOfPeople = findViewById<TextView>(R.id.eventPageOrganizerEventNbOfPeople)
                eventNbOfPeople.text = event.nbOfPeople.toString()
                val eventAttendanceFee =
                    findViewById<TextView>(R.id.eventPageOrganizerEventAttendanceFee)
                eventAttendanceFee.text = event.attendanceFee.toString()
                val eventLocation = findViewById<TextView>(R.id.eventPageOrganizerEventLocation)
                eventLocation.text = event.location.location
                val eventNeighborhood =
                    findViewById<TextView>(R.id.eventPageOrganizerEventNeighborhood)
                eventNeighborhood.text = event.location.neighborhood

                val sportsRecyclerView =
                    findViewById<RecyclerView>(R.id.eventPageOrganizerEventSports)
                sportsListAdapter = SportsListAdapter(event.sports)
                sportsRecyclerView.adapter = sportsListAdapter

                val requirementsRecyclerView =
                    findViewById<RecyclerView>(R.id.eventPageOrganizerEventRequirements)
                requirementsListAdapter = RequirementsListAdapter(event.requirements)
                requirementsRecyclerView.adapter = requirementsListAdapter

                val tagsRecyclerView = findViewById<RecyclerView>(R.id.eventPageOrganizerEventTags)
                tagsListAdapter = TagsListAdapter(event.tags)
                tagsRecyclerView.adapter = tagsListAdapter

            }
        }
    }

    override fun onBackPressed() {
        val intent = Intent(this, NewsFeedActivity::class.java)
        startActivity(intent)
        this.finish()
    }
}
package com.uid.project.sportify

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
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

class EventPageUserActivity : AppCompatActivity() {

    private lateinit var mMap: HuaweiMap
    private lateinit var sportsListAdapter: SportsListAdapter
    private lateinit var tagsListAdapter: TagsListAdapter
    private lateinit var requirementsListAdapter: RequirementsListAdapter
    private var isGoing: Boolean = false
    private var user = Registry.user1Manager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_page_user)

        supportActionBar?.hide()

        val event = intent.getSerializableExtra("event") as Event

        Log.d("EVENT IN USER ACT", event.toString())

        val eventName = findViewById<TextView>(R.id.eventPageUserEventName)
        eventName.text = event.name
        val eventImage = findViewById<CircleImageView>(R.id.eventPageUserEventImage)
        if (event.imageUri == null) {
            eventImage.setImageResource(event.image)
        } else {
            eventImage.setImageURI(Uri.parse(event.imageUri))
        }
        val eventDescription = findViewById<TextView>(R.id.eventPageUserEventDescription)
        eventDescription.text = event.description
        val eventHostName = findViewById<TextView>(R.id.eventHostName)
        eventHostName.text = event.host
        val eventDate = findViewById<TextView>(R.id.eventPageUserEventDate)
        eventDate.text = event.date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
        val eventTimeStart = findViewById<TextView>(R.id.eventPageUserEventTimeStart)
        eventTimeStart.text = event.timeStart.format(DateTimeFormatter.ofPattern("HH:mm"))
        val eventTimeEnd = findViewById<TextView>(R.id.eventPageUserEventTimeEnd)
        eventTimeEnd.text = event.timeEnd.format(DateTimeFormatter.ofPattern("HH:mm"))
        val eventNbOfPeople = findViewById<TextView>(R.id.eventPageUserEventNbOfPeople)
        eventNbOfPeople.text = event.nbOfPeople.toString()
        val eventAttendanceFee = findViewById<TextView>(R.id.eventPageUserEventAttendanceFee)
        eventAttendanceFee.text = event.attendanceFee.toString()
        val eventLocation = findViewById<TextView>(R.id.eventPageUserEventLocation)
        eventLocation.text = event.location.location
        val eventNeighborhood = findViewById<TextView>(R.id.eventPageUserEventNeighborhood)
        eventNeighborhood.text = event.location.neighborhood
        val eventSpotsLeft = findViewById<TextView>(R.id.spotsLeftTextView)
        if (event.participants == event.nbOfPeople) {
            eventSpotsLeft.text = "No"
        } else {
            eventSpotsLeft.text = (event.nbOfPeople - event.participants).toString()
        }

        val layoutManagerSports = LinearLayoutManager(
            this@EventPageUserActivity,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        val layoutManagerTags = LinearLayoutManager(
            this@EventPageUserActivity,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        val layoutManagerRequirements = LinearLayoutManager(
            this@EventPageUserActivity,
            LinearLayoutManager.HORIZONTAL,
            false
        )

        val sportsRecyclerView = findViewById<RecyclerView>(R.id.eventPageUserEventSports)
        sportsRecyclerView.layoutManager = layoutManagerSports
        sportsListAdapter = SportsListAdapter(event.sports)
        sportsRecyclerView.adapter = sportsListAdapter

        val requirementsRecyclerView =
            findViewById<RecyclerView>(R.id.eventPageUserEventRequirements)
        requirementsRecyclerView.layoutManager = layoutManagerRequirements
        requirementsListAdapter = RequirementsListAdapter(event.requirements)
        requirementsRecyclerView.adapter = requirementsListAdapter

        val tagsRecyclerView = findViewById<RecyclerView>(R.id.eventPageUserEventTags)
        tagsRecyclerView.layoutManager = layoutManagerTags
        tagsListAdapter = TagsListAdapter(event.tags)
        tagsRecyclerView.adapter = tagsListAdapter


        val goingTextView = findViewById<TextView>(R.id.goingTextView)
        val goingButton = findViewById<ImageButton>(R.id.eventGoingBtn)

        // if event participant list contains user1
        if (event.participantsList.contains(user.name)) {
            isGoing = true
            goingTextView.text = resources.getString(R.string.youAreGoingLabel)
            goingButton.setImageResource(R.drawable.ic_cancel)
        }

        // if no more spots left
        if (!isGoing && event.participants == event.nbOfPeople) {
            goingButton.isEnabled = false
            goingButton.isClickable = false
        }



        goingButton.setOnClickListener {
            if (!isGoing) { // user wants to go
                event.participants += 1
                event.participantsList.add(user.name)
//                user.participations.add(Participation())
                goingTextView.text = resources.getString(R.string.youAreGoingLabel)
                goingButton.setImageResource(R.drawable.ic_cancel)
                if (event.participants == event.nbOfPeople) {
                    eventSpotsLeft.text = "No"
                } else {
                    eventSpotsLeft.text = (event.nbOfPeople - event.participants).toString()
                }

            } else { // user does not want to go anymore
                event.participants -= 1
                event.participantsList.remove(Registry.user1Manager.name)
                goingTextView.text = resources.getString(R.string.areYouGoingLabel)
                goingButton.setImageResource(R.drawable.ic_check)
                eventSpotsLeft.text = (event.nbOfPeople - event.participants).toString()
            }
            isGoing = !isGoing
        }

        val tellFriends = findViewById<Button>(R.id.eventUserTellFriendBtn)
        tellFriends.setOnClickListener {
            val intent = Intent(this, FriendListActivity::class.java)
            intent.putExtra("activityName", "Invite friends")
            intent.putExtra("eventName", event.name)
            startActivity(intent)
        }
    }

}
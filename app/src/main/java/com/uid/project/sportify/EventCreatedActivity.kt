package com.uid.project.sportify

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.uid.project.sportify.models.Registry
import de.hdodenhof.circleimageview.CircleImageView

class EventCreatedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_created)

        supportActionBar?.hide()

//        val event = this.intent.getSerializableExtra("event") as Event
        val event = Registry.event1Manager

        val eventNameContainer = findViewById<TextView>(R.id.eventCreatedEventNameTextView)
        eventNameContainer.text = event.name
        val eventImage = findViewById<CircleImageView>(R.id.eventCreatedEventImage)
        eventImage.setImageURI(Uri.parse(event.imageUri))

        val eventCreatedButton = findViewById<Button>(R.id.eventCreatedDoneButton)
        eventCreatedButton.setOnClickListener {
            val intent = Intent(this, EventPageOrganizerActivity::class.java)
            intent.putExtra("event", event)
            startActivity(intent)
        }

        val tellFriendsButton = findViewById<Button>(R.id.eventCreatedTellFriendsButton)
        tellFriendsButton.setOnClickListener {
            val intent = Intent(this, FriendListActivity::class.java)
            intent.putExtra("activityName", "Invite friends")
            intent.putExtra("eventName", event.name)
            startActivity(intent)
        }


    }
}
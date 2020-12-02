package com.uid.project.sportify

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.uid.project.sportify.models.Event

class EventCreatedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_created)

        val event = this.intent.getSerializableExtra("event") as Event

        val eventNameContainer = findViewById<TextView>(R.id.eventCreatedEventNameTextView)
        eventNameContainer.text = event.name

        val eventCreatedButton = findViewById<Button>(R.id.eventCreatedDoneButton)
        eventCreatedButton.setOnClickListener {
            val intent = Intent(this, EventPageOrganizerActivity::class.java)
            intent.putExtra("event", event)
            startActivity(intent)
        }


    }
}
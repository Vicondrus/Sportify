package com.uid.project.sportify

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PlaceBookedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_place_booked)

        supportActionBar?.hide()
        val place = this.intent.getSerializableExtra("placeName") as String
        val txtPlace=findViewById<TextView>(R.id.eventCreatedEventNameTextView)
       /* val event = this.intent.getSerializableExtra("event") as Event

        val eventNameContainer = findViewById<TextView>(R.id.eventCreatedEventNameTextView)
        eventNameContainer.text = event.name*/
        txtPlace.setText(place)
        val btnDone = findViewById<Button>(R.id.btnEventCreatedDone)
        btnDone.setOnClickListener {
            val intent = Intent(this, PlacesResultActivity::class.java)
            startActivity(intent)
        }


    }
}
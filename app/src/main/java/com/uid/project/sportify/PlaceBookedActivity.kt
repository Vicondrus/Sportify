package com.uid.project.sportify

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.uid.project.sportify.models.PlaceResult

class PlaceBookedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_place_booked)

        supportActionBar?.hide()
        val place = intent.getStringExtra("placeName")
        val placeObj = intent.getSerializableExtra("placeObj") as PlaceResult
        val txtPlace = findViewById<TextView>(R.id.eventCreatedEventNameTextView)

        val imgPlace = findViewById<ImageView>(R.id.newsFriendImage1)
        /* val event = this.intent.getSerializableExtra("event") as Event
         val eventNameContainer = findViewById<TextView>(R.id.eventCreatedEventNameTextView)
         eventNameContainer.text = event.name*/
        txtPlace.text = place.toString()
        imgPlace.setImageResource(placeObj.placeImage)
        val btnDone = findViewById<Button>(R.id.btnEventCreatedDone)
        btnDone.setOnClickListener {
            val intent = Intent(this, PlacesResultActivity::class.java)
            startActivity(intent)
        }


    }
}
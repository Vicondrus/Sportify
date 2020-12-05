package com.uid.project.sportify

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.uid.project.sportify.models.Event
import com.uid.project.sportify.models.Registry
import com.uid.project.sportify.models.Sport
import java.time.LocalDate
import java.time.LocalTime

class CreateEventActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_event)

        val button = findViewById<Button>(R.id.createEventButton)
        button.setOnClickListener {

            val eventName = findViewById<EditText>(R.id.eventNameTextView).text.toString()
            val eventImage = R.id.eventImage
            val eventHostName = Registry.user1Manager.name
            val eventDescription = findViewById<EditText>(R.id.eventDescriptionTextView).text.toString()
//            val eventDate= LocalDate.parse(findViewById<EditText>(R.id.eventDateDate).text.toString())
            val eventDate = LocalDate.now()
//            val eventTime=LocalTime.parse(findViewById<EditText>(R.id.eventTimeTime).text.toString())
            val eventTime = LocalTime.now()
            val eventNbOfPeople = findViewById<EditText>(R.id.eventNbOfPeopleTextView).text.toString().toInt()
            val eventAttendanceFee = findViewById<EditText>(R.id.eventAttendanceFeeTextView).text.toString().toInt()
            val eventLocation = "Hardcoded location"
            val eventSports = ArrayList<Sport>()
            val eventRequirements = ArrayList<String>()
            val eventTags = ArrayList<String>()
//            TO DO!!!!
//            val eventLocation=
//            val eventSports=findViewById<RecyclerView>(R.id.eventSportsReciclerView)
//            val eventRequirements=findViewById<RecyclerView>(R.id.eventRequirementsReciclerView)
//            val eventTags=findViewById<RecyclerView>(R.id.eventSportsReciclerView)
            val event = Event(eventName, eventImage, eventHostName, eventDescription, eventDate, eventTime, eventNbOfPeople, eventAttendanceFee, eventLocation, eventSports, eventRequirements, eventTags)
            val intent = Intent(this, EventCreatedActivity::class.java)
            intent.putExtra("host", eventHostName)
            intent.putExtra("date", eventDate)
            intent.putExtra("sports", eventSports)
            intent.putExtra("event", event)
            startActivity(intent)
        }
    }
}
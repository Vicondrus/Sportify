package com.uid.project.sportify

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ButtonsPageAddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buttons_page_add)

        supportActionBar?.hide()

        val createEventButton = findViewById<Button>(R.id.buttonsPageCreateEventBtn)
        createEventButton.setOnClickListener {
            val intent = Intent(this, CreateEventActivity::class.java)
            startActivity(intent)
        }

        val createGroupButton = findViewById<Button>(R.id.buttonsPageCreateGroupBtn)
        createGroupButton.setOnClickListener {
            val intent = Intent(this, CreateGroupActivity::class.java)
            startActivity(intent)
        }
        val bookPlaceButton = findViewById<Button>(R.id.buttonsPageBookPlaceBtn)

        bookPlaceButton.setOnClickListener {
            val intent = Intent(this, CalendarActivity::class.java)
            startActivity(intent)
        }
    }
}
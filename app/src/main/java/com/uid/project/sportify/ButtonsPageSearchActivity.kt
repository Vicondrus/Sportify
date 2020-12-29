package com.uid.project.sportify


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.uid.project.sportify.R

class ButtonsPageSearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buttons_page_search)

        supportActionBar?.hide()

        val searchUserButton = findViewById<Button>(R.id.btnSearchUser)
        val searchEventButton = findViewById<Button>(R.id.btnSearchEvent)
        searchUserButton.setOnClickListener {
            val intent = Intent(this, SearchUserActivity::class.java)
            startActivity(intent)
        }

        searchEventButton.setOnClickListener {
            val intent = Intent(this, SearchEventActivity::class.java)
            startActivity(intent)
        }
    }
}
package com.uid.project.sportify

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ViewEventCodeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_event_code)

    }
    override fun onBackPressed() {
        finish()
    }

}
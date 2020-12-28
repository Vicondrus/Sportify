package com.uid.project.sportify

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import de.hdodenhof.circleimageview.CircleImageView

class ActivityRegisterConfirmation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_register_confirmation)

        var titleEvent = findViewById<TextView>(R.id.textView38)
        var dateEvent = findViewById<TextView>(R.id.textView39)
        var location = findViewById<TextView>(R.id.textView40)
        var image = findViewById<CircleImageView>(R.id.imageViewGroupCreated2)

        titleEvent.text = intent.getStringExtra("eventName")
        location.text = intent.getStringExtra("eventLocation")
        dateEvent.text = intent.getStringExtra("eventDateTime")
        image.setImageResource(intent.getIntExtra("image", R.drawable.running))
    }

    override fun onBackPressed() {
        finish()
    }

    fun doneEvent(view : View){
        setResult(1)
        finish()
    }
}
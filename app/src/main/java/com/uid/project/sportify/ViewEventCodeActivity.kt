package com.uid.project.sportify

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text

class ViewEventCodeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_event_code)

        val buttonDone = findViewById<Button>(R.id.button8)
        val buttonBack = findViewById<ImageButton>(R.id.imageButton11)

        buttonBack.setOnClickListener{
            this.finish()
        }

        buttonDone.setOnClickListener {
            this.finish()
        }

        var titleEvent = findViewById<TextView>(R.id.textView21)
        var dateEvent = findViewById<TextView>(R.id.textView19)
        var location = findViewById<TextView>(R.id.textView36)
        var image = findViewById<ImageView>(R.id.imageView16)

        titleEvent.text = intent.getStringExtra("eventName")
        location.text = intent.getStringExtra("eventLocation")
        var dateTime = intent.getStringExtra("eventDate") + " at " +
                intent.getStringExtra("timeStart") +
                getString(R.string.dashLabel) +
                intent.getStringExtra("timeEnd")
        dateEvent.text = dateTime
        image.setImageResource(intent.getIntExtra("image", R.drawable.running))
    }
}
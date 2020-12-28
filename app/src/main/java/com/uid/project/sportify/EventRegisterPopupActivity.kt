package com.uid.project.sportify

import android.app.Activity
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class EventRegisterPopupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.event_register_popup)

        val shape = GradientDrawable()
        shape.cornerRadius = 40f
        shape.setColor(getColor(R.color.purple_sportify))
        val playerButton = findViewById<Button>(R.id.playerButton)
        playerButton.background = shape
        val guestButton = findViewById<Button>(R.id.guestButton)
        guestButton.background = shape
        window.setBackgroundDrawable(ColorDrawable(getColor(R.color.dark_tone_sportify)))

    }
    fun registerAsPlayer(view: View) {
        val intent1 = Intent(this, TermsAndConditionsActivity::class.java)
        intent1.putExtra("eventName", intent.getStringExtra("eventName"))
        intent1.putExtra("eventDateTime", intent.getStringExtra("eventDate") + " at " +
                intent.getStringExtra("timeStart") +
                getString(R.string.dashLabel) +
                intent.getStringExtra("timeEnd"))
        intent1.putExtra("eventLocation", intent.getStringExtra("eventLocation"))
        intent1.putExtra("image", intent.getIntExtra("image", R.drawable.running))
        intent1.putExtra("type", "player")
        intent1.putExtra("event", intent.getSerializableExtra("event"))
        setResult(Activity.RESULT_OK, intent)
        finish()
        startActivity(intent1)
    }

    fun registerAsSpectator(view: View) {
        val intent1 = Intent(this, TermsAndConditionsActivity::class.java)
        intent1.putExtra("eventName", intent.getStringExtra("eventName"))
        intent1.putExtra("eventDateTime", intent.getStringExtra("eventDate") + " at " +
                intent.getStringExtra("timeStart") +
                getString(R.string.dashLabel) +
                intent.getStringExtra("timeEnd"))
        intent1.putExtra("eventLocation", intent.getStringExtra("eventLocation"))
        intent1.putExtra("image", intent.getIntExtra("image", R.drawable.running))
        intent1.putExtra("type", "spectator")
        setResult(Activity.RESULT_OK, intent)
        finish()
        startActivity(intent1)
    }
}
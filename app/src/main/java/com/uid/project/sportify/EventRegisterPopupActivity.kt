package com.uid.project.sportify

import android.app.Activity
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity


class EventRegisterPopupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.event_register_popup)

        val shape = GradientDrawable()
        shape.cornerRadius = 40f
        shape.setColor(getColor(R.color.purple_sportify))


        window.setBackgroundDrawable(ColorDrawable(getColor(R.color.dark_tone_sportify)))

    }
    fun registerAsPlayer(view: View) {
        val intent = Intent(this, TermsAndConditionsActivity::class.java)
        intent.putExtra("type", "player")
        setResult(Activity.RESULT_OK, intent)
        finish()
    }

    fun registerAsSpectator(view: View) {
        val intent = Intent(this, TermsAndConditionsActivity::class.java)
        intent.putExtra("type", "spectator")
        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}
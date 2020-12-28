package com.uid.project.sportify

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class ActivityRegisterConfirmation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_register_confirmation)
    }

    override fun onBackPressed() {
        finish()
    }

    fun continueEvent(view : View){
        finish()
    }
}
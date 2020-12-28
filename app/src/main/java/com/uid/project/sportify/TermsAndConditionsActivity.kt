package com.uid.project.sportify

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class TermsAndConditionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.terms_conditions_layout)
    }


    fun continueEvent(view: View){
        val intent = Intent(this, LevelsEventActivity::class.java)
        startActivityForResult(intent, 1)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {
        if (requestCode == 1) {
            if (resultCode == 1) {
                finish()

            }
        }
    }
}
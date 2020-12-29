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
        if (intent.getStringExtra("type") == "spectator"){
            val intent1 = Intent(this, ActivityRegisterConfirmation::class.java)
            intent1.putExtra("eventName", intent.getStringExtra("eventName"))
            intent1.putExtra("eventDateTime", intent.getStringExtra("eventDateTime"))
            intent1.putExtra("eventLocation", intent.getStringExtra("eventLocation"))
            intent1.putExtra("image", intent.getIntExtra("image", R.drawable.running))
            startActivityForResult(intent1, 1)
        }else {
            val intent1 = Intent(this, LevelsEventActivity::class.java)
            intent1.putExtra("eventName", intent.getStringExtra("eventName"))
            intent1.putExtra("eventDateTime", intent.getStringExtra("eventDateTime"))
            intent1.putExtra("eventLocation", intent.getStringExtra("eventLocation"))
            intent1.putExtra("image", intent.getIntExtra("image", R.drawable.running))
            intent1.putExtra("event", intent.getSerializableExtra("event"))
            startActivityForResult(intent1, 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {
        if (requestCode == 1) {
            if (resultCode == 1) {
                setResult(2)
                finish()

            }
        }
    }
}
package com.uid.project.sportify

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.uid.project.sportify.models.PlaceResult

class PaymentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_2)
        supportActionBar?.hide()

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Please Confirm")
        builder.setMessage("Are you sure you want to continue?")
//builder.setPositiveButton("OK", DialogInterface.OnClickListener(function = x))
        val place = intent.getStringExtra("placeName") as String

        val placeObj = intent.getSerializableExtra("place") as PlaceResult
        builder.setPositiveButton(android.R.string.yes) { dialog, which ->
            val intent = Intent(this@PaymentActivity, PlaceBookedActivity::class.java)
            intent.putExtra("placeName", place.toString())
            intent.putExtra("placeObj", placeObj)
            startActivity(intent)
        }

        builder.setNegativeButton(android.R.string.no) { dialog, which ->
            Toast.makeText(applicationContext,
                    android.R.string.no, Toast.LENGTH_SHORT).show()
        }


        val btnContinue = findViewById<Button>(R.id.btnContinue)
        btnContinue.setOnClickListener {
            builder.show()
        }

    }
}
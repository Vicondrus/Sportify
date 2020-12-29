package com.uid.project.sportify

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.uid.project.sportify.models.PlaceResult
import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class PaymentActivity : AppCompatActivity() {
    val DATE_FORMAT = "yyyy-mm-dd"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_2)
        supportActionBar?.hide()
        val placeDate=findViewById<EditText>(R.id.placeDate)
        val eventTimeTime=findViewById<EditText>(R.id.eventTimeTime)
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
            Toast.makeText(
                    applicationContext,
                    android.R.string.no, Toast.LENGTH_SHORT
            ).show()
        }


        val btnContinue = findViewById<Button>(R.id.btnContinue)
        btnContinue.setOnClickListener {
            if(isDateValid(placeDate.text.toString())==false){
                Toast.makeText(applicationContext, "Begin date is not valid. Please enter in format yyyy-mm-dd ", Toast.LENGTH_SHORT).show()

            }
            else
                if((isDateValid(eventTimeTime.text.toString()))==false){
                    Toast.makeText(applicationContext, "End date is not valid. Please enter in format yyyy-mm-dd ", Toast.LENGTH_SHORT).show()


                }
                else if(isDateValid(placeDate.text.toString()) && isDateValid(eventTimeTime.text.toString())){

                    builder.show()
                }

        }

    }




    fun isDateValid(date: String?): Boolean {
        /*return try {
            val df: DateFormat = SimpleDateFormat(DATE_FORMAT)
            df.setLenient(false)
            df.parse(date)
            true
        } catch (e: ParseException) {
            false
        }*/
        try {var formatter = SimpleDateFormat("yyyy-mm-dd", Locale.getDefault())
            val date = formatter.parse(date)
            return true}catch (e: ParseException) {
            return false
        }
    }
}
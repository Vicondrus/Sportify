package com.uid.project.sportify

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.text.TextUtils
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.uid.project.sportify.models.PlaceResult
import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class PaymentActivity : AppCompatActivity() {
    val DATE_FORMAT = "yyyy-mm-dd"
    private lateinit var placeDate : EditText
    private lateinit var  eventTimeTime : EditText
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
            Toast.makeText(
                    applicationContext,
                    android.R.string.no, Toast.LENGTH_SHORT
            ).show()
        }


        val btnContinue = findViewById<Button>(R.id.btnContinue)
        btnContinue.setOnClickListener {
            if(validateDetails()){
                    builder.show()
                }
        }
        placeDate=findViewById(R.id.placeDate)
        placeDate.inputType = InputType.TYPE_NULL
        eventTimeTime=findViewById(R.id.eventTimeTime)
        eventTimeTime.inputType = InputType.TYPE_NULL
        /**
         * Date
         */

        placeDate.setOnClickListener {
            val calendar: Calendar = Calendar.getInstance()
            val day = calendar.get(Calendar.DAY_OF_MONTH)
            val month = calendar.get(Calendar.MONTH)
            val year = calendar.get(Calendar.YEAR)
            val datePicker = DatePickerDialog(
                this,
                { view, year, monthOfYear, dayOfMonth ->
                    var dayOfMonthString = dayOfMonth.toString()
                    var monthOfYearString = (monthOfYear + 1).toString()
                    if (dayOfMonth < 10) {
                        dayOfMonthString = "0" + dayOfMonthString
                    }
                    if (monthOfYear < 9) {
                        monthOfYearString = "0" + monthOfYearString
                    }
                    placeDate.setText("" + dayOfMonthString + "/" + (monthOfYearString) + "/" + year)
                },
                year,
                month,
                day
            )
            datePicker.show()
        }
        eventTimeTime.setOnClickListener {
            val calendar: Calendar = Calendar.getInstance()
            val day = calendar.get(Calendar.DAY_OF_MONTH)
            val month = calendar.get(Calendar.MONTH)
            val year = calendar.get(Calendar.YEAR)
            val datePicker = DatePickerDialog(
                this,
                { view, year, monthOfYear, dayOfMonth ->
                    var dayOfMonthString = dayOfMonth.toString()
                    var monthOfYearString = (monthOfYear + 1).toString()
                    if (dayOfMonth < 10) {
                        dayOfMonthString = "0" + dayOfMonthString
                    }
                    if (monthOfYear < 9) {
                        monthOfYearString = "0" + monthOfYearString
                    }
                    eventTimeTime.setText("" + dayOfMonthString + "/" + (monthOfYearString) + "/" + year)
                },
                year,
                month,
                day
            )
            datePicker.show()
        }

    }


        fun validateDetails():Boolean{
            val addressTextView = findViewById(R.id.addressTextView) as EditText
            val addressText: String = addressTextView.text.toString()
            val emailAddressTextView = findViewById(R.id.emailAddressTextView) as EditText
            val emailText: String = emailAddressTextView.text.toString()
            val phoneNumberTextView= findViewById(R.id.phoneNumberTextView) as EditText
            val numberParticipantsTextView= findViewById(R.id.numberParticipantsTextView) as EditText
            val phoneNumberText: String = phoneNumberTextView.text.toString()
            val numberParticipantsText: String = numberParticipantsTextView.text.toString()

            //check if the EditText have values or not
            if(addressText.trim().length==0) {
                Toast.makeText(applicationContext, "Please enter an address! ", Toast.LENGTH_SHORT).show()
                    return false;
            }
            else   if(emailText.trim().length==0){

                Toast.makeText(applicationContext, "Please enter an email! ", Toast.LENGTH_SHORT).show()
                return false;
            }else   if(phoneNumberText.trim().length==0){

                Toast.makeText(applicationContext, "Please enter a phone number! ", Toast.LENGTH_SHORT).show()
                return false;
            }
            else   if(numberParticipantsText.trim().length==0){

                Toast.makeText(applicationContext, "Please enter a number of participants! ", Toast.LENGTH_SHORT).show()
                return false;
            }
            else if (isValidEmail(emailText)==false){
                Toast.makeText(applicationContext, "Please enter a valid email! ", Toast.LENGTH_SHORT).show()
                return false;
            }
            else if(isDateValid(placeDate.text.toString())==false){
                Toast.makeText(applicationContext, "Begin date is not valid. Please enter in format dd/MM/yyyy ", Toast.LENGTH_SHORT).show()
                return false;
            }
            else
                if((isDateValid(eventTimeTime.text.toString()))==false){
                    Toast.makeText(applicationContext, "End date is not valid. Please enter in format dd/MM/yyyy ", Toast.LENGTH_SHORT).show()
                    return false;

                }

            return true;
        }

    private fun isValidEmail(email: String): Boolean {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun isDateValid(date: String?): Boolean {

        try {var formatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
            val date = formatter.parse(date)
            return true}catch (e: ParseException) {
            return false
        }
    }



}
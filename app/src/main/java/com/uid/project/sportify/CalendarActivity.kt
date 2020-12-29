package com.uid.project.sportify

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CalendarView
import androidx.appcompat.app.AppCompatActivity
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class CalendarActivity : AppCompatActivity() {
    var selectedDates: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)
        val calendarView = findViewById<CalendarView>(R.id.calender)
        val calendar = Calendar.getInstance()
        calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            // set the calendar date as calendar view selected date
            calendar.set(year, month, dayOfMonth)

            // set this date as calendar view selected date
            calendarView.date = calendar.timeInMillis
            val sdf = SimpleDateFormat("yyyy-MM-dd")
            selectedDates = sdf.format(Date(year - 1900, month, dayOfMonth))

            Log.v("dateee", selectedDates)
            // format the calendar view selected date
            val dateFormatter = DateFormat.getDateInstance(DateFormat.MEDIUM)


        }
        val button = findViewById<Button>(R.id.btnDoneCalendar)
        button.setOnClickListener {
            // get calendar view selected date
            val selectedDate: Long = calendarView.date

            // set the calendar date as calendar view selected date
            calendar.timeInMillis = selectedDate

            // format the calendar view selected date
            val dateFormatter = DateFormat.getDateInstance(DateFormat.MEDIUM)
            //dateFormatter.format(calendar.time)

            val intent = Intent(this, PlacesResultActivity::class.java)
            intent.putExtra("date", selectedDates)
            startActivity(intent)
        }
        supportActionBar?.hide()
    }


}
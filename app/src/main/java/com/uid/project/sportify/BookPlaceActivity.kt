package com.uid.project.sportify

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.RatingBar
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.uid.project.sportify.models.Event
import com.uid.project.sportify.models.PlaceResult

class BookPlaceActivity : AppCompatActivity() {

    var location:String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_book_place)
        supportActionBar?.hide()

       /* val description=intent.getStringExtra("description")
       // val description = bundle?.get("description")
      //   location = bundle?.get("location") as String
      //  val descriptionTextView= findViewById<TextView>(R.id.txtDescription)
       val locationTextView= findViewById<TextView>(R.id.txtLocation)
        if (description != null) {
            Log.v("incercare",description)
        }
        locationTextView.setText(description)
                // descriptionTextView.text= description as CharSequence?
        // Enables Always-on*/
        val place = this.intent.getSerializableExtra("place") as PlaceResult
        val btnBookPlace=findViewById<Button>(R.id.btnBookDetails)
        val locationTextView= findViewById<TextView>(R.id.locationTxt)
        locationTextView.text = place.placeName
        val descriptionTextView= findViewById<TextView>(R.id.descriptionDetailsTxt)
        descriptionTextView.text = place.placeDescription
        val ratingBar= findViewById<RatingBar>(R.id.ratingBar)
        ratingBar.rating = place.placeRating.toFloat()
        Log.v("incercare",place.placeName)
        locationTextView.setTextColor(Color.parseColor("#FFFFFF"))
        btnBookPlace.setOnClickListener {
            val intent = Intent(this@BookPlaceActivity, PlaceBookedActivity::class.java)
            startActivity(intent)
        }

    }
}
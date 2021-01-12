package com.uid.project.sportify

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.uid.project.sportify.models.PlaceResult

class BookPlaceActivity : AppCompatActivity() {

    var location: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_book_place)
        supportActionBar?.hide()


        val place = this.intent.getSerializableExtra("place") as PlaceResult
        val namePlace = findViewById<TextView>(R.id.txtUsersHeader)
        val btnBookPlace = findViewById<Button>(R.id.btnBookDetails)
        val locationTextView = findViewById<TextView>(R.id.locationTxt)
        val priceTxt = findViewById<TextView>(R.id.priceTxt)
        val placeDetailsImage = findViewById<ImageView>(R.id.placeDetailsImage)
        val descriptionDetails = findViewById<TextView>(R.id.descriptionDetailsTxt)
        priceTxt.text = place.placePrice
        locationTextView.text = place.placeLocation
        namePlace.text = place.placeName
        val descriptionTextView = findViewById<TextView>(R.id.descriptionDetailsTxt)
        descriptionTextView.text = place.placeDescription

        val placeSportType = findViewById<TextView>(R.id.sportSuitableTxt)
        placeSportType.text=place.suitableSport
        val ratingBar = findViewById<RatingBar>(R.id.ratingBar)
        ratingBar.rating = place.placeRating.toFloat()
        descriptionDetails.text = place.placeDescription
        val participantsTxt=findViewById<TextView>(R.id.participantsTxt)
        participantsTxt.text= place.nrParticipants.toString()
        Glide.with(this).load(place.placeImage).into(placeDetailsImage)
        Log.v("incercare", place.placeName)
        locationTextView.setTextColor(Color.parseColor("#FFFFFF"))
        btnBookPlace.setOnClickListener {
            val intent = Intent(this@BookPlaceActivity, PaymentActivity::class.java)
            intent.putExtra("placeName", place.placeName.toString())
            intent.putExtra("place", place)
            startActivity(intent)
        }

    }
}
package com.uid.project.sportify

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolylineOptions
import com.uid.project.sportify.adapters.DeletableSportsListAdapter
import com.uid.project.sportify.adapters.DeletableTagsListAdapter
import com.uid.project.sportify.models.Registry
import java.text.SimpleDateFormat
import java.util.*


class CustomizeProfileActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var sportsListAdapter: DeletableSportsListAdapter
    private lateinit var tagsListAdapter: DeletableTagsListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_customize_profile)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.customizeProfileMapView) as SupportMapFragment
        mapFragment.getMapAsync(this)

        val user = Registry.user1Manager

        val profileImage = findViewById<ImageView>(R.id.profilePictureImageView)
        profileImage.setImageResource(user.profilePictureId)

        val name = findViewById<TextView>(R.id.profileNameTextView)
        name.text = user.name

        val email = findViewById<TextView>(R.id.profileEmailTextView)
        email.text = user.email

        val password = findViewById<TextView>(R.id.profilePasswordTextView)
        password.text = user.password

        val location = findViewById<TextView>(R.id.customizeProfileLocationValue)
        location.text = user.location

        val birthdate = findViewById<TextView>(R.id.profileBirthdateTextView)
        val formatter = SimpleDateFormat("dd.MM.yyyy")
        val date: String = formatter.format(user.birthdate)
        birthdate.text = date

        val layoutManager1 = LinearLayoutManager(
            this@CustomizeProfileActivity,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        val layoutManager2 = LinearLayoutManager(
            this@CustomizeProfileActivity,
            LinearLayoutManager.HORIZONTAL,
            false
        )

        val sportsRecyclerView = findViewById<RecyclerView>(R.id.customizeSportsRecyclerView)
        sportsRecyclerView.layoutManager = layoutManager1

        sportsListAdapter = DeletableSportsListAdapter(user.sports)
        sportsRecyclerView.adapter = sportsListAdapter

        val tagsRecyclerView = findViewById<RecyclerView>(R.id.customizeTagsRecyclerView)
        tagsRecyclerView.layoutManager = layoutManager2

        tagsListAdapter = DeletableTagsListAdapter(user.tags)
        tagsRecyclerView.adapter = tagsListAdapter
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        if (googleMap != null) {
            mMap = googleMap
        }

        val grigorescu = LatLng(46.769211, 23.554226)
        mMap.addMarker(MarkerOptions().position(grigorescu).title("Marker in Grigorescu"))
        mMap.setMinZoomPreference(12f)
        mMap.addPolyline(
            PolylineOptions()
                .clickable(false)
                .add(
                    LatLng(46.7613847, 23.5447311),
                    LatLng(46.7615023, 23.5464907),
                    LatLng(46.7655298, 23.5513830),
                    LatLng(46.7657943, 23.5546875),
                    LatLng(46.7680284, 23.5593653),
                    LatLng(46.7676169, 23.5663176),
                    LatLng(46.7697627, 23.5712528),
                    LatLng(46.7722317, 23.5817671),
                    LatLng(46.7740246, 23.5613823),
                    LatLng(46.7709972, 23.5504818),
                    LatLng(46.7650006, 23.5418558),
                    LatLng(46.7650300, 23.5448170),
                    LatLng(46.7613847, 23.5447311)
                ).color(Color.RED).width(5F)
        )

        mMap.moveCamera(CameraUpdateFactory.newLatLng(grigorescu))
    }

    override fun onBackPressed() {
        startActivity(Intent(this, ProfilePageActivity::class.java))
    }
}
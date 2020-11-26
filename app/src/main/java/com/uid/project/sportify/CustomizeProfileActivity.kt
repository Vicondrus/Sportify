package com.uid.project.sportify

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View.OnFocusChangeListener
import android.widget.Button
import android.widget.ImageView
import android.widget.SearchView
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
import com.uid.project.sportify.adapters.TagsSearchListAdapter
import com.uid.project.sportify.models.Registry
import com.uid.project.sportify.models.User
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*


class CustomizeProfileActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var sportsListAdapter: DeletableSportsListAdapter
    private lateinit var tagsListAdapter: DeletableTagsListAdapter
    private lateinit var tagsSearchListAdapter: TagsSearchListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_customize_profile)

        val formatter = SimpleDateFormat("dd.MM.yyyy")

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.customizeProfileMapView) as SupportMapFragment
        mapFragment.getMapAsync(this)

        val user = User(Registry.user1Manager)

        val profileImage = findViewById<ImageView>(R.id.profilePictureImageView)
        profileImage.setImageResource(user.profilePictureId)

        val name = findViewById<TextView>(R.id.profileNameTextView)
        name.text = user.name
        name.onFocusChangeListener = OnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                user.name = name.text.toString()
            }
        }


        val email = findViewById<TextView>(R.id.profileEmailTextView)
        email.text = user.email
        email.onFocusChangeListener = OnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                user.email = email.text.toString()
            }
        }

        val password = findViewById<TextView>(R.id.profilePasswordTextView)
        password.text = user.password
        password.onFocusChangeListener = OnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                user.password = password.text.toString()
            }
        }

        val location = findViewById<TextView>(R.id.customizeProfileLocationValue)
        location.text = user.location
        location.onFocusChangeListener = OnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                user.location = location.text.toString()
            }
        }

        val birthdate = findViewById<TextView>(R.id.profileBirthdateTextView)
        val date: String = formatter.format(user.birthdate)
        birthdate.text = date
        birthdate.onFocusChangeListener = OnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy", Locale.ENGLISH)
                val date = LocalDate.parse(birthdate.text.toString(), formatter)
                user.birthdate = Date.from(date.atStartOfDay()
                    .atZone(ZoneId.systemDefault())
                    .toInstant());
            }
        }

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
        val layoutManager3 = LinearLayoutManager(
            this@CustomizeProfileActivity,
            LinearLayoutManager.VERTICAL,
            false
        )

        val sportsRecyclerView = findViewById<RecyclerView>(R.id.customizeSportsRecyclerView)
        sportsRecyclerView.layoutManager = layoutManager1

        sportsListAdapter = DeletableSportsListAdapter(user.sports, this@CustomizeProfileActivity)
        sportsRecyclerView.adapter = sportsListAdapter

        val tagsRecyclerView = findViewById<RecyclerView>(R.id.customizeTagsRecyclerView)
        tagsRecyclerView.layoutManager = layoutManager2

        tagsListAdapter = DeletableTagsListAdapter(user.tags, this@CustomizeProfileActivity)
        tagsRecyclerView.adapter = tagsListAdapter

        val customizeProfileTagsSearchView =
            findViewById<SearchView>(R.id.customizeProfileTagsSearchView)
        val searchTagsRecyclerView = findViewById<RecyclerView>(R.id.searchTagsRecyclerView)
        searchTagsRecyclerView.layoutManager = layoutManager3

        tagsSearchListAdapter = TagsSearchListAdapter(
            Registry.setOfTags.toMutableList(),
            tagsListAdapter,
            customizeProfileTagsSearchView,
            this@CustomizeProfileActivity
        )
        searchTagsRecyclerView.adapter = tagsSearchListAdapter

        customizeProfileTagsSearchView.setOnQueryTextListener(object :
            SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                tagsSearchListAdapter.filter.filter(newText)
                return false
            }

        })

        val button = findViewById<Button>(R.id.customizeProfileSaveButton)
        button.setOnClickListener {
            user.name = name.text.toString()
            user.email = email.text.toString()
            user.password = password.text.toString()
            user.location = location.text.toString()
            val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy", Locale.ENGLISH)
            val date = LocalDate.parse(birthdate.text.toString(), formatter)
            user.birthdate = Date.from(date.atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant());
            Registry.user1Manager = user
            val intent = Intent(this, ProfilePageActivity::class.java)
            startActivity(intent)
        }
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
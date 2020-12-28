package com.uid.project.sportify

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View.OnFocusChangeListener
import android.widget.*
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.huawei.hms.maps.HuaweiMap
import com.huawei.hms.maps.SupportMapFragment
import com.huawei.hms.maps.model.PolygonOptions
import com.uid.project.sportify.adapters.DeletableSportsListAdapter
import com.uid.project.sportify.adapters.DeletableTagsListAdapter
import com.uid.project.sportify.adapters.TagsSearchListAdapter
import com.uid.project.sportify.models.Neighborhood

import com.uid.project.sportify.models.Registry
import com.uid.project.sportify.models.Sport
import com.uid.project.sportify.models.User
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*


class CustomizeProfileActivity : AppCompatActivity(), com.huawei.hms.maps.OnMapReadyCallback {

    private lateinit var mMap: HuaweiMap
    private lateinit var sportsListAdapter: DeletableSportsListAdapter
    private lateinit var tagsListAdapter: DeletableTagsListAdapter
    private lateinit var tagsSearchListAdapter: TagsSearchListAdapter
    private val sportsSelectionId = 1
    private val pictureSelectionId = 2
    private val mapSelectionId = 3
    private lateinit var user: User
    private lateinit var profileImage: ImageView
    private lateinit var location: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_customize_profile)

        val formatter = SimpleDateFormat("dd.MM.yyyy")

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.customizeProfileMapView) as? SupportMapFragment
        mapFragment?.getMapAsync(this)

        user = Registry.user1Manager

        profileImage = findViewById(R.id.profilePictureImageView)
        if (user.secondaryPictureURI == null) {
            profileImage.setImageResource(user.profilePictureId)
        } else {
            profileImage.setImageURI(user.secondaryPictureURI)
        }

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

        location = findViewById<TextView>(R.id.customizeProfileLocationValue)
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
                user.birthdate = Date.from(
                    date.atStartOfDay()
                        .atZone(ZoneId.systemDefault())
                        .toInstant()
                )
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
            findViewById<SearchView>(R.id.enterTagsTextView)
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

        val button = findViewById<Button>(R.id.doneTagButton)
        button.setOnClickListener {
            user.name = name.text.toString()
            user.email = email.text.toString()
            user.password = password.text.toString()
            user.location = location.text.toString()
            val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy", Locale.ENGLISH)
            val date = LocalDate.parse(birthdate.text.toString(), formatter)
            user.birthdate = Date.from(
                date.atStartOfDay()
                    .atZone(ZoneId.systemDefault())
                    .toInstant()
            )
            Registry.user1Manager = user
            finish()
        }
        val addSport = findViewById<ImageButton>(R.id.addTagButton)
        addSport.setOnClickListener {
            user.name = name.text.toString()
            user.email = email.text.toString()
            user.password = password.text.toString()
            user.location = location.text.toString()
            val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy", Locale.ENGLISH)
            val date = LocalDate.parse(birthdate.text.toString(), formatter)
            user.birthdate = Date.from(
                date.atStartOfDay()
                    .atZone(ZoneId.systemDefault())
                    .toInstant()
            )

            val intent = Intent(this, SportsSelectionActivity::class.java)
            startActivityForResult(intent, sportsSelectionId)
        }

        val changeProfilePictureButton =
            findViewById<ImageButton>(R.id.changeProfilePictureImageButton)
        changeProfilePictureButton.setOnClickListener {
            val pickPhoto = Intent(
                Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            )
            startActivityForResult(pickPhoto, pictureSelectionId)
        }

    }

    fun goToMap(view: View){
        val intent = Intent(this, MapViewDemoActivity::class.java)
        intent.putExtra("currentLocation", user.location)
        startActivityForResult(intent, mapSelectionId)
    }

    override fun onMapReady(map: HuaweiMap) {

        mMap = map
        mMap.clear()
//        if (user.location == "Grigorescu") {
//            mMap.addPolygon(
//                PolygonOptions()
//                    .clickable(false)
//                    .strokeColor(Color.parseColor("#8A56AC"))
//                    .add(
//                        LatLng(46.7613847, 23.5447311),
//                        LatLng(46.7615023, 23.5464907),
//                        LatLng(46.7655298, 23.5513830),
//                        LatLng(46.7657943, 23.5546875),
//                        LatLng(46.7680284, 23.5593653),
//                        LatLng(46.7676169, 23.5663176),
//                        LatLng(46.7697627, 23.5712528),
//                        LatLng(46.7722317, 23.5817671),
//                        LatLng(46.7740246, 23.5613823),
//                        LatLng(46.7709972, 23.5504818),
//                        LatLng(46.7650006, 23.5418558),
//                        LatLng(46.7650300, 23.5448170),
//                        LatLng(46.7613847, 23.5447311)
//                    )
//            ).tag = "Grigorescu"
//        }
//        else if (user.location == "Centru") {
//            mMap.addPolygon(
//                PolygonOptions()
//                    .clickable(false)
//                    .strokeColor(Color.parseColor("#8A56AC"))
//                    .add(
//                        LatLng(46.7740834, 23.5876465),
//                        LatLng(46.7697627, 23.5745144),
//                        LatLng(46.7677932, 23.5736561),
//                        LatLng( 46.7670584, 23.5743856),
//                        LatLng(46.7675287, 23.5774755),
//                        LatLng(46.7659707, 23.5786772),
//                        LatLng(46.7637659, 23.5842562),
//                        LatLng(46.7660295, 23.5859728),
//                        LatLng(46.7663529, 23.5927963),
//                        LatLng(46.7672347, 23.5968304),
//                        LatLng(46.7674111, 23.6000061),
//                        LatLng(46.7715851, 23.6085463),
//                        LatLng(46.7757293, 23.6042118),
//                        LatLng(46.7760820, 23.5942984),
//                        LatLng(46.7740246, 23.5875607),
//                        LatLng(46.7740834, 23.5876465)
//                    )
//            ).tag = "Centru"

        val neighborhood = Registry.listOfNeighborhoods.find { neighborhood: Neighborhood -> user.location == neighborhood.name }
        mMap.addPolygon(PolygonOptions()
                .clickable(false)
                .strokeColor(ContextCompat.getColor(this@CustomizeProfileActivity, R.color.purple_sportify))
                .addAll(neighborhood!!.coords))
                .tag = neighborhood.name
        }


    override fun onBackPressed() {
        finish()
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == sportsSelectionId) {
            if (resultCode == Activity.RESULT_OK) {
                val sport = data!!.extras!!.getSerializable("selectedSport") as Sport
                sportsListAdapter.dataSet.removeIf { x -> x.name == sport.name }
                sportsListAdapter.dataSet.add(sport)
                sportsListAdapter.notifyDataSetChanged()
            }
        }
        if (requestCode == pictureSelectionId) {
            if (resultCode == Activity.RESULT_OK) {
                val selectedImage: Uri = data!!.data as Uri
                user.secondaryPictureURI = selectedImage
                profileImage.setImageURI(user.secondaryPictureURI)
            }
        }
        if (requestCode == mapSelectionId) {
            if (resultCode == Activity.RESULT_OK) {
                val result = data?.getStringExtra("chosenLocation")
                if (result != null) {
                    user.location = result
                    onMapReady(mMap)
                    location.text = result
                }
            }
        }
    }
}
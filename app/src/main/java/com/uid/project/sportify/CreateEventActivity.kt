package com.uid.project.sportify

import android.app.Activity
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.huawei.hms.maps.HuaweiMap
import com.huawei.hms.maps.SupportMapFragment
import com.huawei.hms.maps.model.PolygonOptions
import com.uid.project.sportify.adapters.DeletableRequirementsListAdapter
import com.uid.project.sportify.adapters.DeletableSportsListAdapter
import com.uid.project.sportify.adapters.DeletableTagsListAdapter
import com.uid.project.sportify.adapters.TagsSearchListAdapter
import com.uid.project.sportify.models.Event
import com.uid.project.sportify.models.Neighborhood
import com.uid.project.sportify.models.Registry
import com.uid.project.sportify.models.Sport
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.*

class CreateEventActivity : AppCompatActivity(), com.huawei.hms.maps.OnMapReadyCallback {

    private lateinit var mMap: HuaweiMap
    private lateinit var sportsListAdapter: DeletableSportsListAdapter
    private lateinit var tagsListAdapter: DeletableTagsListAdapter
    private lateinit var tagsSearchListAdapter: TagsSearchListAdapter
    private lateinit var requirementsListAdapter: DeletableRequirementsListAdapter
    private val sportsSelectionId = 1
    private val pictureSelectionId = 2
    private val mapSelectionId = 3
    private lateinit var event: Event
    private lateinit var eventImage: ImageView
    private lateinit var location: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_event)

        supportActionBar?.hide()

        event = Registry.event1Manager

        /**
         * Date
         */
        val eventDateTextView = findViewById<EditText>(R.id.eventDateDate)
        eventDateTextView.inputType = InputType.TYPE_NULL
        eventDateTextView.setOnClickListener {
            val calendar: Calendar = Calendar.getInstance()
            val day = calendar.get(Calendar.DAY_OF_MONTH)
            val month = calendar.get(Calendar.MONTH)
            val year = calendar.get(Calendar.YEAR)
            val datePicker = DatePickerDialog(
                this@CreateEventActivity,
                DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                    eventDateTextView.setText("" + dayOfMonth + "/" + (monthOfYear + 1) + "/" + year)
                },
                year,
                month,
                day
            )
            datePicker.show()
        }

        /**
         * Time
         */
        val eventTimeStartTextView = findViewById<EditText>(R.id.eventTimeStart)
        eventTimeStartTextView.inputType = InputType.TYPE_NULL
        eventTimeStartTextView.setOnClickListener {
            val calendar: Calendar = Calendar.getInstance()
            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            val minute = calendar.get(Calendar.MINUTE)
            val timePicker = TimePickerDialog(
                this@CreateEventActivity,
                TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                    var hourOfDayString: String = "" + hourOfDay
                    if (hourOfDay < 10) hourOfDayString = "0" + hourOfDay
                    var minuteString: String = "" + minute
                    if (minute == 0) minuteString = "" + minute + "0"
                    eventTimeStartTextView.setText(hourOfDayString + ":" + minuteString)
                },
                hour,
                minute,
                true
            )
            timePicker.show()
        }

        val eventTimeEndTextView = findViewById<EditText>(R.id.eventTimeEnd)
        eventTimeEndTextView.inputType = InputType.TYPE_NULL
        eventTimeEndTextView.setOnClickListener {
            val calendar: Calendar = Calendar.getInstance()
            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            val minute = calendar.get(Calendar.MINUTE)
            val timePicker = TimePickerDialog(
                this@CreateEventActivity,
                TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                    var hourOfDayString: String = "" + hourOfDay
                    if (hourOfDay < 10) hourOfDayString = "0" + hourOfDay
                    var minuteString: String = "" + minute
                    if (minute == 0) minuteString = "" + minute + "0"
                    eventTimeEndTextView.setText(hourOfDayString + ":" + minuteString)
                },
                hour,
                minute,
                true
            )
            timePicker.show()
        }

        /**
         * Map
         */
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.createEventMapView) as? SupportMapFragment
        mapFragment?.getMapAsync(this)

        /**
         * Sports, Tags, Requirements
         */
        val layoutManagerSports = LinearLayoutManager(
            this@CreateEventActivity,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        val layoutManagerTags = LinearLayoutManager(
            this@CreateEventActivity,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        val layoutManagerTagsSearch = LinearLayoutManager(
            this@CreateEventActivity,
            LinearLayoutManager.VERTICAL,
            false
        )
        val layoutManagerRequirements = LinearLayoutManager(
            this@CreateEventActivity,
            LinearLayoutManager.HORIZONTAL,
            false
        )

        val sportsRecyclerView = findViewById<RecyclerView>(R.id.createEventSportsRecyclerView)
        sportsRecyclerView.layoutManager = layoutManagerSports
        sportsListAdapter = DeletableSportsListAdapter(event.sports, this@CreateEventActivity)
        sportsRecyclerView.adapter = sportsListAdapter

        val tagsRecyclerView = findViewById<RecyclerView>(R.id.createEventTagsRecyclerView)
        tagsRecyclerView.layoutManager = layoutManagerTags
        tagsListAdapter = DeletableTagsListAdapter(event.tags, this@CreateEventActivity)
        tagsRecyclerView.adapter = tagsListAdapter

        val requirementsRecyclerView =
            findViewById<RecyclerView>(R.id.createEventRequirementsRecyclerView)
        requirementsRecyclerView.layoutManager = layoutManagerRequirements
        requirementsListAdapter =
            DeletableRequirementsListAdapter(event.requirements, this@CreateEventActivity)
        requirementsRecyclerView.adapter = requirementsListAdapter

        val tagsSearchView = findViewById<SearchView>(R.id.createEventTagsSearchView)
        val searchTagsRecyclerView =
            findViewById<RecyclerView>(R.id.createEventSearchTagsRecyclerView)
        searchTagsRecyclerView.layoutManager = layoutManagerTagsSearch
        tagsSearchListAdapter = TagsSearchListAdapter(
            Registry.setOfTags.toMutableList(),
            tagsListAdapter,
            tagsSearchView,
            this@CreateEventActivity
        )
        searchTagsRecyclerView.adapter = tagsSearchListAdapter

        tagsSearchView.setOnQueryTextListener(object :
            SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                tagsSearchListAdapter.filter.filter(newText)
                return false
            }

        })

        val addSportButton = findViewById<ImageButton>(R.id.createEventAddSportBtn)
        addSportButton.setOnClickListener {
            //
            val intent = Intent(this, SportsSelectionActivity::class.java)
            startActivityForResult(intent, sportsSelectionId)
        }

        val addRequirementButton = findViewById<ImageButton>(R.id.createEventAddRequirementButton)
        addRequirementButton.setOnClickListener {
            val requirementTextView = findViewById<TextView>(R.id.createEventRequirementTextView)
            if (requirementTextView.text.toString() != "") {
                requirementsListAdapter.addToDataSet(requirementTextView.text.toString())
                requirementsListAdapter.notifyDataSetChanged()
                requirementTextView.text = ""
            }
        }

        /**
         * Image
         */
        eventImage = findViewById(R.id.createEventImage)
        if (event.imageUri == null) {
            eventImage.setImageResource(event.image)
        } else {
            eventImage.setImageURI(Uri.parse(event.imageUri))
        }
        val changeEventPictureButton = findViewById<ImageButton>(R.id.createEventImage)
        changeEventPictureButton.setOnClickListener {
            val pickPhoto = Intent(
                Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            )
            startActivityForResult(pickPhoto, pictureSelectionId)
        }


        val button = findViewById<Button>(R.id.createEventButton)
        button.setOnClickListener {

            event.name = findViewById<EditText>(R.id.eventNameTextView).text.toString()
            event.host = Registry.user1Manager.name
            event.description =
                findViewById<EditText>(R.id.eventDescriptionTextView).text.toString()
            event.date = LocalDate.parse(
                eventDateTextView.text.toString(),
                DateTimeFormatter.ofPattern("dd/MM/yyyy")
            )
            event.timeStart = LocalTime.parse(
                eventTimeStartTextView.text.toString(),
                DateTimeFormatter.ofPattern("HH:mm")
            )
            event.timeEnd = LocalTime.parse(
                eventTimeEndTextView.text.toString(),
                DateTimeFormatter.ofPattern("HH:mm")
            )
            val eventNbOfPeopleTextView = findViewById<EditText>(R.id.eventNbOfPeopleTextView)
            eventNbOfPeopleTextView.inputType = InputType.TYPE_CLASS_NUMBER
            event.nbOfPeople = eventNbOfPeopleTextView.text.toString().toInt()
            val eventAttendanceFeeTextView = findViewById<EditText>(R.id.eventAttendanceFeeTextView)
            eventAttendanceFeeTextView.inputType = InputType.TYPE_CLASS_NUMBER
            event.attendanceFee = eventAttendanceFeeTextView.text.toString().toInt()
            val intent = Intent(this, EventCreatedActivity::class.java)
            intent.putExtra("event", event)
            startActivity(intent)
        }
    }

    override fun onMapReady(map: HuaweiMap) {

        mMap = map
        mMap.clear()
        val neighborhood =
            Registry.listOfNeighborhoods.find { neighborhood: Neighborhood -> event.location == neighborhood.name }
        mMap.addPolygon(
            PolygonOptions()
                .clickable(false)
                .strokeColor(
                    ContextCompat.getColor(
                        this@CreateEventActivity,
                        R.color.purple_sportify
                    )
                )
                .addAll(neighborhood!!.coords)
        )
            .tag = neighborhood.name
    }


    fun goToMap(view: View) {
        val intent = Intent(this, MapViewDemoActivity::class.java)
        intent.putExtra("currentLocation", event.location)
        startActivityForResult(intent, mapSelectionId)
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
                event.imageUri = selectedImage.toString()
                eventImage.setImageURI(Uri.parse(event.imageUri))
            }
        }

        if (requestCode == mapSelectionId) {
            if (resultCode == Activity.RESULT_OK) {
                val result = data?.getStringExtra("chosenLocation")
                if (result != null) {
                    event.location = result
                    onMapReady(mMap)
                    location.text = result
                }
            }
        }
    }
}
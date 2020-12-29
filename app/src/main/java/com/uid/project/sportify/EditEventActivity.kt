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
import androidx.core.widget.doOnTextChanged
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.huawei.hms.maps.HuaweiMap
import com.huawei.hms.maps.SupportMapFragment
import com.huawei.hms.maps.model.BitmapDescriptorFactory
import com.huawei.hms.maps.model.LatLng
import com.huawei.hms.maps.model.MarkerOptions
import com.huawei.hms.maps.model.PolygonOptions
import com.uid.project.sportify.adapters.DeletableRequirementsListAdapter
import com.uid.project.sportify.adapters.DeletableSportsListAdapter
import com.uid.project.sportify.adapters.DeletableTagsListAdapter
import com.uid.project.sportify.adapters.TagsSearchListAdapter
import com.uid.project.sportify.models.*
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.*

class EditEventActivity : AppCompatActivity(), com.huawei.hms.maps.OnMapReadyCallback {

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
    private lateinit var location: Location
    private lateinit var eventLocationLabel: TextView
    private lateinit var eventNeighborhoodLabel: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_event)

        supportActionBar?.hide()

        event = Registry.event1Manager

        val editEventButton = findViewById<Button>(R.id.confirmEditEventButton)
        editEventButton.isEnabled = true

        // Error labels
        val dateError = findViewById<TextView>(R.id.editEventDateError)
        dateError.visibility = View.GONE
        val timeError = findViewById<TextView>(R.id.editEventTimeError)
        timeError.visibility = View.GONE
        val tagError = findViewById<TextView>(R.id.editEventTagError)
        tagError.visibility = View.GONE
        val sportError = findViewById<TextView>(R.id.editEventSportError)
        sportError.visibility = View.GONE
        val requirementError = findViewById<TextView>(R.id.editEventRequirementError)
        requirementError.visibility = View.GONE

        val eventName = findViewById<TextView>(R.id.editEventNameTextView)
        val eventDescription = findViewById<TextView>(R.id.editEventDescriptionTextView)
        val eventNbOfPeople = findViewById<TextView>(R.id.editEventNbOfPeopleTextView)
        eventNbOfPeople.inputType = InputType.TYPE_CLASS_NUMBER
        val eventAttendanceFee = findViewById<TextView>(R.id.editEventAttendanceFeeTextView)
        eventAttendanceFee.inputType = InputType.TYPE_CLASS_NUMBER
        val eventDateTextView = findViewById<TextView>(R.id.editEventDateDate)
        eventDateTextView.inputType = InputType.TYPE_NULL
        val eventTimeStartTextView = findViewById<TextView>(R.id.editEventTimeStart)
        eventTimeStartTextView.inputType = InputType.TYPE_NULL
        val eventTimeEndTextView = findViewById<TextView>(R.id.editEventTimeEnd)
        eventTimeEndTextView.inputType = InputType.TYPE_NULL
        eventLocationLabel = findViewById<TextView>(R.id.editEventLocationLabel)
        eventNeighborhoodLabel = findViewById<TextView>(R.id.editEventNeighborhoodLabel)

        // Set the fields
        eventName.text = event.name
        eventDescription.text = event.description
        eventDateTextView.text = event.date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
        eventTimeStartTextView.text = event.timeStart.format(DateTimeFormatter.ofPattern("HH:mm"))
        eventTimeEndTextView.text = event.timeEnd.format(DateTimeFormatter.ofPattern("HH:mm"))
        eventNbOfPeople.text = event.nbOfPeople.toString()
        eventAttendanceFee.text = event.attendanceFee.toString()
        eventLocationLabel.text = event.location.location
        eventNeighborhoodLabel.text = event.location.neighborhood
        location = event.location

        /**
         * Date
         */
        var isDateValid = true
        eventDateTextView.setOnClickListener {
            val calendar: Calendar = Calendar.getInstance()
            val day = calendar.get(Calendar.DAY_OF_MONTH)
            val month = calendar.get(Calendar.MONTH)
            val year = calendar.get(Calendar.YEAR)
            val datePicker = DatePickerDialog(
                    this@EditEventActivity,
                    DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                        var dayOfMonthString = dayOfMonth.toString()
                        var monthOfYearString = (monthOfYear + 1).toString()
                        if (dayOfMonth < 10) {
                            dayOfMonthString = "0" + dayOfMonthString
                        }
                        if (monthOfYear < 9) {
                            monthOfYearString = "0" + monthOfYearString
                        }
                        eventDateTextView.text = "" + dayOfMonthString + "/" + (monthOfYearString) + "/" + year
                    },
                    year,
                    month,
                    day
            )
            datePicker.show()
        }
        eventDateTextView.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                if (LocalDate.parse(eventDateTextView.text, DateTimeFormatter.ofPattern("dd/MM/yyyy")).isBefore(LocalDate.now())) {
                    dateError.visibility = View.VISIBLE
                    isDateValid = false
                } else {
                    dateError.visibility = View.GONE
                    isDateValid = true
                }
            }
        }

        /**
         * Time
         */
        var isTimeValid = true
        eventTimeStartTextView.setOnClickListener {
            val calendar: Calendar = Calendar.getInstance()
            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            val minute = calendar.get(Calendar.MINUTE)
            val timePicker = TimePickerDialog(
                    this@EditEventActivity,
                    TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                        var hourOfDayString: String = "" + hourOfDay
                        var minuteString: String = "" + minute
                        if (hourOfDay < 10) hourOfDayString = "0" + hourOfDay
                        if (hourOfDay == 0) hourOfDayString = "" + hourOfDay + "0"
                        if (minute < 10) minuteString = "0" + minute
                        if (minute == 0) minuteString = "" + minute + "0"
                        eventTimeStartTextView.text = hourOfDayString + ":" + minuteString
                    },
                    hour,
                    minute,
                    true
            )
            timePicker.show()
        }

        eventTimeEndTextView.setOnClickListener {
            val calendar: Calendar = Calendar.getInstance()
            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            val minute = calendar.get(Calendar.MINUTE)
            val timePicker = TimePickerDialog(
                    this@EditEventActivity,
                    TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                        var hourOfDayString: String = "" + hourOfDay
                        var minuteString: String = "" + minute
                        if (hourOfDay < 10) hourOfDayString = "0" + hourOfDay
                        if (hourOfDay == 0) hourOfDayString = "" + hourOfDay + "0"
                        if (minute < 10) minuteString = "0" + minute
                        if (minute == 0) minuteString = "" + minute + "0"
                        eventTimeEndTextView.text = hourOfDayString + ":" + minuteString
                    },
                    hour,
                    minute,
                    true
            )
            timePicker.show()
        }
        eventTimeEndTextView.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus && eventTimeStartTextView.text.toString() != "" && eventTimeEndTextView.text.toString() != "") {
                if (!LocalTime.parse(eventTimeEndTextView.text, DateTimeFormatter.ofPattern("HH:mm"))
                                .isAfter(LocalTime.parse(eventTimeStartTextView.text, DateTimeFormatter.ofPattern("HH:mm")))) {
                    timeError.visibility = View.VISIBLE
                    isTimeValid = false
                } else {
                    timeError.visibility = View.GONE
                    isTimeValid = true
                }
            }
        }

        /**
         * Map
         */
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.editEventMapView) as? SupportMapFragment
        mapFragment?.getMapAsync(this)

        /**
         * Sports, Tags, Requirements
         */
        val layoutManagerSports = LinearLayoutManager(
                this@EditEventActivity,
                LinearLayoutManager.HORIZONTAL,
                false
        )
        val layoutManagerTags = LinearLayoutManager(
                this@EditEventActivity,
                LinearLayoutManager.HORIZONTAL,
                false
        )
        val layoutManagerTagsSearch = LinearLayoutManager(
                this@EditEventActivity,
                LinearLayoutManager.VERTICAL,
                false
        )
        val layoutManagerRequirements = LinearLayoutManager(
                this@EditEventActivity,
                LinearLayoutManager.HORIZONTAL,
                false
        )

        val sportsRecyclerView = findViewById<RecyclerView>(R.id.editEventSportsRecyclerView)
        sportsRecyclerView.layoutManager = layoutManagerSports
        sportsListAdapter = DeletableSportsListAdapter(event.sports, this@EditEventActivity)
        sportsRecyclerView.adapter = sportsListAdapter

        val tagsRecyclerView = findViewById<RecyclerView>(R.id.editEventTagsRecyclerView)
        tagsRecyclerView.layoutManager = layoutManagerTags
        tagsListAdapter = DeletableTagsListAdapter(event.tags, this@EditEventActivity)
        tagsRecyclerView.adapter = tagsListAdapter

        val requirementsRecyclerView =
                findViewById<RecyclerView>(R.id.editEventRequirementsRecyclerView)
        requirementsRecyclerView.layoutManager = layoutManagerRequirements
        requirementsListAdapter =
                DeletableRequirementsListAdapter(event.requirements, this@EditEventActivity)
        requirementsRecyclerView.adapter = requirementsListAdapter

        val tagsSearchView = findViewById<SearchView>(R.id.editEventTagsSearchView)
        val searchTagsRecyclerView =
                findViewById<RecyclerView>(R.id.editEventSearchTagsRecyclerView)
        searchTagsRecyclerView.layoutManager = layoutManagerTagsSearch
        tagsSearchListAdapter = TagsSearchListAdapter(
                Registry.setOfTags.toMutableList(),
                tagsListAdapter,
                tagsSearchView,
                this@EditEventActivity
        )
        searchTagsRecyclerView.adapter = tagsSearchListAdapter

        tagsSearchView.setOnQueryTextListener(object :
                SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                tagError.visibility = View.GONE
                tagsSearchListAdapter.filter.filter(newText)
                return false
            }

        })

        val addSportButton = findViewById<ImageButton>(R.id.editEventAddSportBtn)
        addSportButton.setOnClickListener {
            sportError.visibility = View.GONE
            val intent = Intent(this, SportsSelectionActivity::class.java)
            startActivityForResult(intent, sportsSelectionId)
        }

        val addRequirementButton = findViewById<ImageButton>(R.id.editEventAddRequirementButton)
        addRequirementButton.setOnClickListener {
            val requirementTextView = findViewById<TextView>(R.id.editEventRequirementTextView)
            if (requirementTextView.text.toString() != "") {
                requirementError.visibility = View.GONE
                requirementsListAdapter.addToDataSet(requirementTextView.text.toString())
                requirementsListAdapter.notifyDataSetChanged()
                requirementTextView.text = ""
            }
        }


        /**
         * Image
         */
        eventImage = findViewById(R.id.editEventImage)
        if (event.imageUri == null) {
            eventImage.setImageResource(event.image)
        } else {
            eventImage.setImageURI(Uri.parse(event.imageUri))
        }
        val changeEventPictureButton = findViewById<Button>(R.id.editEventAddImgBtn)
        changeEventPictureButton.setOnClickListener {
            val pickPhoto = Intent(
                    Intent.ACTION_PICK,
                    android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            )
            startActivityForResult(pickPhoto, pictureSelectionId)
        }


        editEventButton.setOnClickListener {
            var areAllListsValid = true
            if (event.sports.isEmpty()) {
                areAllListsValid = false
                sportError.visibility = View.VISIBLE
            } else {
                sportError.visibility = View.GONE
            }

            if (event.requirements.isEmpty()) {
                areAllListsValid = false
                requirementError.visibility = View.VISIBLE
            } else {
                requirementError.visibility = View.GONE
            }

            if (event.tags.isEmpty()) {
                areAllListsValid = false
                tagError.visibility = View.VISIBLE
            } else {
                tagError.visibility = View.GONE
            }
            if (areAllListsValid) {
                event.name = eventName.text.toString()
                event.host = Registry.user1Manager.name
                event.description = eventDescription.text.toString()
                event.date = LocalDate.parse(eventDateTextView.text.toString(), DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                event.timeStart = LocalTime.parse(eventTimeStartTextView.text.toString(), DateTimeFormatter.ofPattern("HH:mm"))
                event.timeEnd = LocalTime.parse(eventTimeEndTextView.text.toString(), DateTimeFormatter.ofPattern("HH:mm"))
                event.nbOfPeople = eventNbOfPeople.text.toString().toInt()
                event.attendanceFee = eventAttendanceFee.text.toString().toInt()
                event.location = location
                val intent = Intent()
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }

        /**
         * Enabling Edit Event button
         */
        eventName.doOnTextChanged { text, _, _, _ ->
            editEventButton.isEnabled =
                    isDateValid && isTimeValid &&
                            eventDescription.text.isNotEmpty() &&
                            eventNbOfPeople.text.isNotEmpty() &&
                            eventAttendanceFee.text.isNotEmpty() &&
                            eventTimeStartTextView.text.isNotEmpty() &&
                            eventTimeEndTextView.text.isNotEmpty() &&
                            eventDateTextView.text.isNotEmpty() &&
                            text!!.isNotEmpty()
        }
        eventDescription.doOnTextChanged { text, _, _, _ ->
            editEventButton.isEnabled =
                    isDateValid && isTimeValid &&
                            eventName.text.isNotEmpty() &&
                            eventNbOfPeople.text.isNotEmpty() &&
                            eventAttendanceFee.text.isNotEmpty() &&
                            eventTimeStartTextView.text.isNotEmpty() &&
                            eventTimeEndTextView.text.isNotEmpty() &&
                            eventDateTextView.text.isNotEmpty() &&
                            text!!.isNotEmpty()
        }
        eventNbOfPeople.doOnTextChanged { text, _, _, _ ->
            editEventButton.isEnabled =
                    isDateValid && isTimeValid &&
                            eventName.text.isNotEmpty() &&
                            eventDescription.text.isNotEmpty() &&
                            eventAttendanceFee.text.isNotEmpty() &&
                            eventTimeStartTextView.text.isNotEmpty() &&
                            eventTimeEndTextView.text.isNotEmpty() &&
                            eventDateTextView.text.isNotEmpty() &&
                            text!!.isNotEmpty()
        }
        eventAttendanceFee.doOnTextChanged { text, _, _, _ ->
            editEventButton.isEnabled =
                    isDateValid && isTimeValid &&
                            eventName.text.isNotEmpty() &&
                            eventDescription.text.isNotEmpty() &&
                            eventNbOfPeople.text.isNotEmpty() &&
                            eventTimeStartTextView.text.isNotEmpty() &&
                            eventTimeEndTextView.text.isNotEmpty() &&
                            eventDateTextView.text.isNotEmpty() &&
                            text!!.isNotEmpty()
        }
        eventTimeStartTextView.doOnTextChanged { text, _, _, _ ->
            editEventButton.isEnabled =
                    isDateValid && isTimeValid &&
                            eventName.text.isNotEmpty() &&
                            eventDescription.text.isNotEmpty() &&
                            eventNbOfPeople.text.isNotEmpty() &&
                            eventAttendanceFee.text.isNotEmpty() &&
                            eventTimeEndTextView.text.isNotEmpty() &&
                            eventDateTextView.text.isNotEmpty() &&
                            text!!.isNotEmpty()
        }
        eventTimeEndTextView.doOnTextChanged { text, _, _, _ ->
            editEventButton.isEnabled =
                    isDateValid && isTimeValid &&
                            eventName.text.isNotEmpty() &&
                            eventDescription.text.isNotEmpty() &&
                            eventNbOfPeople.text.isNotEmpty() &&
                            eventAttendanceFee.text.isNotEmpty() &&
                            eventTimeStartTextView.text.isNotEmpty() &&
                            eventDateTextView.text.isNotEmpty() &&
                            text!!.isNotEmpty()
        }
        eventDateTextView.doOnTextChanged { text, _, _, _ ->
            editEventButton.isEnabled =
                    isDateValid && isTimeValid &&
                            eventName.text.isNotEmpty() &&
                            eventDescription.text.isNotEmpty() &&
                            eventNbOfPeople.text.isNotEmpty() &&
                            eventAttendanceFee.text.isNotEmpty() &&
                            eventTimeStartTextView.text.isNotEmpty() &&
                            eventTimeEndTextView.text.isNotEmpty() &&
                            text!!.isNotEmpty()
        }
    }

    override fun onMapReady(map: HuaweiMap) {
        mMap = map
        mMap.clear()
            mMap.addMarker(
                MarkerOptions()
                .position(LatLng(location.coords.latitude, location.coords.longitude))
                .title(location.location).icon(
                        BitmapDescriptorFactory
                    .defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)))
    }


    fun goToMap(view: View) {
        val intent = Intent(this, MapViewEventActivity::class.java)
        intent.putExtra("currentLocation", location.location)
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
                    location = Registry.listOfLocations.find { location -> location.location == result }!!
                    eventLocationLabel.text = result
                    eventNeighborhoodLabel.text = location.neighborhood
                    onMapReady(mMap)
                }
            }
        }
    }
}
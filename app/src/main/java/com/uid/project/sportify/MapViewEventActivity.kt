package com.uid.project.sportify

import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Color
import android.location.Address
import android.location.Geocoder
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.huawei.hms.maps.HuaweiMap
import com.huawei.hms.maps.MapView
import com.huawei.hms.maps.OnMapReadyCallback
import com.huawei.hms.maps.model.BitmapDescriptorFactory
import com.huawei.hms.maps.model.LatLng
import com.huawei.hms.maps.model.Marker
import com.huawei.hms.maps.model.MarkerOptions
import com.uid.project.sportify.models.Location
import com.uid.project.sportify.models.Registry
import java.util.*


class MapViewEventActivity : AppCompatActivity(), OnMapReadyCallback{
    private var hMap: HuaweiMap? = null

    private var mMapView: MapView? = null

//    private lateinit var placesClient: PlacesClient

    private lateinit var selectedLocation: String

    private lateinit var confirmationButton: Button

//    private var placeFields: List<Place.Field> = listOf(Place.Field.NAME)

    companion object {
        private const val TAG = "MapViewDemoActivity"
        private const val MAPVIEW_BUNDLE_KEY = "MapViewBundleKey"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map_view_event)

        mMapView = findViewById(R.id.mapViewEvent)
        var mapViewBundle: Bundle? = null
        if (savedInstanceState != null) {
            mapViewBundle =
                savedInstanceState.getBundle(MAPVIEW_BUNDLE_KEY)
        }
        mMapView?.apply {
            onCreate(mapViewBundle)
            getMapAsync(this@MapViewEventActivity)
        }

//        if (!Places.isInitialized()) {
//            Places.initialize(this@MapViewEventActivity, "AIzaSyDXDgcX0T2FQfbQ6XlqDHDfik33I3virBg")
//        }
//        placesClient = Places.createClient(this)

        selectedLocation = intent.getStringExtra("currentLocation").toString()


        confirmationButton = findViewById<Button>(R.id.confirmationButtonEvent)
        confirmationButton.isEnabled = false

        confirmationButton.setOnClickListener {
            intent.putExtra("chosenLocation", selectedLocation)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }


    }

    private fun selectMarker(title: String) {
        selectedLocation = title
        confirmationButton.isEnabled = true
        confirmationButton.setBackgroundColor(Color.parseColor("#8A56AC"))
    }

    lateinit var mMarker: Marker

    override fun onMapReady(map: HuaweiMap) {
        Log.d(TAG, "onMapReady: ")
        hMap = map

        Registry.listOfLocations.forEach{ location ->
            if (location.location == selectedLocation){
                hMap!!.addMarker(MarkerOptions()
                        .position(LatLng(location.coords.latitude, location.coords.longitude))
                        .title(location.location).icon(BitmapDescriptorFactory
                                .defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)))
            }else {
                hMap!!.addMarker(MarkerOptions()
                        .position(LatLng(location.coords.latitude, location.coords.longitude))
                        .title(location.location).icon(BitmapDescriptorFactory
                                .defaultMarker(BitmapDescriptorFactory.HUE_ROSE)))
            }
        }

        hMap!!.setOnMarkerClickListener { marker ->
            val aux = marker.title
            Toast.makeText(applicationContext, marker.title.toString(), Toast.LENGTH_SHORT).show()
            selectMarker(aux)
            map.clear()
            Registry.listOfLocations.forEach{ location ->
                if (location.location == aux){
                    hMap!!.addMarker(MarkerOptions()
                            .position(LatLng(location.coords.latitude, location.coords.longitude))
                            .title(location.location).icon(BitmapDescriptorFactory
                                    .defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)))
                }else {
                    hMap!!.addMarker(MarkerOptions()
                            .position(LatLng(location.coords.latitude, location.coords.longitude))
                            .title(location.location).icon(BitmapDescriptorFactory
                                    .defaultMarker(BitmapDescriptorFactory.HUE_ROSE)))
                }
            }
            true
        }

    }


    override fun onStart() {
        super.onStart()
        mMapView?.onStart()
    }

    override fun onStop() {
        super.onStop()
        mMapView?.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        mMapView?.onDestroy()
    }

    override fun onPause() {
        mMapView?.onPause()
        super.onPause()
    }

    override fun onResume() {
        super.onResume()
        mMapView?.onResume()
    }

    private fun hasPermissions(context: Context, vararg permissions: String): Boolean {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            for (permission in permissions) {
                if (ActivityCompat.checkSelfPermission(
                                context,
                                permission
                        ) != PackageManager.PERMISSION_GRANTED
                ) {
                    return false
                }
            }
        }
        return true
    }

//    override fun onMapClick(p0: LatLng?) {
//        if (p0 != null) {
//            val geocoder = Geocoder(this@MapViewEventActivity, Locale.getDefault())
//            val addresses: List<Address> = geocoder.getFromLocation(p0.latitude, p0.longitude, 1)
//            val address = addresses[0].thoroughfare
//            selectedLocation.coords.latitude = p0.latitude
//            selectedLocation.coords.longitude = p0.longitude
//            selectedLocation.location = address
//        }
//    }

    fun checkPermissions() {
        //Checks if permission is NOT granted...
        if (ContextCompat.checkSelfPermission(this@MapViewEventActivity, ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                    this@MapViewEventActivity,
                    arrayOf(ACCESS_FINE_LOCATION),
                    0
            )
        }
    }

}


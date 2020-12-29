package com.uid.project.sportify


import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Color
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
import com.huawei.hms.maps.model.Marker
import com.huawei.hms.maps.model.PolygonOptions
import com.uid.project.sportify.models.Neighborhood
import com.uid.project.sportify.models.Registry

/**
 * map activity entrance class
 */

class MapViewDemoActivity : AppCompatActivity(), OnMapReadyCallback {

    private var hMap: HuaweiMap? = null

    private var mMapView: MapView? = null

    private var selectedLocation: String = ""

    private lateinit var confirmationButton: Button

    companion object {
        private const val TAG = "MapViewDemoActivity"
        private const val MAPVIEW_BUNDLE_KEY = "MapViewBundleKey"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.map_view_activity)

        mMapView = findViewById(R.id.mapView)
        var mapViewBundle: Bundle? = null
        if (savedInstanceState != null) {
            mapViewBundle =
                    savedInstanceState.getBundle(MAPVIEW_BUNDLE_KEY)
        }
        mMapView?.apply {
            onCreate(mapViewBundle)
            getMapAsync(this@MapViewDemoActivity)
        }

        selectedLocation = intent.getStringExtra("currentLocation").toString()


        confirmationButton = findViewById<Button>(R.id.confirmationButton)
        confirmationButton.isEnabled = false

        confirmationButton.setOnClickListener {
            intent.putExtra("chosenLocation", selectedLocation)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }


    }

    private fun selectLocation(location: String) {
        selectedLocation = location
        confirmationButton.isEnabled = true
        confirmationButton.setBackgroundColor(Color.parseColor("#8A56AC"))
    }

    lateinit var mMarker: Marker
    override fun onMapReady(map: HuaweiMap) {
        Log.d(TAG, "onMapReady: ")
        hMap = map
//        hMap!!.addPolygon(
//            PolygonOptions()
//                .clickable(true)
//                .add(
//                    LatLng(46.7613847, 23.5447311),
//                    LatLng(46.7615023, 23.5464907),
//                    LatLng(46.7655298, 23.5513830),
//                    LatLng(46.7657943, 23.5546875),
//                    LatLng(46.7680284, 23.5593653),
//                    LatLng(46.7676169, 23.5663176),
//                    LatLng(46.7697627, 23.5712528),
//                    LatLng(46.7722317, 23.5817671),
//                    LatLng(46.7740246, 23.5613823),
//                    LatLng(46.7709972, 23.5504818),
//                    LatLng(46.7650006, 23.5418558),
//                    LatLng(46.7650300, 23.5448170),
//                    LatLng(46.7613847, 23.5447311)
//                ).strokeColor(Color.parseColor("#8A56AC"))
//        ).tag = "Grigorescu"
//
//        hMap!!.addPolygon(
//            PolygonOptions()
//                .clickable(true)
//                .add(
//                    LatLng(46.7740834, 23.5876465),
//                    LatLng(46.7697627, 23.5745144),
//                    LatLng(46.7677932, 23.5736561),
//                    LatLng(46.7670584, 23.5743856),
//                    LatLng(46.7675287, 23.5774755),
//                    LatLng(46.7659707, 23.5786772),
//                    LatLng(46.7637659, 23.5842562),
//                    LatLng(46.7660295, 23.5859728),
//                    LatLng(46.7663529, 23.5927963),
//                    LatLng(46.7672347, 23.5968304),
//                    LatLng(46.7674111, 23.6000061),
//                    LatLng(46.7715851, 23.6085463),
//                    LatLng(46.7757293, 23.6042118),
//                    LatLng(46.7760820, 23.5942984),
//                    LatLng(46.7740246, 23.5875607),
//                    LatLng(46.7740834, 23.5876465)
//                ).strokeColor(Color.parseColor("#8A56AC"))
//        ).tag = "Centru"

        Registry.listOfNeighborhoods.forEach { neighborhood: Neighborhood ->
            var color = ContextCompat.getColor(this@MapViewDemoActivity, R.color.grey_sportify)
            if (neighborhood.name == selectedLocation) {
                color = ContextCompat.getColor(this@MapViewDemoActivity, R.color.purple_sportify)
            }
            hMap!!.addPolygon(
                    PolygonOptions()
                            .clickable(true)
                            .addAll(neighborhood.coords)
                            .strokeColor(color)
            ).tag = neighborhood.name
        }

        hMap!!.setOnPolygonClickListener { polygon ->
            Toast.makeText(applicationContext, polygon.tag.toString(), Toast.LENGTH_SHORT).show()
            selectLocation(polygon.tag.toString())
            hMap!!.clear()
            Registry.listOfNeighborhoods.forEach { neighborhood: Neighborhood ->
                var color = ContextCompat.getColor(this@MapViewDemoActivity, R.color.grey_sportify)
                if (neighborhood.name == polygon.tag.toString()) {
                    color = ContextCompat.getColor(this@MapViewDemoActivity, R.color.purple_sportify)
                }
                hMap!!.addPolygon(
                        PolygonOptions()
                                .clickable(true)
                                .addAll(neighborhood.coords)
                                .strokeColor(color)
                ).tag = neighborhood.name
            }
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

}

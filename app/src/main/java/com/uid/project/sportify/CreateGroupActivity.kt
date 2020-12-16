package com.uid.project.sportify

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.huawei.hms.maps.HuaweiMap
import com.huawei.hms.maps.SupportMapFragment
import com.huawei.hms.maps.model.LatLng
import com.huawei.hms.maps.model.PolygonOptions

class CreateGroupActivity : AppCompatActivity(), com.huawei.hms.maps.OnMapReadyCallback {
    private lateinit var mMap: HuaweiMap
    lateinit var location : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_create_group)

        val groupName = findViewById<TextInputEditText>(R.id.name)
        var groupDescription = findViewById<TextInputEditText>(R.id.description)
        location = findViewById<TextView>(R.id.textView5)
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.mapFragment) as? SupportMapFragment
        mapFragment?.getMapAsync(this)


    }
    fun goToMap(view: View){
        val intent = Intent(this, MapViewDemoActivity::class.java)
        startActivityForResult(intent, 1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                val result = data?.getStringExtra("chosenLocation")
                if (result != null) {
                    location.text = result
                }
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }

        mMap.clear()
        if (location.text == "Grigorescu") {
            mMap.addPolygon(
                PolygonOptions()
                    .clickable(false)
                    .strokeColor(Color.parseColor("#8A56AC"))
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
                    )
            ).tag = "Grigorescu"
        }
        else if (location.text == "Centru") {
            mMap.addPolygon(
                PolygonOptions()
                    .clickable(false)
                    .strokeColor(Color.parseColor("#8A56AC"))
                    .add(
                        LatLng(46.7740834, 23.5876465),
                        LatLng(46.7697627, 23.5745144),
                        LatLng(46.7677932, 23.5736561),
                        LatLng(46.7670584, 23.5743856),
                        LatLng(46.7675287, 23.5774755),
                        LatLng(46.7659707, 23.5786772),
                        LatLng(46.7637659, 23.5842562),
                        LatLng(46.7660295, 23.5859728),
                        LatLng(46.7663529, 23.5927963),
                        LatLng(46.7672347, 23.5968304),
                        LatLng(46.7674111, 23.6000061),
                        LatLng(46.7715851, 23.6085463),
                        LatLng(46.7757293, 23.6042118),
                        LatLng(46.7760820, 23.5942984),
                        LatLng(46.7740246, 23.5875607),
                        LatLng(46.7740834, 23.5876465)
                    )
            ).tag = "Centru"
        }
    }

    override fun onMapReady(map: HuaweiMap) {
        mMap = map
    }


    override fun onBackPressed() {
        startActivity(Intent(this, ProfilePageActivity::class.java))
    }
}
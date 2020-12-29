package com.uid.project.sportify

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.huawei.hms.maps.HuaweiMap
import com.huawei.hms.maps.SupportMapFragment
import com.huawei.hms.maps.model.PolygonOptions
import com.uid.project.sportify.models.Level
import com.uid.project.sportify.models.Neighborhood
import com.uid.project.sportify.models.Registry

class SearchEventActivity: AppCompatActivity(),com.huawei.hms.maps.OnMapReadyCallback  {
    private lateinit var location: TextView
    private  var finalLocation: String =""
    var hashMapFinal : HashMap<String, String>
            = HashMap<String, String> ()

    var listTagsFinal : ArrayList<String>
            = ArrayList<String> ()

    private val mapSelectionId = 3

    private lateinit var mMap: HuaweiMap
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_event)
        location = findViewById<TextView>(R.id.textView5)
        location.text = Registry.user1Manager.location
        location.onFocusChangeListener = View.OnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                Registry.user1Manager.location = location.text.toString()
            }
        }

        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.mapFragment) as? SupportMapFragment
        mapFragment?.getMapAsync(this)

        supportActionBar?.hide()
        val sportSelection=findViewById<ImageButton>(R.id.imageButton4)
        val textViewSportSelection=findViewById<TextView>(R.id.textViewSportSelection)
        val btnContinue=findViewById<Button>(R.id.button4)



        sportSelection.setOnClickListener {

            val intent = Intent(this@SearchEventActivity, SportSelectionEvent::class.java)

            startActivityForResult(intent, 1)
        }



        btnContinue.setOnClickListener{
            val eventNameEditText=findViewById<EditText>(R.id.editTextEventName)
            val eventName=eventNameEditText.text.toString()
            val intent = Intent(this@SearchEventActivity, EventResultActivity::class.java)
            intent.putExtra("location",finalLocation)
            intent.putExtra("eventName",eventName)
            startActivity(intent)
        }


        val relatedTagsButton=findViewById<ImageButton>(R.id.relatedTagsButton)
        relatedTagsButton.setOnClickListener {

            val intent = Intent(this@SearchEventActivity, TagsEventSearch::class.java)
            startActivityForResult(intent, 2)
        }
    }
    override fun onBackPressed() {
        finish()
    }
    fun goToMap(view: View){
        val intent = Intent(this, MapViewDemoActivity::class.java)
        intent.putExtra("currentLocation",Registry.user1Manager.location)
        startActivityForResult(intent, 3)
    }
    override fun onMapReady(map: HuaweiMap) {

        mMap = map
        mMap.clear()
        val neighborhood = Registry.listOfNeighborhoods.find { neighborhood: Neighborhood -> Registry.user1Manager.location == neighborhood.name }
        mMap.addPolygon(PolygonOptions()
                .clickable(false)
                .strokeColor(ContextCompat.getColor(this@SearchEventActivity, R.color.purple_sportify))
                .addAll(neighborhood!!.coords))
                .tag = neighborhood.name
    }
   override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode != Activity.RESULT_OK) return

            if(requestCode==1) {

                val hashMap = data?.getSerializableExtra("hashMap") as HashMap<Int, Int>
                for ((k, v) in hashMap) {
                    Log.v("hashmap", "$k = $v")
                    //  Level.values()[level]
                    if (k == 1) {
                        hashMapFinal.put("tennis", Level.values()[v].toString())
                    } else if (k == 2) {

                        hashMapFinal.put("basketball", Level.values()[v].toString())
                    } else if (k == 3) {

                        hashMapFinal.put("swimming", Level.values()[v].toString())
                    }
                    else if (k == 4) {

                        hashMapFinal.put("bike", Level.values()[v].toString())
                    }
                    else if (k == 5) {

                        hashMapFinal.put("baseball", Level.values()[v].toString())
                    }
                    else if (k == 6) {

                        hashMapFinal.put("walking", Level.values()[v].toString())
                    }
                    else if (k == 7) {

                        hashMapFinal.put("football", Level.values()[v].toString())
                    }
                    else if (k == 8) {

                        hashMapFinal.put("yogaplace.jpg", Level.values()[v].toString())
                    }
                    else if (k == 9) {

                        hashMapFinal.put("stretching", Level.values()[v].toString())
                    }
                }


                printHashMap()
            }
            // Other result codes
          else if (requestCode==2) {
                Log.v("in2","hey")
                val tagsTxt=findViewById<TextView>(R.id.textView7)
                val list = data?.getStringArrayListExtra("list")
                if (list != null) {
                    for(a in list){
                        Log.v("listtt",a)
                        listTagsFinal.add(a)

                    } //TODO :implement get list of tags +textview under tags
                    val builder = StringBuilder()
                    for (details in listTagsFinal) {
                        builder.append(details + " ,")
                    }
                    tagsTxt.text=builder.toString()
                }


            }
       else   if (requestCode == 3) {
                if (resultCode == Activity.RESULT_OK) {
                    val result = data?.getStringExtra("chosenLocation")
                    if (result != null) {
                        Registry.user1Manager.location = result
                        onMapReady(mMap)
                        location.text = result.toString()
                        finalLocation=result.toString()
                    }
                }
            }

    }


    fun printHashMap(){

        val textViewSportSelection=findViewById<TextView>(R.id.textViewSportSelection)
        for ((k, v) in hashMapFinal) {

            Log.v("hashmapF", "$k = $v")
           // textViewSportSelection.text = hashMapFinal.get("tennis").toString()
        }

        val builder = StringBuilder()
        for (details in hashMapFinal) {
            builder.append(details.key +" "+ details.value.toLowerCase() + ",")
        }
        textViewSportSelection.text = builder.toString()
    }


}
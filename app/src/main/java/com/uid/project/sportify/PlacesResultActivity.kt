package com.uid.project.sportify

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uid.project.sportify.adapters.PlacesResultAdapter
import com.uid.project.sportify.models.PlaceResultList

class PlacesResultActivity: AppCompatActivity() {

    private lateinit var placesResultAdapter: PlacesResultAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.place_result)
        supportActionBar?.hide()
        initRecyclerView()
        addDataSet()

    }
    private fun addDataSet(){

        val data= PlaceResultList.createDataSet()
        placesResultAdapter.submitList(data)

    }        private fun initRecyclerView(){
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view3)
        recyclerView.layoutManager= LinearLayoutManager(this@PlacesResultActivity)
        placesResultAdapter= PlacesResultAdapter()
        recyclerView.adapter=placesResultAdapter
    }




}
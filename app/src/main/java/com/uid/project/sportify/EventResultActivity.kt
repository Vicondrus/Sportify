package com.uid.project.sportify

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uid.project.sportify.adapters.EventResultAdapter

import com.uid.project.sportify.models.EventResultList

class EventResultActivity : AppCompatActivity() {

    private lateinit var eventResultAdapter: EventResultAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.events_result)
        supportActionBar?.hide()
        initRecyclerView()
        addDataSet()

    }
    private fun addDataSet(){
        val eventName=intent.getStringExtra("eventName")
        val location=intent.getStringExtra("location")
        Log.v("eventName",eventName.toString())
        Log.v("locationn",location.toString())
        val data= EventResultList.createDataSet(eventName.toString(),location.toString())
        eventResultAdapter.submitList(data)

    }        private fun initRecyclerView(){
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view3)
        recyclerView.layoutManager= LinearLayoutManager(this@EventResultActivity)
        eventResultAdapter= EventResultAdapter()
        recyclerView.adapter=eventResultAdapter
    }

}
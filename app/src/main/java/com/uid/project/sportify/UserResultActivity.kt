package com.uid.project.sportify

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.uid.project.sportify.adapters.UserResultAdapter
import com.uid.project.sportify.models.UserResultList

class UserResultActivity : AppCompatActivity() {

    private lateinit var userResultAdapter: UserResultAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_result)
        supportActionBar?.hide()
        initRecyclerView()
        addDataSet()

    }
    private fun addDataSet(){

        val data= UserResultList.createDataSet()
        userResultAdapter.submitList(data)

    }        private fun initRecyclerView(){
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view1)
        recyclerView.layoutManager= LinearLayoutManager(this@UserResultActivity)
        userResultAdapter= UserResultAdapter()
        recyclerView.adapter=userResultAdapter
    }

}
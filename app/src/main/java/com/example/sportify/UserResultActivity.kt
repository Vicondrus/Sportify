package com.example.sportify

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sportify.adapter.UserResultAdapter

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

        val data= DataSource.createDataSet()
        userResultAdapter.submitList(data)

    }        private fun initRecyclerView(){
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager= LinearLayoutManager(this@UserResultActivity)
        userResultAdapter= UserResultAdapter()
        recyclerView.adapter=userResultAdapter
    }

}
package com.uid.project.sportify

import android.os.Bundle
import android.util.Log
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


   /* val button4 = findViewById<ImageButton>(R.id.imageButton4) //bike
    val button5 = findViewById<ImageButton>(R.id.imageButton5) //baseball
    val button6 = findViewById<ImageButton>(R.id.imageButton6) //walk
    val button7 = findViewById<ImageButton>(R.id.imageButton7) //football
    val button8 = findViewById<ImageButton>(R.id.imageButton8) //yoga
    val button9 = findViewById<ImageButton>(R.id.imageButton9)//stretching*/
    private fun addDataSet(){

       val name=intent.getStringExtra("userSearch")

       val sportsSelected=intent.getStringArrayExtra("sportsSelected")

       if (sportsSelected != null) {
           for(sport in sportsSelected)

            Log.v("sportSelected",sport)
       }
       val data= UserResultList.createDataSet(name.toString(),sportsSelected)
        if (name != null) {
            Log.v("userresultname",name.toString())
        }
        userResultAdapter.submitList(data)

    }        private fun initRecyclerView(){
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view3)
        recyclerView.layoutManager= LinearLayoutManager(this@UserResultActivity)
        userResultAdapter= UserResultAdapter()
        recyclerView.adapter=userResultAdapter
    }

}
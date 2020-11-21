package com.uid.project.sportify

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uid.project.sportify.adapters.ParticipationListAdapter
import com.uid.project.sportify.adapters.SportsListAdapter
import com.uid.project.sportify.adapters.TagsListAdapter
import com.uid.project.sportify.models.*
import java.util.*

class ProfilePageActivity : AppCompatActivity() {

    private lateinit var sportsListAdapter: SportsListAdapter
    private lateinit var tagsListAdapter: TagsListAdapter
    private lateinit var pastListAdapter: ParticipationListAdapter
    private lateinit var upcomingListAdapter: ParticipationListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_profile)

        val user = Registry.user1Manager

        val nameLabel = findViewById<TextView>(R.id.nameLabel)
        nameLabel.text = "Ana Maria"

        val locationLabel = findViewById<TextView>(R.id.locationLabel)
        locationLabel.text = "Grigorescu"

        val layoutManager1 = LinearLayoutManager(this@ProfilePageActivity,LinearLayoutManager.HORIZONTAL,false)
        val layoutManager2 = LinearLayoutManager(this@ProfilePageActivity,LinearLayoutManager.HORIZONTAL,false)
        val layoutManager3 = LinearLayoutManager(this@ProfilePageActivity,LinearLayoutManager.HORIZONTAL,false)
        val layoutManager4 = LinearLayoutManager(this@ProfilePageActivity,LinearLayoutManager.HORIZONTAL,false)

        val sportsRecyclerView = findViewById<RecyclerView>(R.id.sportsRecyclerView)
        sportsRecyclerView.layoutManager = layoutManager1

        val tagsRecyclerView = findViewById<RecyclerView>(R.id.tagsRecyclerView)
        tagsRecyclerView.layoutManager = layoutManager2

        val pastRecyclerView = findViewById<RecyclerView>(R.id.pastRecyclerView)
        pastRecyclerView.layoutManager = layoutManager3

        val upcomingRecyclerView = findViewById<RecyclerView>(R.id.upcomingRecyclerView)
        upcomingRecyclerView.layoutManager = layoutManager4

        sportsListAdapter = SportsListAdapter(user.sports)
        sportsRecyclerView.adapter = sportsListAdapter

        tagsListAdapter = TagsListAdapter(user.tags)
        tagsRecyclerView.adapter = tagsListAdapter

        pastListAdapter = ParticipationListAdapter(user.participations)
        pastRecyclerView.adapter = pastListAdapter

        upcomingListAdapter = ParticipationListAdapter(user.participations)
        upcomingRecyclerView.adapter = upcomingListAdapter
    }
}
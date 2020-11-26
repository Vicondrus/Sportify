package com.uid.project.sportify

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uid.project.sportify.adapters.ParticipationListAdapter
import com.uid.project.sportify.adapters.SportsListAdapter
import com.uid.project.sportify.adapters.TagsListAdapter
import com.uid.project.sportify.models.Registry
import de.hdodenhof.circleimageview.CircleImageView

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
        nameLabel.text = user.name

        val locationLabel = findViewById<TextView>(R.id.locationLabel)
        locationLabel.text = user.location

        val profileImage = findViewById<CircleImageView>(R.id.profileImage)
        profileImage.setImageResource(user.profilePictureId)

        val layoutManager1 = LinearLayoutManager(
            this@ProfilePageActivity,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        val layoutManager2 = LinearLayoutManager(
            this@ProfilePageActivity,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        val layoutManager3 = LinearLayoutManager(
            this@ProfilePageActivity,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        val layoutManager4 = LinearLayoutManager(
            this@ProfilePageActivity,
            LinearLayoutManager.HORIZONTAL,
            false
        )

        val sportsRecyclerView = findViewById<RecyclerView>(R.id.customizeSportsRecyclerView)
        sportsRecyclerView.layoutManager = layoutManager1

        val tagsRecyclerView = findViewById<RecyclerView>(R.id.customizeTagsRecyclerView)
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

        val button = findViewById<Button>(R.id.customizeButton)
        button.setOnClickListener {
            val intent = Intent(this, CustomizeProfileActivity::class.java)
            startActivity(intent)
        }

        @Override
        fun onRestart() {
            super.onRestart()
        }
    }
}
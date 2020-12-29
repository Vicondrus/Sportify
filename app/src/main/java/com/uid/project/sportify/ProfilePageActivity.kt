package com.uid.project.sportify

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uid.project.sportify.adapters.*
import com.uid.project.sportify.models.Participation
import com.uid.project.sportify.models.Registry
import com.uid.project.sportify.models.User
import de.hdodenhof.circleimageview.CircleImageView
import java.util.*

class ProfilePageActivity : AppCompatActivity() {

    private lateinit var sportsListAdapter: SportsListAdapter
    private lateinit var tagsListAdapter: TagsListAdapter
    private lateinit var pastListAdapter: ParticipationListAdapter
    private lateinit var upcomingListAdapter: ParticipationListAdapter
    private lateinit var groupsListAdapter: GroupsListAdapter
    private lateinit var ownListAdapter: EventItemListAdapter
    private val customizeCode = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_profile)

        lateinit var user: User

        val selectedUserPosition = intent.getIntExtra("selectedUser", -1)

        if (selectedUserPosition == -1) {
            user = User(Registry.user1Manager)
        } else
        {
            user=User(Registry.listOfUsers[selectedUserPosition])
        }

        val nameLabel = findViewById<TextView>(R.id.nameLabel)
        nameLabel.text = user.name

        val locationLabel = findViewById<TextView>(R.id.locationLabel)
        locationLabel.text = user.location

        val profileImage = findViewById<CircleImageView>(R.id.profileImage)
        if (user.secondaryPictureURI == null) {
            profileImage.setImageResource(user.profilePictureId)
        } else {
            profileImage.setImageURI(user.secondaryPictureURI)
        }

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
        val layoutManager5 = LinearLayoutManager(
                this@ProfilePageActivity,
                LinearLayoutManager.HORIZONTAL,
                false
        )
        val layoutManager6 = LinearLayoutManager(
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

        val groupsRecyclerView = findViewById<RecyclerView>(R.id.groupsRecyclerView)
        groupsRecyclerView.layoutManager = layoutManager5

        val ownRecyclerView = findViewById<RecyclerView>(R.id.ownRecyclerView)
        ownRecyclerView.layoutManager = layoutManager6

        sportsListAdapter = SportsListAdapter(user.sports)
        sportsRecyclerView.adapter = sportsListAdapter

        tagsListAdapter = TagsListAdapter(user.tags)
        tagsRecyclerView.adapter = tagsListAdapter

        val pastParticipations = user.participations.filter { participation: Participation ->
            participation.activity.date.before(Date())
        }.sortedByDescending { participation: Participation -> participation.activity.date }

        val futureParticipations = user.participations.filter { participation: Participation ->
            participation.activity.date.after(Date())
        }.sortedBy { participation: Participation -> participation.activity.date }

        pastListAdapter = ParticipationListAdapter(pastParticipations)
        pastRecyclerView.adapter = pastListAdapter

        upcomingListAdapter = ParticipationListAdapter(futureParticipations)
        upcomingRecyclerView.adapter = upcomingListAdapter

        val groups = Registry.listOfGroups
        groupsListAdapter = GroupsListAdapter(Registry.listOfGroups)
        groupsRecyclerView.adapter = groupsListAdapter

        ownListAdapter = EventItemListAdapter(Registry.listOfOrganizedEvents, this@ProfilePageActivity)
        ownRecyclerView.adapter = ownListAdapter

        val button = findViewById<Button>(R.id.customizeButton)

        if (selectedUserPosition == -1) {
            button.setOnClickListener {
                val intent = Intent(this, CustomizeProfileActivity::class.java)
                startActivityForResult(intent, customizeCode)
            }
        } else {
            button.visibility = View.GONE
        }

        @Override
        fun onRestart() {
            super.onRestart()
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == customizeCode){
            recreate()
        }
    }
}
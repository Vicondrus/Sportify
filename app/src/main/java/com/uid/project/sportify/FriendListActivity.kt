package com.uid.project.sportify

import android.os.Bundle
import android.widget.SearchView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uid.project.sportify.adapters.FriendListAdapter
import com.uid.project.sportify.adapters.RecentsListAdapter
import com.uid.project.sportify.models.Friend
import com.uid.project.sportify.models.Registry
import java.util.*

class FriendListActivity : AppCompatActivity() {

    private lateinit var recentsListAdapter: RecentsListAdapter
    private lateinit var friendsListAdapter: FriendListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_friend_list)

        val layoutManager1 = LinearLayoutManager(
            this@FriendListActivity,
            LinearLayoutManager.VERTICAL,
            false
        )
        val layoutManager2 = LinearLayoutManager(
            this@FriendListActivity,
            LinearLayoutManager.VERTICAL,
            false
        )


        val titleView = findViewById<TextView>(R.id.friendListTitleTextView)
        titleView.text = intent.getStringExtra("activityName")

        val eventName = findViewById<TextView>(R.id.friendListEventNameListView)
        eventName.text = intent.getStringExtra("eventName")

        val recentsRecyclerView = findViewById<RecyclerView>(R.id.recentsRecyclerView)
        recentsRecyclerView.layoutManager = layoutManager1

        val random = Random()
        val friends = Registry.listOfFriends
        friends.shuffle()
        var x: Friend
        val recents = mutableListOf<Friend>()

        fun rand(from: Int, to: Int): Friend {
            do {
                x = friends[random.nextInt(to - from) + from]
            } while (recents.contains(x))

            recents.add(x)
            return x
        }

        while (recents.size < 4) {
            var differentNumber = rand(0, friends.size)
        }

        recentsListAdapter = RecentsListAdapter(recents)
        recentsRecyclerView.adapter = recentsListAdapter

        val friendsRecyclerView = findViewById<RecyclerView>(R.id.friendsRecyclerView)
        friendsRecyclerView.layoutManager = layoutManager2

        friendsListAdapter = FriendListAdapter(friends, recentsListAdapter)
        friendsRecyclerView.adapter = friendsListAdapter

        recentsListAdapter.otherAdapter = friendsListAdapter

        val friendsSearchView =
            findViewById<SearchView>(R.id.searchView2)

        friendsSearchView.setOnQueryTextListener(object :
            SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                friendsListAdapter.filter.filter(newText)
                return false
            }

        })
    }
}
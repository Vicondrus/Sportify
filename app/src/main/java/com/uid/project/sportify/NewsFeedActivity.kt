package com.uid.project.sportify

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uid.project.sportify.adapters.NewsFeedPostAdapter
import com.uid.project.sportify.models.NewsFeedPost
import com.uid.project.sportify.models.Registry

class NewsFeedActivity : AppCompatActivity() {

    private lateinit var newsFeedPosts: List<NewsFeedPost>
    private lateinit var newsFeedPostAdapter: NewsFeedPostAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_feed)

        supportActionBar?.hide()

        val newsFeedRecyclerView = findViewById<RecyclerView>(R.id.newsFeedRecyclerView)
        val layoutManager = LinearLayoutManager(
            this@NewsFeedActivity,
        )
        newsFeedRecyclerView.layoutManager = layoutManager
        newsFeedPosts = Registry.listofNewsFeedPosts
        newsFeedPostAdapter = NewsFeedPostAdapter(newsFeedPosts, this@NewsFeedActivity)
        newsFeedRecyclerView.adapter = newsFeedPostAdapter

        val searchButton = findViewById<ImageButton>(R.id.feedSearchButton)
        searchButton.setOnClickListener {
            val intent = Intent(this, ButtonsPageSearchActivity::class.java)
            startActivity(intent)
        }

        val addButton = findViewById<ImageButton>(R.id.feedAddButton)
        addButton.setOnClickListener {
            val intent = Intent(this, ButtonsPageAddActivity::class.java)
            startActivity(intent)
        }

        val chatButton = findViewById<ImageButton>(R.id.feedChatButton)
        chatButton.setOnClickListener {
            val intent = Intent(this, ChatMainActivity::class.java)
            startActivity(intent)
        }

        val profileButton = findViewById<ImageButton>(R.id.feedProfileButton)
        profileButton.setOnClickListener {
            val intent = Intent(this, ProfilePageActivity::class.java)
            startActivity(intent)
        }

    }
}
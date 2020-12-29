package com.uid.project.sportify

import android.net.Uri
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uid.project.sportify.adapters.EventPhotoItemAdapter
import com.uid.project.sportify.models.Event
import com.uid.project.sportify.models.NewsFeedPostPhotos
import com.uid.project.sportify.models.Registry
import de.hdodenhof.circleimageview.CircleImageView

class EventPhotosActivity : AppCompatActivity() {

    private lateinit var event: Event
    private lateinit var post: NewsFeedPostPhotos
    private lateinit var eventPhotos: ArrayList<Int>
    private lateinit var eventPhotosAdapter: EventPhotoItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_photos)
        supportActionBar?.hide()

        post = intent.getSerializableExtra("post") as NewsFeedPostPhotos
        event = post.event

        var eventImage = findViewById<CircleImageView>(R.id.eventPhotosEventImage)
        var eventName = findViewById<TextView>(R.id.eventPhotosEventName)
        var updateTime = findViewById<TextView>(R.id.eventPhotosUpdateTime)
        var description = findViewById<TextView>(R.id.eventPhotosDescription)

        if (event.imageUri == null) {
            eventImage.setImageResource(event.image)
        } else {
            eventImage.setImageURI(Uri.parse(event.imageUri))
        }
        eventName.text = event.name
        updateTime.text = post.postTime
        description.text = post.postDescription

        val eventPhotosRecyclerView = findViewById<RecyclerView>(R.id.eventPhotosRecyclerView)
        val layoutManager = LinearLayoutManager(this@EventPhotosActivity)
        eventPhotosRecyclerView.layoutManager = layoutManager
        eventPhotos = Registry.listOfEventPhotos
        eventPhotosAdapter = EventPhotoItemAdapter(eventPhotos)
        eventPhotosRecyclerView.adapter = eventPhotosAdapter

    }
}
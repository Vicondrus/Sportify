package com.uid.project.sportify.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.uid.project.sportify.EventPageUserActivity
import com.uid.project.sportify.EventPhotosActivity
import com.uid.project.sportify.R
import com.uid.project.sportify.holders.NewsFeedPostEventViewHolder
import com.uid.project.sportify.holders.NewsFeedPostPhotosViewHolder
import com.uid.project.sportify.models.NewsFeedPost
import com.uid.project.sportify.models.NewsFeedPostEvent
import com.uid.project.sportify.models.NewsFeedPostPhotos


class NewsFeedPostAdapter(private val dataSet: List<NewsFeedPost>, private val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val POST_EVENT = 1
    private val POST_PHOTOS = 2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == POST_EVENT) {
            val inflater = LayoutInflater.from(parent.context)
            val view = inflater.inflate(R.layout.news_feed_post_design_1, parent, false)
            NewsFeedPostEventViewHolder(view)

        } else {
            val inflater = LayoutInflater.from(parent.context)
            val view = inflater.inflate(R.layout.news_feed_post_design_2, parent, false)
            NewsFeedPostPhotosViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val post: NewsFeedPost = dataSet[position]
        if (getItemViewType(position) == POST_EVENT) {
            (holder as NewsFeedPostEventViewHolder).bind(post)
            holder.eventDetailsBtn?.setOnClickListener {
                val intent = Intent(context, EventPageUserActivity::class.java)
                val postEvent = post as NewsFeedPostEvent
                intent.putExtra("event", postEvent.event)
                context.startActivity(intent)
            }
        } else {
            (holder as NewsFeedPostPhotosViewHolder).bind(post)
            holder.postPhotoToolbar?.setOnClickListener {
                val intent = Intent(context, EventPhotosActivity::class.java)
                val postEvent = post as NewsFeedPostPhotos
                intent.putExtra("post", postEvent)
                context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun getItemViewType(position: Int): Int {
        if (dataSet[position] is NewsFeedPostEvent) {
            return POST_EVENT
        } else {
            return POST_PHOTOS
        }
    }

}

package com.uid.project.sportify.holders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import com.uid.project.sportify.R
import com.uid.project.sportify.models.NewsFeedPost
import com.uid.project.sportify.models.NewsFeedPostPhotos

class NewsFeedPostPhotosViewHolder(private val view: View) :
        RecyclerView.ViewHolder(view), View.OnClickListener {
    private var friendName: TextView? = null
    private var friendImage: ImageView? = null
    private var eventName: TextView? = null
    private var eventImage: ImageView? = null
    private var postTime: TextView? = null
    private var postDescription: TextView? = null
    private var postCoverImage: ImageView? = null
    var postPhotoToolbar: Toolbar? = null

    init {
        friendName = itemView.findViewById(R.id.newsFriendName2) as TextView
        friendImage = itemView.findViewById(R.id.newsFriendImage2) as ImageView
        eventName = itemView.findViewById(R.id.newsEventName2) as TextView
        eventImage = itemView.findViewById(R.id.newsEventImage2) as ImageView
        postTime = itemView.findViewById(R.id.newsUpdateTime2) as TextView
        postDescription = itemView.findViewById(R.id.newsDescription2) as TextView
        postCoverImage = itemView.findViewById(R.id.newsCoverImage2) as ImageView
        postPhotoToolbar = itemView.findViewById(R.id.newsPhotoToolbar2) as Toolbar
    }

    fun bind(newsFeedPost: NewsFeedPost) {
        val newsFeedPostPhotos = newsFeedPost as NewsFeedPostPhotos
        friendName?.text = newsFeedPostPhotos.event.host
        friendImage?.setImageResource(newsFeedPostPhotos.friendImage)
        eventName?.text = newsFeedPostPhotos.event.name
        eventImage?.setImageResource(newsFeedPostPhotos.event.image)
        postTime?.text = newsFeedPostPhotos.postTime
        postDescription?.text = newsFeedPostPhotos.postDescription
        postCoverImage?.setImageResource(newsFeedPostPhotos.postCoverImage)
    }

    override fun onClick(view: View?) {
    }

}
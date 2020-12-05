package com.uid.project.sportify.models

class NewsFeedPostPhotos(
        val friendName: String,
        val friendImage: Int,
        val eventName: String,
        val eventImage: Int,
        val postTime: String,
        val postDescription: String,
        val postCoverImage: Int
) : NewsFeedPost
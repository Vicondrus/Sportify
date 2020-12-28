package com.uid.project.sportify.models

import java.io.Serializable

class NewsFeedPostPhotos(
        val friendImage: Int,
        val postTime: String,
        val postDescription: String,
        val postCoverImage: Int,
        val event: Event
) : NewsFeedPost, Serializable
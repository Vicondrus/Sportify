package com.uid.project.sportify.models

class NewsFeedPostEvent(
        val friendName: String,
        val friendImage: Int,
        val eventName: String,
        val eventImage: Int,
        val eventDate: String,
        val eventTimeStart: String,
        val eventTimeEnd: String,
        val eventDescription: String,
        val eventLocation: String,
        val eventNbOfPeople: String,
) : NewsFeedPost

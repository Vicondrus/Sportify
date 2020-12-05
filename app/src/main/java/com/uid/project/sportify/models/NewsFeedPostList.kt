package com.example.calatour.model

import com.uid.project.sportify.R
import com.uid.project.sportify.models.NewsFeedPost
import com.uid.project.sportify.models.NewsFeedPostEvent
import com.uid.project.sportify.models.NewsFeedPostPhotos

class NewsFeedPostList {
    fun getNewsFeedPosts(): ArrayList<NewsFeedPost> {
        val response = ArrayList<NewsFeedPost>()
        response.add(NewsFeedPostEvent("Alex Ion", R.drawable.boy_pic_3, "Volleyball game for beginners", R.drawable.event_picture,
                "06/12/2020", "12:00", "14:00", "This event targets all amateur volleyball players or even" +
                " those inexperienced! Cantec, joc, si voie buna la noi!", "Sala Sporturilor", "6 people are going 8 spots left"))
        response.add(NewsFeedPostPhotos("Ana Pop", R.drawable.girl_pic_2, "Monthly school football competition",
                R.drawable.sport_pic_2, "1 hour ago", "The boys from Colegiul National Vasile Lucaciu won the cup" +
                "once again this month! Congrats to everyone!!", R.drawable.sport_pic_1))
        return response
    }
}
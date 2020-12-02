package com.example.calatour.model

import com.uid.project.sportify.R
import com.uid.project.sportify.models.ChatMessage
import com.uid.project.sportify.models.Friend

class ChatMessageList {
    fun getMessages(): ArrayList<ChatMessage> {
        val response = ArrayList<ChatMessage>()
        response.add(ChatMessage(Friend("Dina Meyer", R.drawable.girl_pic_1), "2 hrs", "Welcome to Yoga Meetup", false))
        response.add(ChatMessage(Friend("Stephane Moreau", R.drawable.boy_pic_1), "3 hrs", "Hi!", false))
        response.add(ChatMessage(Friend("Andrew James", R.drawable.boy_pic_2), "9 hrs", "Hello", true))
        response.add(ChatMessage(Friend("Andreea Pop", R.drawable.girl_pic_2), "Aug 19", "Check out this meetup", true))
        response.add(ChatMessage(Friend("John Smith", R.drawable.boy_pic_3), "Jul 24", "See you there", true))
        response.add(ChatMessage(Friend("Jane Doe", R.drawable.girl_pic_3), "Jun 12", "Tty later!", true))

        return response
    }
}
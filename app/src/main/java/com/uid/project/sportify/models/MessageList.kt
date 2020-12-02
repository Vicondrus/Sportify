package com.example.calatour.model

import com.uid.project.sportify.models.Message

class MessageList {
    fun getMessages(): ArrayList<Message> {
        val response = ArrayList<Message>()
        response.add(Message("Hello, Ana!", false))
        response.add(Message("How are u?", false))
        response.add(Message("Hello dear friend!", true))
        response.add(Message("Super fine! Gettin ready for the monthly student volleyball game!", true))
        response.add(Message("Are u coming too?", true))
        response.add(Message("Yes, just arrived at the place", false))
        response.add(Message("Great! See u there then!", true))
        response.add(Message("Can't wait!", false))

        return response
    }
}
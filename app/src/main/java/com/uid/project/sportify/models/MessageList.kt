package com.example.calatour.model

import com.uid.project.sportify.models.Message
import com.uid.project.sportify.models.MessageType

class MessageList {
    fun getMessages(): ArrayList<Message> {
        val response = ArrayList<Message>()
        response.add(Message("Hello, Ana!", MessageType.MSG_RECEIVED))
        response.add(Message("How are u?", MessageType.MSG_RECEIVED))
        response.add(Message("Hello dear friend!", MessageType.MSG_SENT))
        response.add(
            Message(
                "Super fine! Gettin ready for the monthly student volleyball game!",
                MessageType.MSG_SENT
            )
        )
        response.add(Message("Are u coming too?", MessageType.MSG_SENT))
        response.add(Message("Yes, just arrived at the place", MessageType.MSG_RECEIVED))
        response.add(Message("Great! See u there then!", MessageType.MSG_SENT))
        response.add(Message("Can't wait!", MessageType.MSG_RECEIVED))

        return response
    }
}
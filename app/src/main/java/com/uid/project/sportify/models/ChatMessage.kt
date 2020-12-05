package com.uid.project.sportify.models

import java.io.Serializable

class ChatMessage(
        val friend: Friend,
        var time: String,
        var lastMessage: String,
        var isRead: Boolean,
        var messageList: List<Message>
) : Serializable
package com.uid.project.sportify.models

import java.io.Serializable

class ChatMessage(
        val friend: Friend,
        val time: String,
        val lastMessage: String,
        val isRead: Boolean
) : Serializable
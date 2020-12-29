package com.uid.project.sportify.models

import java.io.Serializable

class Message(
        val message: String,
        val type: MessageType
) : Serializable
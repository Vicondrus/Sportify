package com.uid.project.sportify.models

import java.io.Serializable

class Friend(
    var name: String,
    var profilePictureId: Int,
    var isSent: Boolean = false
) : Serializable
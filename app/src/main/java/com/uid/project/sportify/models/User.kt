package com.uid.project.sportify.models

import java.util.*

class User(val name: String,
           val email: String,
           val password: String,
           val location: String,
           val birthdate: Date,
           val sports: MutableList<Sport>,
           val tags: MutableList<String>,
           val participations: MutableList<Participation>,
           val profilePictureId: Int
)
package com.uid.project.sportify.models

import java.util.*

class User(val name: String,
           val email: String,
           val password: String,
           val location: String,
           val birthdate: Date,
           val sports: List<Sport>,
           val tags: List<String>,
           val participations: List<Participation>
)
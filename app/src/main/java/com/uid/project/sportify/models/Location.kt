package com.uid.project.sportify.models

import java.io.Serializable

class Location(
    var location: String,
    var neighborhood: String,
    var coords: Coordinates
) : Serializable
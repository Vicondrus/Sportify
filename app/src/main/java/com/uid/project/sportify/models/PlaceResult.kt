package com.uid.project.sportify.models

import java.io.Serializable

data class PlaceResult(var placeName: String,
                       var placeImage: Int,
                       var placeDescription: String,
                       var placeLocation: String,
                       var placeRating: String,
                       var placePrice: String,
                       var placeUnavailableDates: List<String>,
        // var placeSportType: String
) : Serializable


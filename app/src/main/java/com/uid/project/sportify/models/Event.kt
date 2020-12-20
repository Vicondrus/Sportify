package com.uid.project.sportify.models

import java.io.Serializable
import java.time.LocalDate
import java.time.LocalTime

class Event(
        var name: String,
        var image: Int,
        var host: String,
        var description: String,
        var date: LocalDate,
        var timeStart: LocalTime,
        var timeEnd: LocalTime,
        var nbOfPeople: Int,
        var attendanceFee: Int,
        var location: String,
        val sports: ArrayList<Sport>,
        val requirements: ArrayList<String>,
        val tags: ArrayList<String>,
        val participants: Int = 0,
        var imageUri: String? = null
) : Serializable
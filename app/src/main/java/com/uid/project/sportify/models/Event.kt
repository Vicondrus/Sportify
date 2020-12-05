package com.uid.project.sportify.models

import java.io.Serializable
import java.time.LocalDate
import java.time.LocalTime

class Event(
        val name: String,
        val image: Int,
        val host: String,
        val description: String,
        val date: LocalDate,
        val time: LocalTime,
        val nbOfPeople: Int,
        val attendanceFee: Int,
        val location: String,
        val sports: MutableList<Sport>,
        val requirements: MutableList<String>,
        val tags: MutableList<String>,
) : Serializable
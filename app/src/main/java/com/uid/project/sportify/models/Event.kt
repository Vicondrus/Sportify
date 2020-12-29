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
        var location: Location,
        val sports: ArrayList<Sport>,
        val requirements: ArrayList<String>,
        val tags: ArrayList<String>,
        var participants: Int = 0,
        var imageUri: String? = null,
        var participantsList: ArrayList<String> = arrayListOf()
) : Serializable {
    override fun toString(): String {
        return "Event(name='$name', image=$image, host='$host', description='$description', date=$date, timeStart=$timeStart, timeEnd=$timeEnd, nbOfPeople=$nbOfPeople, attendanceFee=$attendanceFee, location=$location, sports=$sports, requirements=$requirements, tags=$tags, participants=$participants, imageUri=$imageUri, participantsList=$participantsList)"
    }
}
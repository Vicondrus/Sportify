package com.uid.project.sportify.models

import com.uid.project.sportify.R
import java.time.LocalDate
import java.time.ZoneId
import java.util.*

class Registry private constructor() {

    companion object {
        private var user1: User? = null

        var user1Manager: User
            get() {
                if (user1 == null) {
                    user1 = User(
                            "Ana Maria", "ana.maria@yahoo.com",
                            "password", "Grigorescu", java.util.Date.from(
                            LocalDate.parse("1997-11-06").atStartOfDay()
                                    .atZone(ZoneId.systemDefault())
                                    .toInstant()
                    ),
                            mutableListOf(
                                    Sport("Aerobics", Level.BEGINNER, notSelectedImage = R.drawable.aerobics, selectedImage = R.drawable.aerobics_selected),
                                    Sport("Basketball", Level.EXPERT, notSelectedImage = R.drawable.basketball, selectedImage = R.drawable.backetball_selected),
                            ),
                            mutableListOf("#ParculMare", "#ProfessionalTenis", "#Politehnica"),
                            mutableListOf(
                                    Participation(
                                            Activity(
                                                    "Basketball Match",
                                                    "Gheorgheni",
                                                    Date(),
                                                    R.drawable.basketball_presentation
                                            ), PaticipationType.VIEWER
                                    ),
                                    Participation(
                                            Activity(
                                                    "Tennis Match",
                                                    "Grigorescu",
                                                    Date(),
                                                    R.drawable.tennis_presentation
                                            ), PaticipationType.VIEWER
                                    )
                            ),
                            R.drawable.ana_profile_picture
                    )
                }

                return user1 as User
            }
            set(u: User) {
                user1 = u
            }

        val setOfTags: MutableSet<String>
            get() = mutableSetOf(
                    "#Rozelor",
                    "#ParculMare",
                    "#Politehnica",
                    "#Babes",
                    "#ProfessionalBasketball",
                    "#ChildFriendly"
            )

        val setOfAvailableSports: Set<Sport>
            get() = setOf(
                    Sport("Aerobics", Level.FAN, notSelectedImage = R.drawable.aerobics, selectedImage = R.drawable.aerobics_selected),
                    Sport("Basketball", Level.FAN, notSelectedImage = R.drawable.basketball, selectedImage = R.drawable.backetball_selected),
                    Sport("Combat", Level.FAN, notSelectedImage = R.drawable.combat, selectedImage = R.drawable.combat_selected),
                    Sport("Dance", Level.FAN, notSelectedImage = R.drawable.dance, selectedImage = R.drawable.dance_selected),
                    Sport("Football", Level.FAN, notSelectedImage = R.drawable.football, selectedImage = R.drawable.football_selected),
                    Sport("Handball", Level.FAN, notSelectedImage = R.drawable.handball, selectedImage = R.drawable.handball_selected),
                    Sport("Karate", Level.FAN, notSelectedImage = R.drawable.karate, selectedImage = R.drawable.karate_selected),
                    Sport("Pilates", Level.FAN, notSelectedImage = R.drawable.pilates, selectedImage = R.drawable.pilates_selected),
                    Sport("Running", Level.FAN, notSelectedImage = R.drawable.running, selectedImage = R.drawable.running_selected),
                    Sport("Cycling", Level.FAN, notSelectedImage = R.drawable.spinning, selectedImage = R.drawable.biking_selected),
                    Sport("Swimming", Level.FAN, notSelectedImage = R.drawable.swimming, selectedImage = R.drawable.swimming_selected),
                    Sport("Tennis", Level.FAN, notSelectedImage = R.drawable.tennis, selectedImage = R.drawable.tennis_selected),
                    Sport("Volleyball", Level.FAN, notSelectedImage = R.drawable.volleyball, selectedImage = R.drawable.volleyball_selected),
                    Sport("Walking", Level.FAN, notSelectedImage = R.drawable.walking, selectedImage = R.drawable.walking_selected),
                    Sport("Yoga", Level.FAN, notSelectedImage = R.drawable.yoga, selectedImage = R.drawable.yoga_selected),
            )
    }
}
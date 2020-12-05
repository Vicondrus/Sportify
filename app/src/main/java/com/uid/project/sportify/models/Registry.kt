package com.uid.project.sportify.models

import com.uid.project.sportify.R
import java.time.LocalDate
import java.time.ZoneId
import java.util.*

class Registry private constructor() {

    companion object {

        private var user1: User? = null

        val user1Manager: User
            get() {
                if (user1 == null) {
                    user1 = User(
                        "Ana Maria", "ana.maria@yahoo.com",
                        "password", "Centru", java.util.Date.from(
                            LocalDate.parse("1997-11-06").atStartOfDay()
                                .atZone(ZoneId.systemDefault())
                                .toInstant()
                        ),
                        mutableListOf(
                            Sport("Basketball", Level.BEGINNER),
                            Sport("Track and Field", Level.ADVANCED)
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
    }
}
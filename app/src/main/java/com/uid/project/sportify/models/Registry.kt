package com.uid.project.sportify.models

import com.uid.project.sportify.R
import java.util.*

class Registry private constructor() {

    companion object {
        private var user1: User? = null

        val user1Manager: User
            get() {
                if (user1 == null){
                    user1 = User("Ana Maria", "ana.maria@yahoo.com",
                    "password", "Grigorescu", Date(1999, 6, 1),
                            listOf(Sport("Basketball", Level.BEGINNER), Sport("Track and Field", Level.ADVANCED)),
                            listOf("#ParculMare", "#ProfessionalTenis", "#Politehnica"),
                            listOf(Participation(Activity("Basketball Match", "Gheorgheni", Date(), R.drawable.basketball_presentation), PaticipationType.VIEWER),
                                    Participation(Activity("Tennis Match", "Grigorescu", Date(), R.drawable.tennis_presentation), PaticipationType.VIEWER))
                    )
                }

                return user1 as User
            }
    }
}
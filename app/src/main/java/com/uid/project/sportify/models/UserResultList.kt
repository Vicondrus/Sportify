package com.uid.project.sportify.models


class UserResultList {

    companion object {

        //hardcoded data
        fun createDataSet(name: String, sportsSelected: java.util.ArrayList<String>?): ArrayList<User> {
            val list = ArrayList<User>()
            var ok = false
            val listOfUsers = Registry.listOfUsers
            for (user in listOfUsers) {
                if (user.name == name) {
                    if (sportsSelected != null) {
                        for (sportSelected in sportsSelected)
                            for (sport in user.sports)

                                if (sport.name == sportSelected)
                                    ok = true
                    }
                    //ok=true
                    if (ok) {
                        list.add(
                                user
                                //Registry.user1Manager
                        )
                    }
//                list.add(
//                        Registry.user1Manager)
                }
            }



            return list
        }


    }
}
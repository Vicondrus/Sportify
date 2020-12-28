package com.uid.project.sportify.models


class UserResultList {

    companion object{

        //hardcoded data
        fun createDataSet(name:String, sportsSelected: Array<String>?): ArrayList<User>{
            val list = ArrayList<User>()
            var ok=false
            if(Registry.user1Manager.name.equals(name)){
              /*  if (sportsSelected != null) {
                    for(sportSelected in sportsSelected)
                        for(sport in Registry.user1Manager.sports)

                            if(sport.name.equals(sportSelected))
                                ok=true
                }
                ok=true
               if(ok==true){list.add(
                       Registry.user1Manager) }*/
                list.add(
                        Registry.user1Manager)
            }



            return list
        }


    }
}
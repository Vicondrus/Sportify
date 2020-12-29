package com.uid.project.sportify.models


import android.util.Log

class PlaceResultList {

    companion object {

        //hardcoded data
        fun createDataSet(date: String): ArrayList<PlaceResult> {
            val list = ArrayList<PlaceResult>()
            var ok = true
            for (dateUnavailable in Registry.place1Manager.placeUnavailableDates) {

                if (date.equals(dateUnavailable))
                    ok = false
                Log.v("unav", dateUnavailable)
                Log.v("abaa", date)
            }


            if (ok == true)
                list.add(Registry.place1Manager)
            /* list.add(
                     PlaceResult(
                             "Alexandra Bianca",
                             "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.facebook.com%2Ftheyogaplaceskopje%2Fphotos%2F&psig=AOvVaw1STjfrcu0MkG6J2RxZNuw3&ust=1608816607772000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCIC--4Wb5O0CFQAAAAAdAAAAABAD",
                             "https://raw.githubusercontent.com/mitchtabian/Blog-Images/master/digital_ocean.png",
                             "Basketball",
                             "Intermediate"
                     )
             )*/




            return list
        }


    }
}
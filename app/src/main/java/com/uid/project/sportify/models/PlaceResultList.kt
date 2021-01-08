package com.uid.project.sportify.models


import android.util.Log

class PlaceResultList {

    companion object {

        //hardcoded data
        fun createDataSet(date: String): ArrayList<PlaceResult> {
            val list = ArrayList<PlaceResult>()
            var ok = true
            val listOfPlaceResults = Registry.listOfPlaceResults
            for(place in listOfPlaceResults) {
                ok=true;
                for (dateUnavailable in place.placeUnavailableDates) {

                    if (date.equals(dateUnavailable))
                        ok = false

                    Log.v("unav", dateUnavailable)
                    Log.v("abaa", date)
                }
                if (ok == true)
                    list.add(place)
            }






            return list
        }


    }
}
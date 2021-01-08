package com.uid.project.sportify.models

import android.util.Log


class EventResultList {

    companion object {

        //hardcoded data
        fun createDataSet(name: String, location: String): ArrayList<Event> {
            val list = ArrayList<Event>()
            val listOfEvents = Registry.listOfEvents
            Log.v("eventRes", name)
            //     "AbBaCca".contains("bac", ignoreCase = true)
            // val existingEvents=  Registry.listOfEvents.get()
            for(event in listOfEvents){
                Log.v("eventt", "null")
                //     else  if (event != null) {
                if (event != null) {
                    if (event.name.contains(name, true)

                        && event.location.neighborhood.equals(location)
                    ) {
                        list.add(event)
                    }
                }
            }
            return list
        }
    }
}
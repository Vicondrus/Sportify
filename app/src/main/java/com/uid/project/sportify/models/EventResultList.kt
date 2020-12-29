package com.uid.project.sportify.models

import android.util.Log


class EventResultList {

    companion object {

        //hardcoded data
        fun createDataSet(name: String, location: String): ArrayList<Event> {
            val list = ArrayList<Event>()
            Log.v("eventRes", name)
            //     "AbBaCca".contains("bac", ignoreCase = true)
            // val existingEvents=  Registry.listOfEvents.get()
            val event = Registry.event2Manager
            //   for(event in existingEvents)
            //      if(event==null)
            Log.v("eventt", "null")
            //     else  if (event != null) {
            Log.v("eventRes", event.name)
            if (event.name.contains(name, true) && event.location.neighborhood.equals(location)) {
                list.add(event)
            }
            /*   list.add(
                    EventResult(
                            "Yoga & Basketball Event",
                            "2020-10-03",
                            "400"
                    )
            )
            list.add(
                    EventResult(
                            "Basketball Event",
                            "2020-05-03",
                            "300"
                    )
            )*/


            return list
        }
    }


}
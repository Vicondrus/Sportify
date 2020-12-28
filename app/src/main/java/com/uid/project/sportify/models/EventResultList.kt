package com.uid.project.sportify.models


class EventResultList {

    companion object{

        //hardcoded data
        fun createDataSet(): ArrayList<EventResult>{
            val list = ArrayList<EventResult>()
            list.add(
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
            )



            return list
        }


    }
}
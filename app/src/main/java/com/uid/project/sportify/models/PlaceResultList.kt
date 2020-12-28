package com.uid.project.sportify.models


import com.uid.project.sportify.models.UserResult

class PlaceResultList {

    companion object{

        //hardcoded data
        fun createDataSet(): ArrayList<PlaceResult>{
            val list = ArrayList<PlaceResult>()
            list.add(
                    PlaceResult(
                            "Yoga Venue Central",
                           "https://raw.githubusercontent.com/mitchtabian/Blog-Images/master/digital_ocean.png" ,
                            // "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.facebook.com%2Ftheyogaplaceskopje%2Fphotos%2F&psig=AOvVaw1STjfrcu0MkG6J2RxZNuw3&ust=1608816607772000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCIC--4Wb5O0CFQAAAAAdAAAAABAD",
                            "Perfect spot for yoga events just in the center of New York.",
                    "New York",
                            "3.3",
                            "100"

                    )
            )
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
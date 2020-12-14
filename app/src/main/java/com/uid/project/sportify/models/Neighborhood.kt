package com.uid.project.sportify.models

import com.huawei.hms.maps.model.LatLng

class Neighborhood(
        val name: String,
        val coords: MutableList<LatLng>
)
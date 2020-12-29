package com.uid.project.sportify.models

import java.io.Serializable

class Sport(
        val name: String,
        var level: Level,
        var isSelected: Boolean = false,
        var selectedImage: Int = -1,
        var notSelectedImage: Int = -1
) : Serializable
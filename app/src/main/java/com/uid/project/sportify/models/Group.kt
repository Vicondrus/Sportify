package com.uid.project.sportify.models

import java.io.Serializable

class Group (
    var name: String ,
    var description: String ,
    var location: String ,
    var tags: MutableList<String>,
    var image: Int = -1,
    var imageUri: String? = null
) : Serializable {
    constructor(group: Group) : this(
        group.name,
        group.description,
        group.location,
        group.tags.toMutableList(),
        group.image,
        group.imageUri
    )
}
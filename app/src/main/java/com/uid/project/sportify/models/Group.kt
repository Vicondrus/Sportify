package com.uid.project.sportify.models

import java.io.Serializable

class Group (
    var name: String ,
    var description: String ,
    var location: String ,
    var tags: MutableList<String>
) : Serializable {
    constructor(group: Group) : this(
        group.name,
        group.description,
        group.location,
        group.tags.toMutableList()
    )
}
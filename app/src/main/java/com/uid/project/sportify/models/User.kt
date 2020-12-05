package com.uid.project.sportify.models

import android.net.Uri
import java.util.*

class User(
    var name: String,
    var email: String,
    var password: String,
    var location: String,
    var birthdate: Date,
    var sports: MutableList<Sport>,
    var tags: MutableList<String>,
    var participations: MutableList<Participation>,
    var profilePictureId: Int,
    var secondaryPictureURI: Uri? = null
) {
    constructor(u: User) : this(
        u.name,
        u.email,
        u.password,
        u.location,
        u.birthdate,
        u.sports.toMutableList(),
        u.tags.toMutableList(),
        u.participations.toMutableList(),
        u.profilePictureId,
        u.secondaryPictureURI
    )
}
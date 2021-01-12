package com.uid.project.sportify.holders

import android.content.Context
import android.database.Cursor
import android.graphics.drawable.Drawable
import android.net.Uri
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.uid.project.sportify.R
import com.uid.project.sportify.models.Event
import java.io.File
import java.time.format.DateTimeFormatter

class EventItemViewHolder(inflater: LayoutInflater, private var parent: ViewGroup, private val context: Context) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.event_list_item_organizer, parent, false)) {
    private var eventName: TextView? = null
    private var eventDate: TextView? = null
    var eventImage: FrameLayout? = null


    init {
        eventName = itemView.findViewById(R.id.listItemEventName)
        eventDate = itemView.findViewById(R.id.listItemEventDate)
        eventImage = itemView.findViewById(R.id.listItemEventImage)
    }

    fun bind(event: Event) {
        eventName?.text = event.name
        eventDate?.text = event.date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
        if (event.imageUri != null) {
            val cursor: Cursor? = context.contentResolver.query(Uri.parse(event.imageUri!!), null, null, null, null)
            cursor!!.moveToFirst()
            val idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA)
            val path = cursor.getString(idx)
            val file = File(path)
            if (file.exists()) {
                val d = Drawable.createFromPath(file.absolutePath)
                if (d != null){
                    eventImage?.background = d
                } else {
                    eventImage?.background = ResourcesCompat.getDrawable(parent.resources, R.drawable.event_picture, null)
                }
            }
            cursor.close()
        } else
            eventImage?.background = ResourcesCompat.getDrawable(parent.resources, event.image, null)
    }
}
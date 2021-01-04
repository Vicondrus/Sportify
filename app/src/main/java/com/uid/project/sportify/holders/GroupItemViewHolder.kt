package com.uid.project.sportify.holders

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.database.Cursor
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.uid.project.sportify.R
import com.uid.project.sportify.models.Group
import java.io.File


class GroupItemViewHolder(inflater: LayoutInflater, private var parent: ViewGroup, private var context: Context) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.event_list_item, parent, false)) {
    private var eventName: TextView? = null
    private var participationType: TextView? = null
    private var date: TextView? = null
    private var whole: FrameLayout? = null


    init {
        eventName = itemView.findViewById(R.id.activityNameTextView)
        participationType = itemView.findViewById(R.id.participationTypeTextView)
        date = itemView.findViewById(R.id.activityDateTextView)
        whole = itemView.findViewById(R.id.participationBackground)
    }

    fun bind(group: Group) {
        if(group.imageUri != null){
            val cursor: Cursor? = context.contentResolver.query(Uri.parse(group.imageUri!!), null, null, null, null)
            cursor!!.moveToFirst()
            val idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA)
            val path = cursor.getString(idx)
            val file = File(path)
            if (file.exists()) {
                val d = Drawable.createFromPath(file.absolutePath)
                whole?.background = d
            }
            cursor.close()
        }else {
            if (group.image != -1) {
                whole?.background =
                        ResourcesCompat.getDrawable(parent.resources, group.image, null)
            } else {
                whole?.background =
                        ResourcesCompat.getDrawable(parent.resources, R.drawable.generic_group, null)
            }
        }
        eventName?.text = group.name
        participationType?.text = group.description

        date?.text = group.location
    }
}
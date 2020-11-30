package com.uid.project.sportify.holders

import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat.getColor
import androidx.recyclerview.widget.RecyclerView
import com.uid.project.sportify.R

class DeletableItemViewHolder(
    inflater: LayoutInflater,
    private var parent: ViewGroup,
    private var color: Int
) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.deletable_list_item, parent, false)) {
    private var title: TextView? = null
    private var background: ConstraintLayout? = null
    var deleteButton: ImageButton? = null


    init {
        title = itemView.findViewById(R.id.deletableTitleTextView) as TextView
        deleteButton = itemView.findViewById(R.id.deleteButton) as ImageButton
        background = itemView.findViewById(R.id.backgroundDeletable) as ConstraintLayout
    }

    fun bind(text: String) {
        title?.text = text
        val shape = GradientDrawable()
        shape.cornerRadius = 40f
        shape.setColor(getColor(parent.context, color))
        background?.background = shape
    }
}
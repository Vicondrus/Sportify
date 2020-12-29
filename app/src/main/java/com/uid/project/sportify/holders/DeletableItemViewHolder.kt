package com.uid.project.sportify.holders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.chip.Chip
import com.uid.project.sportify.R

class DeletableItemViewHolder(
        inflater: LayoutInflater,
        private var parent: ViewGroup,
        private var color: Int
) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.deletable_list_item, parent, false)) {
    private var deletableChip: Chip? = null


    init {
        deletableChip = itemView.findViewById(R.id.deleatableChip)
    }

    fun bind(text: String) {
        deletableChip?.isCloseIconVisible = true
        deletableChip?.chipBackgroundColor = ContextCompat.getColorStateList(parent.context, color)
        deletableChip?.backgroundTintList = ContextCompat.getColorStateList(parent.context, color)
        deletableChip?.text = text
    }

    fun setClickListener(clickListener: View.OnClickListener) {
        deletableChip?.setOnCloseIconClickListener(clickListener)
    }
}
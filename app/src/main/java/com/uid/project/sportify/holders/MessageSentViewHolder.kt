package com.uid.project.sportify.holders

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.uid.project.sportify.R
import com.uid.project.sportify.models.Message

class MessageSentViewHolder(inflater: LayoutInflater, private var parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.message_item_sent, parent, false)) {
    private var message: TextView? = null
    private var isSent: Boolean? = null

    init {
        message = itemView.findViewById(R.id.chatMessageSent) as TextView
    }

    fun bind(sentMessage: Message) {
        message?.text = sentMessage.message
        isSent = sentMessage.isSent
    }

}
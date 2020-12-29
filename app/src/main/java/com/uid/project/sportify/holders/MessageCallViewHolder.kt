package com.uid.project.sportify.holders

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.uid.project.sportify.R
import com.uid.project.sportify.models.Message
import com.uid.project.sportify.models.MessageType

class MessageCallViewHolder(inflater: LayoutInflater, private var parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.message_item_call, parent, false)) {
    private var message: TextView? = null
    private var type: MessageType? = null

    init {
        message = itemView.findViewById(R.id.chatMessageCall) as TextView
    }

    fun bind(sentMessage: Message) {
        message?.text = sentMessage.message
        type = sentMessage.type
    }

}
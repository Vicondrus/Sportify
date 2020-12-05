package com.uid.project.sportify.holders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import com.uid.project.sportify.R
import com.uid.project.sportify.models.ChatMessage

class ChatMessageReadViewHolder(private val view: View) :
        RecyclerView.ViewHolder(view) {
    private var personName: TextView? = null
    private var lastMessage: TextView? = null
    private var messageTime: TextView? = null
    private var personImage: ImageView? = null
    private var isRead: Boolean? = null
    var mainToolbar: Toolbar? = null

    init {
        personName = itemView.findViewById(R.id.chatPersonNameRead) as TextView
        lastMessage = itemView.findViewById(R.id.chatLastMessageRead) as TextView
        messageTime = itemView.findViewById(R.id.chatTimeRead) as TextView
        personImage = itemView.findViewById(R.id.chatPersonImageRead) as ImageView
        mainToolbar = itemView.findViewById(R.id.chatMainToolBarRead) as Toolbar
    }

    fun bind(message: ChatMessage) {
        personName?.text = message.friend.name
        lastMessage?.text = message.messageList.last().message
        messageTime?.text = message.time
        personImage?.setImageResource(message.friend.image)
        isRead = message.isRead
    }
}
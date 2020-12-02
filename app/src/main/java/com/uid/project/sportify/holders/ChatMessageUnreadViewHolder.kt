package com.uid.project.sportify.holders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import com.uid.project.sportify.R
import com.uid.project.sportify.models.ChatMessage

class ChatMessageUnreadViewHolder(private val view: View) :
        RecyclerView.ViewHolder(view), View.OnClickListener {
    private var personName: TextView? = null
    private var lastMessage: TextView? = null
    private var messageTime: TextView? = null
    private var personImage: ImageView? = null
    private var isRead: Boolean? = null
    var mainToolbar: Toolbar? = null

    init {
        personName = itemView.findViewById(R.id.chatPersonNameUnread) as TextView
        lastMessage = itemView.findViewById(R.id.chatLastMessageUnread) as TextView
        messageTime = itemView.findViewById(R.id.chatTimeUnread) as TextView
        personImage = itemView.findViewById(R.id.chatPersonImageUnread) as ImageView
        isRead = true
        mainToolbar = itemView.findViewById(R.id.chatMainToolBarUnread) as Toolbar
    }

    fun bind(message: ChatMessage) {
        personName?.text = message.friend.name
        lastMessage?.text = message.lastMessage
        messageTime?.text = message.time
        personImage?.setImageResource(message.friend.image)
        isRead = message.isRead
    }

    override fun onClick(view: View?) {
        // add here your code to be executed on list item click
    }

}
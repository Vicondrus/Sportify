package com.uid.project.sportify.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.uid.project.sportify.ChatFriendActivity
import com.uid.project.sportify.R
import com.uid.project.sportify.holders.ChatMessageReadViewHolder
import com.uid.project.sportify.holders.ChatMessageUnreadViewHolder
import com.uid.project.sportify.models.ChatMessage
import com.uid.project.sportify.models.Friend


class ChatMessagesAdapter(private val dataSet: List<ChatMessage>, private val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val MSG_READ = 1
    private val MSG_UNREAD = 2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
//        val inflater = LayoutInflater.from(parent.context)
//        val view: View
        return if (viewType == MSG_READ) {
            val inflater = LayoutInflater.from(parent.context)
            val view = inflater.inflate(R.layout.chat_message_item_read, parent, false)
            ChatMessageReadViewHolder(view)

        } else {
            val inflater = LayoutInflater.from(parent.context)
            val view = inflater.inflate(R.layout.chat_message_item_unread, parent, false)
            ChatMessageUnreadViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val message: ChatMessage = dataSet[position]
        if (getItemViewType(position) == MSG_READ) {
            (holder as ChatMessageReadViewHolder).bind(message)
            holder.mainToolbar?.setOnClickListener {
                val intent = Intent(context, ChatFriendActivity::class.java)
                val friend: Friend = dataSet[position].friend
                intent.putExtra("friend", friend)
                context.startActivity(intent)
            }
        } else {
            (holder as ChatMessageUnreadViewHolder).bind(message)
            holder.mainToolbar?.setOnClickListener {
                val intent = Intent(context, ChatFriendActivity::class.java)
                val friend: Friend = dataSet[position].friend
                intent.putExtra("friend", friend)
                context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun getItemViewType(position: Int): Int {
        if (dataSet[position].isRead) {
            return MSG_READ
        } else {
            return MSG_UNREAD
        }
    }

}

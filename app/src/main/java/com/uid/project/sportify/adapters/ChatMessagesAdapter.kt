package com.uid.project.sportify.adapters

import android.app.Activity
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
import com.uid.project.sportify.models.Message


class ChatMessagesAdapter(private val dataSet: ArrayList<ChatMessage>, private val context: Context, private val activityId: Int) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val MSG_READ = 1
    private val MSG_UNREAD = 2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
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
                val messageList: ArrayList<Message> = dataSet[position].messageList as ArrayList<Message>
                intent.putExtra("friend", friend)
                intent.putExtra("messageList", messageList)
                intent.putExtra("messagePosition", position)
                val activityContext: Activity = context as Activity
                activityContext.startActivityForResult(intent, activityId)
            }
        } else {
            (holder as ChatMessageUnreadViewHolder).bind(message)
            holder.mainToolbar?.setOnClickListener {
                val intent = Intent(context, ChatFriendActivity::class.java)
                val friend: Friend = dataSet[position].friend
                val messageList: ArrayList<Message> = dataSet[position].messageList as ArrayList<Message>
                intent.putExtra("friend", friend)
                intent.putExtra("messageList", messageList)
                intent.putExtra("messagePosition", position)
                val activityContext: Activity = context as Activity
                activityContext.startActivityForResult(intent, activityId)
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

    fun getItem(position: Int): ChatMessage {
        return dataSet[position]
    }

    fun removeMessage(position: Int) {
        dataSet.removeAt(position)
    }

    fun addMessage(position: Int, message: ChatMessage) {
        dataSet.add(position, message)
    }

}

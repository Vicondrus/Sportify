package com.uid.project.sportify.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.uid.project.sportify.holders.MessageCallViewHolder
import com.uid.project.sportify.holders.MessageReceivedViewHolder
import com.uid.project.sportify.holders.MessageSentViewHolder
import com.uid.project.sportify.models.Message
import com.uid.project.sportify.models.MessageType


class MessagesAdapter(private var dataSet: ArrayList<Message>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val MSG_SENT = 1
    private val MSG_RECEIVED = 2
    private val MSG_CALL = 3

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == MSG_SENT) {
            val inflater = LayoutInflater.from(parent.context)
            MessageSentViewHolder(inflater, parent)
        } else if (viewType == MSG_RECEIVED) {
            val inflater = LayoutInflater.from(parent.context)
            MessageReceivedViewHolder(inflater, parent)
        } else {
            val inflater = LayoutInflater.from(parent.context)
            MessageCallViewHolder(inflater, parent)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val message: Message = dataSet[position]
        if (getItemViewType(position) == MSG_SENT) {
            (holder as MessageSentViewHolder).bind(message)
        } else if (getItemViewType(position) == MSG_RECEIVED) {
            (holder as MessageReceivedViewHolder).bind(message)
        } else {
            (holder as MessageCallViewHolder).bind(message)
        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun getItemViewType(position: Int): Int {
        if (dataSet[position].type == MessageType.MSG_SENT) {
            return MSG_SENT
        } else if (dataSet[position].type == MessageType.MSG_RECEIVED) {
            return MSG_RECEIVED
        } else {
            return MSG_CALL
        }
    }


    fun addMessage(position: Int, message: Message) {
        dataSet.add(position, message)
    }

    fun getMessages(): ArrayList<Message> {
        return dataSet
    }


}

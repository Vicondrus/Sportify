package com.uid.project.sportify.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.uid.project.sportify.holders.MessageReceivedViewHolder
import com.uid.project.sportify.holders.MessageSentViewHolder
import com.uid.project.sportify.models.Message


class MessagesAdapter(private var dataSet: ArrayList<Message>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val MSG_SENT = 1
    private val MSG_RECEIVED = 2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == MSG_SENT) {
            val inflater = LayoutInflater.from(parent.context)
            MessageSentViewHolder(inflater, parent)
        } else {
            val inflater = LayoutInflater.from(parent.context)
            MessageReceivedViewHolder(inflater, parent)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val message: Message = dataSet[position]
        if (getItemViewType(position) == MSG_SENT) {
            (holder as MessageSentViewHolder).bind(message)
        } else {
            (holder as MessageReceivedViewHolder).bind(message)
        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun getItemViewType(position: Int): Int {
        if (dataSet[position].isSent) {
            return MSG_SENT
        } else {
            return MSG_RECEIVED
        }
    }


    fun addMessage(position: Int, message: Message) {
        dataSet.add(position, message)
    }

    fun getMessages(): ArrayList<Message> {
        return dataSet
    }


}

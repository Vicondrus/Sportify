package com.uid.project.sportify.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.uid.project.sportify.holders.FriendItemViewHolder
import com.uid.project.sportify.models.Friend

class RecentsListAdapter(
    private val dataSet: MutableList<Friend>
) : RecyclerView.Adapter<FriendItemViewHolder>() {

    lateinit var otherAdapter: FriendListAdapter

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return FriendItemViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: FriendItemViewHolder, position: Int) {
        val friend: Friend = dataSet[position]
        holder.bind(friend)
        holder.sendButton?.setOnClickListener {
            friend.isSent = true
            notifyDataSetChanged()
            otherAdapter.notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}
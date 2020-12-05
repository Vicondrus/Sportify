package com.uid.project.sportify.holders

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.uid.project.sportify.R
import com.uid.project.sportify.models.Friend
import de.hdodenhof.circleimageview.CircleImageView

class FriendItemViewHolder(
    inflater: LayoutInflater,
    parent: ViewGroup
) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.friend_list_item, parent, false)) {
    private var name: TextView? = null
    private var profilePic: CircleImageView? = null
    var sendButton: ImageButton? = null


    init {
        name = itemView.findViewById(R.id.friendListItemNameLabel) as TextView
        sendButton = itemView.findViewById(R.id.sendImageButton) as ImageButton
        profilePic = itemView.findViewById(R.id.profileImageFirendListItem) as CircleImageView
    }

    fun bind(friend: Friend) {
        name?.text = friend.name
        profilePic?.setImageResource(friend.profilePictureId)
        if (friend.isSent) {
            sendButton?.setImageResource(R.drawable.tick_image)
        } else {
            sendButton?.setImageResource(R.drawable.send_image)
        }
        sendButton?.setBackgroundColor(Color.WHITE)
    }

//    fun setSent(){
//        sendButton?.setImageResource(R.drawable.tick_image)
//    }
}
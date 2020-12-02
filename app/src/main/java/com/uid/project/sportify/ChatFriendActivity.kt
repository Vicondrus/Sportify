package com.uid.project.sportify

import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.calatour.model.MessageList
import com.uid.project.sportify.adapters.MessagesAdapter
import com.uid.project.sportify.models.Friend
import com.uid.project.sportify.models.Message

class ChatFriendActivity : AppCompatActivity() {

    private lateinit var friend: Friend
    private lateinit var messagesAdapter: MessagesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_friend)

        friend = intent.getSerializableExtra("friend") as Friend

        val friendNameTextView = findViewById<TextView>(R.id.messageFriendNameTextView)
        friendNameTextView.text = friend.name

        val messagesRecyclerView = findViewById<RecyclerView>(R.id.friendMessagesRecyclerView)
        val layoutManager = LinearLayoutManager(
                this@ChatFriendActivity,
        )
        layoutManager.stackFromEnd = true
        messagesRecyclerView.layoutManager = layoutManager
        messagesAdapter = MessagesAdapter(MessageList().getMessages())
        messagesRecyclerView.adapter = messagesAdapter
        messagesRecyclerView.smoothScrollToPosition(messagesAdapter.itemCount - 1)

        val sendMessageButton = findViewById<ImageButton>(R.id.sendMessageButton)
        sendMessageButton.setOnClickListener {
            val messageToSendTextView = findViewById<TextView>(R.id.messageToSendTextView)
            val messageToSend = messageToSendTextView.text.toString()
            messageToSendTextView.text = ""
            val message = Message(messageToSend, true)
            messagesAdapter.addMessage(messagesAdapter.itemCount, message)
            messagesAdapter.notifyDataSetChanged()
            messagesRecyclerView.smoothScrollToPosition(messagesAdapter.itemCount - 1)
        }


    }
}
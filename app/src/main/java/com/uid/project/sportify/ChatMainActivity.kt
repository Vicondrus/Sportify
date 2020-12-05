package com.uid.project.sportify

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.calatour.model.ChatMessageList
import com.uid.project.sportify.adapters.ChatMessagesAdapter
import com.uid.project.sportify.models.ChatMessage
import com.uid.project.sportify.models.Message

class ChatMainActivity : AppCompatActivity() {

    private lateinit var chatMessageList: ArrayList<ChatMessage>
    private lateinit var chatMessagesAdapter: ChatMessagesAdapter
    private val messageActivityId: Int = 1001

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_main)

        supportActionBar?.hide()

        val messagesRecyclerView = findViewById<RecyclerView>(R.id.chatMainRecyclerView)
        val layoutManager = LinearLayoutManager(
            this@ChatMainActivity,
        )

        chatMessageList = ChatMessageList().getMessages()

        messagesRecyclerView.layoutManager = layoutManager
        chatMessagesAdapter =
            ChatMessagesAdapter(chatMessageList, this@ChatMainActivity, messageActivityId)
        messagesRecyclerView.adapter = chatMessagesAdapter
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == messageActivityId) {
            if (resultCode == Activity.RESULT_OK) {
                val messageList = data!!.getSerializableExtra("messageList") as ArrayList<Message>
                val position = data.getIntExtra("messagePosition", -1)
                if (position > -1) {
                    var chatMessage: ChatMessage = chatMessagesAdapter.getItem(position)
                    chatMessage.messageList = messageList
                    chatMessage.isRead = true
                    chatMessage.lastMessage = "You: " + messageList.last().message
                    chatMessage.time = "Now"
                    chatMessagesAdapter.removeMessage(position)
                    chatMessagesAdapter.addMessage(0, chatMessage)
                    chatMessagesAdapter.notifyDataSetChanged()
                }
            }
        }
    }
}
package com.uid.project.sportify

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.calatour.model.ChatMessageList
import com.uid.project.sportify.adapters.ChatMessagesAdapter

class ChatMainActivity : AppCompatActivity() {

    private lateinit var chatMessagesAdapter: ChatMessagesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_main)

        val messagesRecyclerView = findViewById<RecyclerView>(R.id.chatMainRecyclerView)
        val layoutManager = LinearLayoutManager(
                this@ChatMainActivity,
        )
        messagesRecyclerView.layoutManager = layoutManager
        chatMessagesAdapter = ChatMessagesAdapter(ChatMessageList().getMessages(), this@ChatMainActivity)
        messagesRecyclerView.adapter = chatMessagesAdapter
    }
}
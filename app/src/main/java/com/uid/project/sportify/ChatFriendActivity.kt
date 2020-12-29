package com.uid.project.sportify

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uid.project.sportify.adapters.MessagesAdapter
import com.uid.project.sportify.models.CallType
import com.uid.project.sportify.models.Friend
import com.uid.project.sportify.models.Message
import com.uid.project.sportify.models.MessageType

class ChatFriendActivity : AppCompatActivity() {

    private lateinit var friend: Friend
    private lateinit var messageList: ArrayList<Message>
    private lateinit var messagesAdapter: MessagesAdapter
    private val callActivityId: Int = 1001

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_friend)

        supportActionBar?.hide()

        friend = intent.getSerializableExtra("friend") as Friend
        messageList = intent.getSerializableExtra("messageList") as ArrayList<Message>

        val friendNameTextView = findViewById<TextView>(R.id.messageFriendNameTextView)
        friendNameTextView.text = friend.name

        val messagesRecyclerView = findViewById<RecyclerView>(R.id.friendMessagesRecyclerView)
        val layoutManager = LinearLayoutManager(
                this@ChatFriendActivity,
        )
        layoutManager.stackFromEnd = true
        messagesRecyclerView.layoutManager = layoutManager
        messagesAdapter = MessagesAdapter(messageList)
        messagesRecyclerView.adapter = messagesAdapter
        messagesRecyclerView.smoothScrollToPosition(messagesAdapter.itemCount - 1)

        val sendMessageButton = findViewById<ImageButton>(R.id.sendMessageButton)
        sendMessageButton.setOnClickListener {
            val messageToSendTextView = findViewById<TextView>(R.id.messageToSendTextView)
            val messageToSend = messageToSendTextView.text.toString()
            if (messageToSend != "") {
                messageToSendTextView.text = ""
                val message = Message(messageToSend, MessageType.MSG_SENT)
                messagesAdapter.addMessage(messagesAdapter.itemCount, message)
                messagesAdapter.notifyDataSetChanged()
                messagesRecyclerView.smoothScrollToPosition(messagesAdapter.itemCount - 1)
            }
        }

        val audioCallButton = findViewById<ImageButton>(R.id.audioCallButton)
        audioCallButton.setOnClickListener {
            val intent = Intent(this@ChatFriendActivity, AudioVideoCallActivity::class.java)
            intent.putExtra("friend", friend)
            intent.putExtra("callType", CallType.CALL_AUDIO)
            startActivityForResult(intent, callActivityId)
        }

        val videoCallButton = findViewById<ImageButton>(R.id.videoCallButton)
        videoCallButton.setOnClickListener {
            val intent = Intent(this@ChatFriendActivity, AudioVideoCallActivity::class.java)
            intent.putExtra("friend", friend)
            intent.putExtra("callType", CallType.CALL_VIDEO)
            startActivityForResult(intent, callActivityId)
        }

    }

    override fun onBackPressed() {
        val intent = Intent()
        intent.putExtra("messageList", messagesAdapter.getMessages())
        intent.putExtra("messagePosition", this.intent.getIntExtra("messagePosition", -1))
        setResult(Activity.RESULT_OK, intent)
        finish()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == callActivityId) {
            if (resultCode == Activity.RESULT_OK) {
                val message = Message("You called " + friend.name, MessageType.MSG_CALL)
                messagesAdapter.addMessage(messagesAdapter.itemCount, message)
                messagesAdapter.notifyDataSetChanged()
                findViewById<RecyclerView>(R.id.friendMessagesRecyclerView).smoothScrollToPosition(
                        messagesAdapter.itemCount - 1
                )
            }
        }
    }
}
package com.uid.project.sportify

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.uid.project.sportify.models.CallType
import com.uid.project.sportify.models.Friend
import java.util.*
import kotlin.concurrent.schedule

class AudioVideoCallActivity : AppCompatActivity() {

    private lateinit var friend: Friend
    private lateinit var callType: CallType

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_audio_video_call)

        supportActionBar?.hide()

        callType = intent.getSerializableExtra("callType") as CallType

        friend = intent.getSerializableExtra("friend") as Friend
        val callingFriendNameTextView = findViewById<TextView>(R.id.callingFriendName)
        callingFriendNameTextView.text = friend.name

        val callingFriendImageImageView = findViewById<ImageView>(R.id.callingFriendImage)
        callingFriendImageImageView.setImageResource(friend.profilePictureId)

        val callingHangUpButton = findViewById<ImageButton>(R.id.callingHangUpButton)
        callingHangUpButton.setOnClickListener {
            val intent = Intent()
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

        Timer("callingTimer").schedule(3000) {
            Handler(mainLooper).post {
                callingFriendNameTextView.visibility = View.GONE
                callingFriendImageImageView.visibility = View.GONE
                callingHangUpButton.visibility = View.GONE
                findViewById<TextView>(R.id.callingLabelTextView).visibility = View.GONE
                findViewById<TextView>(R.id.threeDotsLabelTextView).visibility = View.GONE

            }
        }


    }
}
package com.uid.project.sportify

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.uid.project.sportify.models.CallType
import com.uid.project.sportify.models.Friend
import java.util.*
import kotlin.concurrent.schedule

class AudioVideoCallActivity : AppCompatActivity() {

    private lateinit var friend: Friend
    private lateinit var callType: CallType

    private var isMicrophoneOn: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_audio_video_call)

        supportActionBar?.hide()

        callType = intent.getSerializableExtra("callType") as CallType

        friend = intent.getSerializableExtra("friend") as Friend

        val callingFriendImageImageView = findViewById<ImageView>(R.id.callingFriendImage)
        callingFriendImageImageView.setImageResource(friend.profilePictureId)

        val callingHangUpButton = findViewById<ImageButton>(R.id.callingHangUpButton)
        callingHangUpButton.setOnClickListener {
            val intent = Intent()
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

        val callMicrophoneButton = findViewById<ImageButton>(R.id.callMicrophoneBtn)
        callMicrophoneButton.setOnClickListener {
            isMicrophoneOn = !isMicrophoneOn
            if (isMicrophoneOn) {
                callMicrophoneButton.setImageResource(R.drawable.ic_microphone_on)
            } else {
                callMicrophoneButton.setImageResource(R.drawable.ic_microphone_off)
            }
        }

        val callVideoButton = findViewById<ImageButton>(R.id.callVideoBtn)
        callVideoButton.setOnClickListener {
            if (callType == CallType.CALL_AUDIO) {
                callType = CallType.CALL_VIDEO
                findViewById<CardView>(R.id.myVideoCardView).visibility = View.VISIBLE
                callVideoButton.setImageResource(R.drawable.ic_video_camera_on)
            } else {
                callType = CallType.CALL_AUDIO
                findViewById<CardView>(R.id.myVideoCardView).visibility = View.GONE
                callVideoButton.setImageResource(R.drawable.ic_video_camera_off)
            }
        }
        val callHangUpButton = findViewById<ImageButton>(R.id.callHangUpBtn)
        callHangUpButton.setOnClickListener {
            val intent = Intent()
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

        findViewById<CardView>(R.id.myVideoCardView).visibility = View.GONE
        findViewById<ImageView>(R.id.callFriendVideo).visibility = View.GONE
        findViewById<CardView>(R.id.callButtonsCardView).visibility = View.GONE


        Timer("callingTimer").schedule(3000) {
            Handler(mainLooper).post {
                callingFriendImageImageView.visibility = View.GONE
                callingHangUpButton.visibility = View.GONE
                findViewById<TextView>(R.id.callingLabelTextView).visibility = View.GONE
                findViewById<ProgressBar>(R.id.callingProgressBar).visibility = View.GONE
                findViewById<CardView>(R.id.callButtonsCardView).visibility = View.VISIBLE
                findViewById<ImageView>(R.id.callFriendVideo).visibility = View.VISIBLE
                if (callType == CallType.CALL_AUDIO) {
                    // do not display my video
                    findViewById<CardView>(R.id.myVideoCardView).visibility = View.GONE
                    // set photo for video button
                    callVideoButton.setImageResource(R.drawable.ic_video_camera_off)
                }
                if (callType == CallType.CALL_VIDEO) {
                    // display my video
                    findViewById<CardView>(R.id.myVideoCardView).visibility = View.VISIBLE
                }
            }
        }


    }

    override fun onBackPressed() {
        val intent = Intent()
        setResult(Activity.RESULT_OK, intent)
        finish()
    }

}
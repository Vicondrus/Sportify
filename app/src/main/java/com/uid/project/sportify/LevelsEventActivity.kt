package com.uid.project.sportify

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uid.project.sportify.adapters.SportsListAdapter
import com.uid.project.sportify.models.Registry
import com.uid.project.sportify.models.User

class LevelsEventActivity : AppCompatActivity() {
    private lateinit var sportsListAdapter: SportsListAdapter
    private lateinit var sportsListAdapter2: SportsListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()

        lateinit var user: User
        val selectedUserPosition = intent.getIntExtra("selectedUser", -1)

        if (selectedUserPosition == -1) {
            user = User(Registry.user1Manager)
        }

        setContentView(R.layout.activity_levels_event)

        val layoutManager1 = LinearLayoutManager(
                this@LevelsEventActivity,
                LinearLayoutManager.VERTICAL,
                false
        )
        val layoutManager2 = LinearLayoutManager(
                this@LevelsEventActivity,
                LinearLayoutManager.VERTICAL,
                false
        )

        val sportsRecyclerView = findViewById<RecyclerView>(R.id.customizeSportsRecyclerViewRegisterActivity)
        sportsRecyclerView.layoutManager = layoutManager1

        val sportsRecyclerView2 = findViewById<RecyclerView>(R.id.sportsForEvent)
        sportsRecyclerView2.layoutManager = layoutManager2


        sportsListAdapter = SportsListAdapter(user.sports)
        sportsRecyclerView.adapter = sportsListAdapter

        sportsListAdapter2 = SportsListAdapter(user.sports)
        sportsRecyclerView2.adapter = sportsListAdapter2
    }

    fun continueEvent(view: View) {
        val intent = Intent(this, ActivityRegisterConfirmation::class.java)
        startActivity(intent)
        setResult(1)
        finish()
    }

    override fun onBackPressed() {
        finish()
    }

}
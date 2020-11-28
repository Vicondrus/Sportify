package com.uid.project.sportify

import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Button
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.uid.project.sportify.adapters.SportsGridAdapter
import com.uid.project.sportify.models.Level
import com.uid.project.sportify.models.Registry
import com.uid.project.sportify.models.Sport


class SportsSelectionActivity : AppCompatActivity() {

    private val levelSelectionId = 2
    private lateinit var adapter: SportsGridAdapter
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_sports_selection)

        val gridView = findViewById<GridView>(R.id.sports_grid)
        val list = Registry.setOfAvailableSports.toList()
        adapter = SportsGridAdapter(list, this@SportsSelectionActivity)
        gridView.adapter = adapter

        gridView.setOnItemClickListener { adapterView: AdapterView<*>, view1: View, i: Int, l: Long ->
            val intent = Intent(this, LevelPopupActivity::class.java)
            intent.putExtra("sportPosition", i)
            startActivityForResult(intent, levelSelectionId)
        }

        button = findViewById(R.id.sportSubmitButton)
        button.isEnabled = false
        button.isClickable = false

        button.setOnClickListener {
            val intent = Intent()
            intent.putExtra("selectedSport", list.find { x -> x.isSelected })
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }

    override fun onActivityResult(
            requestCode: Int,
            resultCode: Int,
            data: Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode==levelSelectionId){
            if(resultCode== Activity.RESULT_OK){
                val level = data!!.getIntExtra("selectedLevel", -1)
                val position = data.getIntExtra("sportPosition", -1)
                adapter.dataList.forEach{x -> x.isSelected = false}
                if (position > -1){
                    adapter.dataList[position].isSelected = true
                    adapter.dataList[position].level = Level.values()[level]
                }
                adapter.notifyDataSetChanged()
                button.isEnabled = true
                button.isClickable = true
            }
        }
    }
}
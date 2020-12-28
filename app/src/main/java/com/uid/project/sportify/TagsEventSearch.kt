package com.uid.project.sportify

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uid.project.sportify.adapters.DeletableTagsListAdapter
import com.uid.project.sportify.adapters.TagsSearchListAdapter
import com.uid.project.sportify.models.Registry

class TagsEventSearch:AppCompatActivity() {

    private lateinit var tagsListAdapter: DeletableTagsListAdapter
    private lateinit var tagsSearchListAdapter: TagsSearchListAdapter
    val list:ArrayList<String> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_tags_event)
        val addTagButton = findViewById<ImageButton>(R.id.addTagButton)
        val enterTagsTextView = findViewById<EditText>(R.id.enterTagsTextView)
        val tagsEntered = findViewById<TextView>(R.id.textView24)
        addTagButton.setOnClickListener {
             var data= enterTagsTextView.text.toString() + ""
            list.add(data.toString())
            Log.v("tagss","in tag")
            Log.v("tagss",data)
            val builder = StringBuilder()
            for (details in list) {
                builder.append(details + " ,")
            }
            tagsEntered.text=builder.toString()
        }

        if(list.isEmpty())
            Log.v("empty","yes")
        for(value in list)
            Log.v("valuee",value)


        val doneTagButton= findViewById<Button>(R.id.doneTagButton)
        doneTagButton.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View?) {

                val intent = Intent(this@TagsEventSearch, SearchEventActivity::class.java)
                //val intent=Intent()
                intent.putStringArrayListExtra("list",list)
                // intent.putExtra("sportLevel",sportLevel)
                setResult(Activity.RESULT_OK, intent);
                // startActivity(intent)
                finish()

            }
        })

    }

    fun printList(){

        for(value in list.iterator())
            Log.v("valuee",value)
    }



}
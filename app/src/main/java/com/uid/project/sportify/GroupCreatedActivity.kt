package com.uid.project.sportify

import android.net.Uri
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uid.project.sportify.adapters.TagsListAdapter
import com.uid.project.sportify.models.Group
import de.hdodenhof.circleimageview.CircleImageView
import org.w3c.dom.Text

class GroupCreatedActivity : AppCompatActivity() {
    private lateinit var group: Group
    private lateinit var tagsListAdapter: TagsListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_group_created)


        group = intent.getSerializableExtra("group") as Group

        var groupLocation = findViewById<TextView>(R.id.textView24)
        groupLocation.text = group.location

        var groupName = findViewById<TextView>(R.id.textView25)
        groupName.text = group.name

        var description = findViewById<TextView>(R.id.textView26)
        description.text = group.description

        val image = findViewById<CircleImageView>(R.id.imageViewGroupCreated)
        if (group.imageUri == null){
            image.setImageResource(group.image)
        }else {
            image.setImageURI(Uri.parse(group.imageUri))
        }

        val layoutManager2 = LinearLayoutManager(
            this@GroupCreatedActivity,
            LinearLayoutManager.VERTICAL,
            false
        )
        val tagsRecyclerView = findViewById<RecyclerView>(R.id.customizeTagsRecyclerView)
        tagsRecyclerView.layoutManager = layoutManager2
        tagsListAdapter = TagsListAdapter(group.tags)
        tagsRecyclerView.adapter = tagsListAdapter
    }

    override fun onBackPressed() {
       finish()
    }
}

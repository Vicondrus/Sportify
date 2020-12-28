package com.uid.project.sportify

import android.app.Activity
import android.content.Intent
import android.graphics.BlendMode
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.SearchView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText
import com.huawei.hms.maps.HuaweiMap
import com.huawei.hms.maps.SupportMapFragment
import com.huawei.hms.maps.model.PolygonOptions
import com.uid.project.sportify.adapters.DeletableTagsListAdapter
import com.uid.project.sportify.adapters.TagsSearchListAdapter
import com.uid.project.sportify.models.Group
import com.uid.project.sportify.models.Neighborhood
import com.uid.project.sportify.models.Registry

class CreateGroupActivity : AppCompatActivity(), com.huawei.hms.maps.OnMapReadyCallback {
    private lateinit var mMap: HuaweiMap
    lateinit var location : TextView
    private lateinit var tagsListAdapter: DeletableTagsListAdapter
    private lateinit var tagsSearchListAdapter: TagsSearchListAdapter
    private val pictureSelectionId = 2
    private lateinit var groupName: TextInputEditText
    private lateinit var groupDescription: TextInputEditText
    private lateinit var groupImage: ImageView
    private lateinit var finishButton : Button
    private lateinit var group: Group
    private var uri: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_create_group)

        finishButton = findViewById(R.id.button4)
        finishButton.isEnabled = false

        groupName = findViewById(R.id.name)
        groupDescription = findViewById(R.id.description)
        location = findViewById(R.id.textView5)
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.mapFragment) as? SupportMapFragment
        mapFragment?.getMapAsync(this)


        val layoutManager2 = LinearLayoutManager(
            this@CreateGroupActivity,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        val layoutManager3 = LinearLayoutManager(
            this@CreateGroupActivity,
            LinearLayoutManager.VERTICAL,
            false
        )

        val tagsRecyclerView = findViewById<RecyclerView>(R.id.customizeTagsRecyclerViewGroup)
        tagsRecyclerView.layoutManager = layoutManager2


        var tagList : MutableList<String> = ArrayList()
        tagsListAdapter = DeletableTagsListAdapter(tagList, this@CreateGroupActivity)
        tagsRecyclerView.adapter = tagsListAdapter
        tagsRecyclerView.backgroundTintBlendMode = BlendMode.CLEAR

        val customizeGroupTagsSearchView =
            findViewById<SearchView>(R.id.customizeGroupTagsSearchView)
        val searchTagsRecyclerView = findViewById<RecyclerView>(R.id.searchTagsRecyclerView1)
        searchTagsRecyclerView.layoutManager = layoutManager3
        searchTagsRecyclerView.backgroundTintBlendMode = BlendMode.LIGHTEN

        tagsSearchListAdapter = TagsSearchListAdapter(
            Registry.setOfTags.toMutableList(),
            tagsListAdapter,
            customizeGroupTagsSearchView,
            this@CreateGroupActivity
        )
        searchTagsRecyclerView.adapter = tagsSearchListAdapter

        customizeGroupTagsSearchView.setOnQueryTextListener(object :
            SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                tagsSearchListAdapter.filter.filter(newText)
                return false
            }

        })

        groupImage = findViewById(R.id.createGroupImage)
        val changeEventPictureButton = findViewById<Button>(R.id.createGroupAddImgBtn)
        changeEventPictureButton.setOnClickListener {
            val pickPhoto = Intent(
                Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            )
            startActivityForResult(pickPhoto, pictureSelectionId)
        }

    }

    fun goToFriends(view: View){
        val intent = Intent(this, FriendListActivity::class.java)
        intent.putExtra("activityName", "Start a new group")
        intent.putExtra("eventName", "Add a few friends")
        startActivityForResult(intent, 10011)

    }

    fun goToMap(view: View){
        val intent = Intent(this, MapViewDemoActivity::class.java)
        startActivityForResult(intent, 1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                val result = data?.getStringExtra("chosenLocation")
                if (result != null) {
                    location.text = result
                }
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
        if (requestCode == 10011) {
            if (resultCode == Activity.RESULT_OK) {
                findViewById<TextView>(R.id.textView9).text = "Friends added."
                return
            }
        }
        if (requestCode == pictureSelectionId && resultCode == Activity.RESULT_OK) {
                val selectedImage: Uri = data!!.data as Uri
                uri = selectedImage.toString()
                groupImage.setImageURI(Uri.parse(selectedImage.toString()))
        }

        mMap.clear()
        Registry.listOfNeighborhoods.forEach { neighborhood: Neighborhood ->
            var color = ContextCompat.getColor(this@CreateGroupActivity, R.color.grey_sportify)
            if (neighborhood.name == location.text){
                color = ContextCompat.getColor(this@CreateGroupActivity, R.color.purple_sportify)
            }
            mMap!!.addPolygon(
                PolygonOptions()
                    .clickable(true)
                    .addAll(neighborhood.coords)
                    .strokeColor(color)
            ).tag = neighborhood.name
        }

        if (groupName.text.toString().isNotEmpty()  && location.text.isNotEmpty()) finishButton.isEnabled=true
    }

    override fun onMapReady(map: HuaweiMap) {
        mMap = map
    }


    override fun onBackPressed() {
        finish()
    }

    fun createGroupFinish(view : View){
        group = Group(groupName.text.toString(), groupDescription.text.toString(),  location.text.toString(), tagsListAdapter.dataSet, R.drawable.event_picture, uri )

        Registry.listOfGroups.add(group)
        val intent = Intent(this, GroupCreatedActivity::class.java)
        intent.putExtra("group", group)
        startActivity(intent)
        finish()
    }
}
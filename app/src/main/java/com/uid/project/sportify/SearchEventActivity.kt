package com.uid.project.sportify

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.uid.project.sportify.models.Level

class SearchEventActivity: AppCompatActivity() {

    var hashMapFinal : HashMap<String, String>
            = HashMap<String, String> ()

    var listTagsFinal : ArrayList<String>
            = ArrayList<String> ()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_event)

        supportActionBar?.hide()
        val sportSelection=findViewById<ImageButton>(R.id.imageButton4)
        val textViewSportSelection=findViewById<TextView>(R.id.textViewSportSelection)
        val btnContinue=findViewById<Button>(R.id.button4)
        sportSelection.setOnClickListener {

            val intent = Intent(this@SearchEventActivity, SportSelectionEvent::class.java)
            startActivityForResult(intent, 1)
        }



        btnContinue.setOnClickListener{

            val intent = Intent(this@SearchEventActivity, EventResultActivity::class.java)
            startActivity(intent)
        }
/*        val hashMap = this.intent.getSerializableExtra("hashMap") as HashMap<Int, Int>
        for ((k, v) in hashMap) {
            Log.v("hashmap","$k = $v")
          //  Level.values()[level]
            if(k==1){
            hashMapFinal.put("tennis", Level.values()[v].toString())}
        }

        for ((k1, v1) in hashMapFinal) {
            Log.v("hashMapFinal","$k1 = $v1")
            textViewSportSelection.setText("$k1 = $v1")
            hashMapFinal.get("tennis")?.let { Log.v("hashMF", it) }

        }*/

        val relatedTagsButton=findViewById<ImageButton>(R.id.relatedTagsButton)
        relatedTagsButton.setOnClickListener {

            val intent = Intent(this@SearchEventActivity, TagsEventSearch::class.java)
            startActivityForResult(intent, 2)
        }
    }
    override fun onBackPressed() {
        finish()
    }

   override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode != Activity.RESULT_OK) return

            if(requestCode==1) {

                val hashMap = data?.getSerializableExtra("hashMap") as HashMap<Int, Int>
                for ((k, v) in hashMap) {
                    Log.v("hashmap", "$k = $v")
                    //  Level.values()[level]
                    if (k == 1) {
                        hashMapFinal.put("tennis", Level.values()[v].toString())
                    } else if (k == 2) {

                        hashMapFinal.put("basketball", Level.values()[v].toString())
                    } else if (k == 3) {

                        hashMapFinal.put("swimming", Level.values()[v].toString())
                    }
                    else if (k == 4) {

                        hashMapFinal.put("bike", Level.values()[v].toString())
                    }
                    else if (k == 5) {

                        hashMapFinal.put("baseball", Level.values()[v].toString())
                    }
                    else if (k == 6) {

                        hashMapFinal.put("walking", Level.values()[v].toString())
                    }
                    else if (k == 7) {

                        hashMapFinal.put("football", Level.values()[v].toString())
                    }
                    else if (k == 8) {

                        hashMapFinal.put("yoga", Level.values()[v].toString())
                    }
                    else if (k == 9) {

                        hashMapFinal.put("stretching", Level.values()[v].toString())
                    }
                }


                printHashMap()
            }
            // Other result codes
          else if (requestCode==2) {
                Log.v("in2","hey")
                val list = data?.getStringArrayListExtra("list")
                if (list != null) {
                    for(a in list)
                        Log.v("listtt",a) //TODO :implement get list of tags +textview under tags
                }
            }

    }

    fun printHashMap(){
        
        val textViewSportSelection=findViewById<TextView>(R.id.textViewSportSelection)
        for ((k, v) in hashMapFinal) {

            Log.v("hashmapF", "$k = $v")
           // textViewSportSelection.text = hashMapFinal.get("tennis").toString()
        }

        val builder = StringBuilder()
        for (details in hashMapFinal) {
            builder.append(details.key +" "+ details.value.toLowerCase() + ",")
        }
        textViewSportSelection.text = builder.toString()
    }


}
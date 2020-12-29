package com.uid.project.sportify

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class SportSelectionEvent : AppCompatActivity() {
    var hashMap: HashMap<Int, Int> = HashMap<Int, Int>() //keep position,level
    private val levelSelectionId = 2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sport_options_event_search)


        val button1 = findViewById<ImageButton>(R.id.imageButton1)
        val button2 = findViewById<ImageButton>(R.id.imageButton2) //must modify id
        val button3 = findViewById<ImageButton>(R.id.relatedTagsButton) //must modify id
        val button4 = findViewById<ImageButton>(R.id.imageButton4)
        val button5 = findViewById<ImageButton>(R.id.imageButton5)
        val button6 = findViewById<ImageButton>(R.id.imageButton6)
        val button7 = findViewById<ImageButton>(R.id.imageButton7)
        val button8 = findViewById<ImageButton>(R.id.imageButton8)
        val button9 = findViewById<ImageButton>(R.id.imageButton9)

//1= tennis,2= basketball,3=swimming
// is clicked(1,2,3).. bool for each button
        var isClicked1 = true
        var isClicked2 = true
        var isClicked3 = true
        var isClicked4 = true
        var isClicked5 = true
        var isClicked6 = true
        var isClicked7 = true
        var isClicked8 = true
        var isClicked9 = true


        val list = arrayListOf<Int>()
        supportActionBar?.hide()
        button1.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View?) {
                if (isClicked1) {
                    button1.setBackgroundDrawable(resources.getDrawable(R.drawable.buttonroundclicked))

                    isClicked1 = false
                    val context = v?.context
                    val intent = Intent(context, LevelPopupActivity::class.java)
                    list.add(1) //must be distinct
                    if (context != null) {
                        //context.startActivity(intent)
                        intent.putExtra("sportPosition", 1)
                        startActivityForResult(intent, levelSelectionId)


                    }

                } else {
                    button1.setBackgroundDrawable(resources.getDrawable(R.drawable.buttonround))
                    list.remove(1)
                    hashMap.remove(1)
                    isClicked1 = true
                }

            }
        })
        button2.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View?) {
                if (isClicked2) {
                    button2.setBackgroundDrawable(resources.getDrawable(R.drawable.buttonroundclicked))
                    val context = v?.context
                    val intent = Intent(context, LevelPopupActivity::class.java)
                    list.add(2)
                    if (context != null) {
                        intent.putExtra("sportPosition", 2)
                        startActivityForResult(intent, levelSelectionId)
                    }
                    isClicked2 = false

                } else {
                    button2.setBackgroundDrawable(resources.getDrawable(R.drawable.buttonround))
                    list.remove(2)
                    hashMap.remove(2)
                    isClicked2 = true
                }

            }
        })
        // button.setOnClickListener { button.setBackgroundDrawable(resources.getDrawable(R.drawable.buttonroundclicked)) }
        button3.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View?) {
                if (isClicked3) {
                    button3.setBackgroundDrawable(resources.getDrawable(R.drawable.buttonroundclicked))
                    val context = v?.context
                    val intent = Intent(context, LevelPopupActivity::class.java)
                    if (context != null) {
                        //  context.startActivity(intent)
                        intent.putExtra("sportPosition", 3)
                        startActivityForResult(intent, levelSelectionId)
                    }
                    isClicked3 = false
                    list.add(3)
                } else {
                    button3.setBackgroundDrawable(resources.getDrawable(R.drawable.buttonround))

                    isClicked3 = true
                }

            }
        })
        button4.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View?) {
                if (isClicked4) {
                    button4.setBackgroundDrawable(resources.getDrawable(R.drawable.buttonroundclicked))
                    val context = v?.context
                    val intent = Intent(context, LevelPopupActivity::class.java)
                    if (context != null) {
                        intent.putExtra("sportPosition", 4)
                        startActivityForResult(intent, levelSelectionId)
                    }
                    isClicked4 = false
                } else {
                    button4.setBackgroundDrawable(resources.getDrawable(R.drawable.buttonround))

                    isClicked4 = true
                }

            }
        })
        button5.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View?) {
                if (isClicked5) {
                    button5.setBackgroundDrawable(resources.getDrawable(R.drawable.buttonroundclicked))
                    val context = v?.context
                    val intent = Intent(context, LevelPopupActivity::class.java)
                    if (context != null) {
                        intent.putExtra("sportPosition", 5)
                        startActivityForResult(intent, levelSelectionId)
                    }
                    isClicked5 = false
                } else {
                    button5.setBackgroundDrawable(resources.getDrawable(R.drawable.buttonround))

                    isClicked5 = true
                }

            }
        })
        button6.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View?) {
                if (isClicked6) {
                    button6.setBackgroundDrawable(resources.getDrawable(R.drawable.buttonroundclicked))
                    val context = v?.context
                    val intent = Intent(context, LevelPopupActivity::class.java)
                    if (context != null) {
                        intent.putExtra("sportPosition", 6)
                        startActivityForResult(intent, levelSelectionId)
                    }
                    isClicked6 = false
                } else {
                    button6.setBackgroundDrawable(resources.getDrawable(R.drawable.buttonround))

                    isClicked6 = true
                }

            }
        })


        button7.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View?) {
                if (isClicked7) {
                    button7.setBackgroundDrawable(resources.getDrawable(R.drawable.buttonroundclicked))
                    val context = v?.context
                    val intent = Intent(context, LevelPopupActivity::class.java)
                    if (context != null) {
                        intent.putExtra("sportPosition", 7)
                        startActivityForResult(intent, levelSelectionId)
                    }
                    isClicked7 = false
                } else {
                    button7.setBackgroundDrawable(resources.getDrawable(R.drawable.buttonround))

                    isClicked7 = true
                }

            }
        })
        button8.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View?) {
                if (isClicked8) {
                    button8.setBackgroundDrawable(resources.getDrawable(R.drawable.buttonroundclicked))
                    val context = v?.context
                    val intent = Intent(context, LevelPopupActivity::class.java)
                    if (context != null) {
                        intent.putExtra("sportPosition", 8)
                        startActivityForResult(intent, levelSelectionId)
                    }
                    isClicked8 = false
                } else {
                    button8.setBackgroundDrawable(resources.getDrawable(R.drawable.buttonround))

                    isClicked8 = true
                }

            }
        })
        button9.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View?) {
                if (isClicked9) {
                    button9.setBackgroundDrawable(resources.getDrawable(R.drawable.buttonroundclicked))
                    val context = v?.context
                    val intent = Intent(context, LevelPopupActivity::class.java)
                    if (context != null) {
                        intent.putExtra("sportPosition", 9)
                        startActivityForResult(intent, levelSelectionId)
                    }
                    isClicked9 = false
                } else {
                    button9.setBackgroundDrawable(resources.getDrawable(R.drawable.buttonround))

                    isClicked9 = true
                }

            }
        })


        //sport level buttons

        val button = findViewById<Button>(R.id.btnDone)
        button.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View?) {

                val intent = Intent(this@SportSelectionEvent, SearchEventActivity::class.java)
                //val intent=Intent()
                intent.putExtra("hashMap", hashMap)
                // intent.putExtra("sportLevel",sportLevel)
                setResult(Activity.RESULT_OK, intent)
                // startActivity(intent)
                finish()

            }
        })
    }

    override fun onActivityResult(
            requestCode: Int,
            resultCode: Int,
            data: Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == levelSelectionId) {
            if (resultCode == Activity.RESULT_OK) {
                val level = data!!.getIntExtra("selectedLevel", -1)
                val position = data.getIntExtra("sportPosition", -1)
                Log.v("sportpos", position.toString())
                Log.v("selectedLevel", level.toString()) //+1
                hashMap.put(position, level)
            }
        }
    }

}
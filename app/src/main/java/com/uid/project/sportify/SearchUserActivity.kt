package com.uid.project.sportify

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import com.uid.project.sportify.adapters.UserResultAdapter

class SearchUserActivity : AppCompatActivity() {
    private lateinit var userResultAdapter: UserResultAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        var sportsSelected = mutableListOf<String>()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_search)


        val button1 = findViewById<ImageButton>(R.id.imageButton1)//basket
        val button2 = findViewById<ImageButton>(R.id.imageButton2) //tennis
        val button3 = findViewById<ImageButton>(R.id.relatedTagsButton) //swim
        val button4 = findViewById<ImageButton>(R.id.imageButton4) //bike
        val button5 = findViewById<ImageButton>(R.id.imageButton5) //baseball
        val button6 = findViewById<ImageButton>(R.id.imageButton6) //walk
        val button7 = findViewById<ImageButton>(R.id.imageButton7) //football
        val button8 = findViewById<ImageButton>(R.id.imageButton8) //yogaplace.jpg
        val button9 = findViewById<ImageButton>(R.id.imageButton9)//stretching
        val searchUserTxt = findViewById<EditText>(R.id.searchUserTxt)


        //ana maria
        var isClicked1 = true //is clicked(1,2,3).. bool for each button
        var isClicked2 = true
        var isClicked3 = true
        var isClicked4 = true
        var isClicked5 = true
        var isClicked6 = true
        var isClicked7 = true
        var isClicked8 = true
        var isClicked9 = true

        supportActionBar?.hide()
        button1.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View?) {
                if (isClicked1) {
                    button1.setBackgroundDrawable(resources.getDrawable(R.drawable.buttonroundclicked))

                    isClicked1 = false
                    val context = v?.context
                    val intent = Intent(context, LevelPopupActivity::class.java)
                    sportsSelected.add("Tennis")
                    Log.v("sportSel","Tennis")
                    if (context != null) {
                        context.startActivity(intent)
                    }

                } else {
                    button1.setBackgroundDrawable(resources.getDrawable(R.drawable.buttonround))
                    sportsSelected.remove("Tennis")
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
                    sportsSelected.add("Basketball")
                    Log.v("sportSel","Basketball")
                    if (context != null) {
                        context.startActivity(intent)
                    }
                    isClicked2 = false
                } else {
                    button2.setBackgroundDrawable(resources.getDrawable(R.drawable.buttonround))
                    sportsSelected.remove("Basketball")
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
                        context.startActivity(intent)
                    }
                    isClicked3 = false
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
                        context.startActivity(intent)
                    }
                    sportsSelected.add("Bike")
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
                        context.startActivity(intent)
                    }
                    sportsSelected.add("Baseball")
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
                        context.startActivity(intent)
                    }
                    sportsSelected.add("Walk")
                    isClicked6 = false
                } else {
                    button6.setBackgroundDrawable(resources.getDrawable(R.drawable.buttonround))

                    isClicked6 = true
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
                        context.startActivity(intent)
                    }
                    sportsSelected.add("Yoga")
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
                        context.startActivity(intent)
                    }
                    sportsSelected.add("Stretching")
                    isClicked9 = false
                } else {
                    button9.setBackgroundDrawable(resources.getDrawable(R.drawable.buttonround))

                    isClicked9 = true
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
                        context.startActivity(intent)
                    }
                    sportsSelected.add("Football")
                    isClicked7 = false
                } else {
                    button7.setBackgroundDrawable(resources.getDrawable(R.drawable.buttonround))

                    isClicked7 = true
                }

            }
        })

        for (sport in sportsSelected)
            Log.v("ssss", sport.toString())
        //sport level buttons

        val button = findViewById<Button>(R.id.btnDone)
        button.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View?) {
                val userName = searchUserTxt.text.toString()
                if(userName.trim().length<0){

                    Toast.makeText(applicationContext, "Please enter the users name! ", Toast.LENGTH_SHORT).show()

                }
                val intent = Intent(this@SearchUserActivity, UserResultActivity::class.java)
                intent.putExtra("userSearch", userName)
                intent.putStringArrayListExtra("sportsSelected", ArrayList(sportsSelected))
                Log.v("userSearch", userName)
                startActivity(intent)

            }
        })
    }


    /* private fun addDataSet(){

         val data= DataSource.createDataSet()
         userResultAdapter.submitList(data)

     }        private fun initRecyclerView(){
         val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
         recyclerView.layoutManager= LinearLayoutManager(this@SearchUserActivity!!)
         userResultAdapter= UserResultAdapter()
         recyclerView.adapter=userResultAdapter
     }*/

}






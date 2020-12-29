package com.uid.project.sportify
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

import com.uid.project.sportify.adapters.UserResultAdapter

class SearchUserActivity: AppCompatActivity() {
private lateinit var userResultAdapter: UserResultAdapter





    override fun onCreate(savedInstanceState: Bundle?) {
        var sportsSelected= mutableListOf<String>()
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
        val searchUserTxt=findViewById<EditText>(R.id.searchUserTxt)


       //ana maria
        var isClicked = true; //is clicked(1,2,3).. bool for each button

        supportActionBar?.hide()
        button1.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View?) {
                if (isClicked) {
                    button1.setBackgroundDrawable(resources.getDrawable(R.drawable.buttonroundclicked))

                    isClicked = false
                    val context= v?.context
                    val intent= Intent(context,LevelPopupActivity::class.java)
                    sportsSelected.add("Basketball")
                    if (context != null) {
                        context.startActivity(intent)
                    }

                } else {
                    button1.setBackgroundDrawable(resources.getDrawable(R.drawable.buttonround))

                    isClicked = true
                }

            }
        })
        button2.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View?) {
                if (isClicked) {
                    button2.setBackgroundDrawable(resources.getDrawable(R.drawable.buttonroundclicked))
                    val context= v?.context
                    val intent= Intent(context,LevelPopupActivity::class.java)
                    sportsSelected.add("Tennis")
                    if (context != null) {
                        context.startActivity(intent)
                    }
                    isClicked = false
                } else {
                    button2.setBackgroundDrawable(resources.getDrawable(R.drawable.buttonround))

                    isClicked = true
                }

            }
        })
        // button.setOnClickListener { button.setBackgroundDrawable(resources.getDrawable(R.drawable.buttonroundclicked)) }
        button3.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View?) {
                if (isClicked) {
                    button3.setBackgroundDrawable(resources.getDrawable(R.drawable.buttonroundclicked))
                    val context= v?.context
                    val intent= Intent(context,LevelPopupActivity::class.java)
                    if (context != null) {
                        context.startActivity(intent)
                    }
                    isClicked = false
                } else {
                    button3.setBackgroundDrawable(resources.getDrawable(R.drawable.buttonround))

                    isClicked = true
                }

            }
        })
        button4.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View?) {
                if (isClicked) {
                    button4.setBackgroundDrawable(resources.getDrawable(R.drawable.buttonroundclicked))
                    val context= v?.context
                    val intent= Intent(context,LevelPopupActivity::class.java)
                    if (context != null) {
                        context.startActivity(intent)
                    }
                    sportsSelected.add("Bike")
                    isClicked = false
                } else {
                    button4.setBackgroundDrawable(resources.getDrawable(R.drawable.buttonround))

                    isClicked = true
                }

            }
        })
        button5.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View?) {
                if (isClicked) {
                    button5.setBackgroundDrawable(resources.getDrawable(R.drawable.buttonroundclicked))
                    val context= v?.context
                    val intent= Intent(context,LevelPopupActivity::class.java)
                    if (context != null) {
                        context.startActivity(intent)
                    }
                    sportsSelected.add("Baseball")
                    isClicked = false
                } else {
                    button5.setBackgroundDrawable(resources.getDrawable(R.drawable.buttonround))

                    isClicked = true
                }

            }
        })
        button6.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View?) {
                if (isClicked) {
                    button6.setBackgroundDrawable(resources.getDrawable(R.drawable.buttonroundclicked))
                    val context= v?.context
                    val intent= Intent(context,LevelPopupActivity::class.java)
                    if (context != null) {
                        context.startActivity(intent)
                    }
                    sportsSelected.add("Walk")
                    isClicked = false
                } else {
                    button6.setBackgroundDrawable(resources.getDrawable(R.drawable.buttonround))

                    isClicked = true
                }

            }
        })
        button8.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View?) {
                if (isClicked) {
                    button8.setBackgroundDrawable(resources.getDrawable(R.drawable.buttonroundclicked))
                    val context= v?.context
                    val intent= Intent(context,LevelPopupActivity::class.java)
                    if (context != null) {
                        context.startActivity(intent)
                    }
                    sportsSelected.add("Yoga")
                    isClicked = false
                } else {
                    button8.setBackgroundDrawable(resources.getDrawable(R.drawable.buttonround))

                    isClicked = true
                }

            }
        })
        button9.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View?) {
                if (isClicked) {
                    button9.setBackgroundDrawable(resources.getDrawable(R.drawable.buttonroundclicked))
                    val context= v?.context
                    val intent= Intent(context,LevelPopupActivity::class.java)
                    if (context != null) {
                        context.startActivity(intent)
                    }
                    sportsSelected.add("Stretching")
                    isClicked = false
                } else {
                    button9.setBackgroundDrawable(resources.getDrawable(R.drawable.buttonround))

                    isClicked = true
                }

            }
        })
        button7.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View?) {
                if (isClicked) {
                    button7.setBackgroundDrawable(resources.getDrawable(R.drawable.buttonroundclicked))
                    val context= v?.context
                    val intent= Intent(context,LevelPopupActivity::class.java)
                    if (context != null) {
                        context.startActivity(intent)
                    }
                    sportsSelected.add("Football")
                    isClicked = false
                } else {
                    button7.setBackgroundDrawable(resources.getDrawable(R.drawable.buttonround))

                    isClicked = true
                }

            }
        })

        for (sport in sportsSelected)
            Log.v("ssss",sport.toString())
        //sport level buttons

        val button= findViewById<Button>(R.id.btnDone)
        button.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View?) {
                val userName=searchUserTxt.text.toString()
                val intent = Intent(this@SearchUserActivity, UserResultActivity::class.java)
                intent.putExtra("userSearch",userName)
                //intent.putStringArrayListExtra("sportsSelected",sportsSelected)
                Log.v("userSearch",userName)
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






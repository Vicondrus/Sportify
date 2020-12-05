package com.example.sportify

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sportify.adapter.UserResultAdapter

class SearchUserActivity: AppCompatActivity() {
private lateinit var userResultAdapter: UserResultAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val button1 = findViewById<ImageButton>(R.id.imageButton1)
        val button2 = findViewById<ImageButton>(R.id.imageButton2)
        val button3 = findViewById<ImageButton>(R.id.imageButton3)
        val button4 = findViewById<ImageButton>(R.id.imageButton4)
        val button5 = findViewById<ImageButton>(R.id.imageButton5)
        val button6 = findViewById<ImageButton>(R.id.imageButton6)
        val button7 = findViewById<ImageButton>(R.id.imageButton7)
        val button8 = findViewById<ImageButton>(R.id.imageButton8)
        val button9 = findViewById<ImageButton>(R.id.imageButton9)


        var isClicked = true; //is clicked(1,2,3).. bool for each button

        supportActionBar?.hide()
        button1.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View?) {
                if (isClicked) {
                    button1.setBackgroundDrawable(resources.getDrawable(R.drawable.buttonroundclicked))

                    isClicked = false
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

                    isClicked = false
                } else {
                    button7.setBackgroundDrawable(resources.getDrawable(R.drawable.buttonround))

                    isClicked = true
                }

            }
        })


        //sport level buttons
        val button10 = findViewById<ImageButton>(R.id.imageButton10)
        val button11 = findViewById<ImageButton>(R.id.imageButton12)
        val button12 = findViewById<ImageButton>(R.id.imageButton13)
        val button13 = findViewById<ImageButton>(R.id.imageButton14)
        var isClicked2=true
        var isClicked3=true
        var isClicked4=true
        var isClicked5=true

        button10.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View?) {
                if (isClicked2) {
                    button10.setBackgroundDrawable(resources.getDrawable(R.drawable.sportlevelbuttonclicked))

                    isClicked2 = false
                } else {
                    button10.setBackgroundDrawable(resources.getDrawable(R.drawable.sportlevelbutton))

                    isClicked2 = true
                }

            }
        })

        button11.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View?) {
                if (isClicked3) {
                    button11.setBackgroundDrawable(resources.getDrawable(R.drawable.sportlevelbuttonclicked))

                    isClicked3 = false
                } else {
                    button11.setBackgroundDrawable(resources.getDrawable(R.drawable.sportlevelbutton))

                    isClicked3 = true
                }

            }
        })

        button12.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View?) {
                if (isClicked4) {
                    button12.setBackgroundDrawable(resources.getDrawable(R.drawable.sportlevelbuttonclicked))

                    isClicked4 = false
                } else {
                    button12.setBackgroundDrawable(resources.getDrawable(R.drawable.sportlevelbutton))

                    isClicked4 = true
                }

            }
        })

        button13.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View?) {
                if (isClicked5) {
                    button13.setBackgroundDrawable(resources.getDrawable(R.drawable.sportlevelbuttonclicked))

                    isClicked5 = false
                } else {
                    button13.setBackgroundDrawable(resources.getDrawable(R.drawable.sportlevelbutton))

                    isClicked5 = true
                }

            }
        })
        val button= findViewById<Button>(R.id.btnDone)
        button.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View?) {

                val intent = Intent(this@SearchUserActivity, UserResultActivity::class.java)
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






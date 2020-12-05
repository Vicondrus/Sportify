package com.uid.project.sportify
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
import com.uid.project.sportify.UserResultActivity
import com.uid.project.sportify.R

import com.uid.project.sportify.adapters.UserResultAdapter

class SearchUserActivity: AppCompatActivity() {
private lateinit var userResultAdapter: UserResultAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_search)


        val button1 = findViewById<ImageButton>(R.id.imageButton1)
        val button2 = findViewById<ImageButton>(R.id.imageButton2) //must modify id
        val button3 = findViewById<ImageButton>(R.id.imageButton3) //must modify id
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
                    val context= v?.context
                    val intent= Intent(context,LevelPopupActivity::class.java)
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
                    isClicked = false
                } else {
                    button7.setBackgroundDrawable(resources.getDrawable(R.drawable.buttonround))

                    isClicked = true
                }

            }
        })


        //sport level buttons

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






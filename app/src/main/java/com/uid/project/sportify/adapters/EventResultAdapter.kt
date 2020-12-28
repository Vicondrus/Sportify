package com.uid.project.sportify.adapters


import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.uid.project.sportify.ProfilePageActivity
import com.uid.project.sportify.R
import com.uid.project.sportify.models.EventResult


class EventResultAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var items: List<EventResult> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return EventViewHolder(
                LayoutInflater.from(parent.context).inflate(
                        R.layout.event_result_list_item,
                        parent,
                        false
                )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){

            is EventViewHolder -> {
                holder.bind(items.get(position))
            }
        }
    }

    //how many items inside list
    override fun getItemCount(): Int {
        return items.size
    }

    fun submitList(eventResultList: List<EventResult>){

        items=eventResultList
    }

    class EventViewHolder constructor(
            itemView: View
    ): RecyclerView.ViewHolder(itemView){

        val txtDateEvent= itemView.findViewById<TextView>(R.id.txtDateEvent)
        val txtEventName = itemView.findViewById<TextView>(R.id.txtPlaceName)
        val txtNbOfPeople= itemView.findViewById<TextView>(R.id.nbOfPeopleTxt)
        val btnDetailsEvent=itemView.findViewById<TextView>(R.id.btnDetailsEvent)

        fun bind(eventResult: EventResult){


            btnDetailsEvent.setOnClickListener(object : View.OnClickListener {

                override fun onClick(v: View?) {
                    //call here the intent for user profile
                  //  val context= v?.context
                   // val intent= Intent(context,ProfilePageActivity::class.java)
                    //if (context != null) {
                      //  context.startActivity(intent)
                    //}

                //TODO:event detail page here
                }
            })
            txtDateEvent.setText(eventResult.date)
            txtEventName.setText(eventResult.name)
            txtNbOfPeople.setText(eventResult.nbOfPeople)

        }



    }
}
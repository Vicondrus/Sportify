package com.uid.project.sportify.adapters


import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.uid.project.sportify.EventPageUserActivity
import com.uid.project.sportify.R
import com.uid.project.sportify.models.Event


class EventResultAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var items: List<Event> = ArrayList()

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
        when (holder) {

            is EventViewHolder -> {
                holder.bind(items.get(position))
            }
        }
    }

    //how many items inside list
    override fun getItemCount(): Int {
        return items.size
    }

    fun submitList(eventResultList: ArrayList<Event>) {

        items = eventResultList
    }

    class EventViewHolder constructor(
            itemView: View
    ) : RecyclerView.ViewHolder(itemView) {
        val txtLocation = itemView.findViewById<TextView>(R.id.locationEventTxt)
        val txtDateEvent = itemView.findViewById<TextView>(R.id.txtDateEvent)
        val txtEventName = itemView.findViewById<TextView>(R.id.txtPlaceName)
        val txtNbOfPeople = itemView.findViewById<TextView>(R.id.nbOfPeopleTxt)
        val btnDetailsEvent = itemView.findViewById<TextView>(R.id.btnDetailsEvent)
        val eventImage = itemView.findViewById<ImageView>(R.id.imgPlace)
        fun bind(eventResult: Event) {
            btnDetailsEvent.setOnClickListener(object : View.OnClickListener {

                override fun onClick(v: View?) {
                    //call here the intent for user profile
                    val context = v?.context
                    val intent = Intent(context, EventPageUserActivity::class.java)
                    intent.putExtra("event", eventResult)
                    if (context != null) {
                        context.startActivity(intent)
                    }


                }
            })

            /*btnDetailsEvent.setOnClickListener(object : View.OnClickListener {

                override fun onClick(v: View?) {

                    val intent = Intent(this@, EventResultActivity::class.java)
                    intent.putExtra("event", eventResult)

                  /*  val intent = Intent(this, EventPageUserActivity::class.java)

                   */
                }
            })*/

            txtDateEvent.text = eventResult.date.toString()
            txtEventName.text = eventResult.name
            txtNbOfPeople.text = eventResult.nbOfPeople.toString()
            txtLocation.text = eventResult.location.neighborhood.toString()
            eventImage.setImageResource(eventResult.image)

        }


    }
}
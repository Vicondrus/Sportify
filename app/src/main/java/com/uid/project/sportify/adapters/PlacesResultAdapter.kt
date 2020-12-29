package com.uid.project.sportify.adapters


import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.uid.project.sportify.BookPlaceActivity
import com.uid.project.sportify.R
import com.uid.project.sportify.models.PlaceResult


class PlacesResultAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var items: List<PlaceResult> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return PlaceViewHolder(
                LayoutInflater.from(parent.context).inflate(
                        R.layout.place_result_list_item,
                        parent,
                        false
                )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){

            is PlaceViewHolder -> {
                holder.bind(items.get(position))
            }
        }

    }





    //how many items inside list
    override fun getItemCount(): Int {
        return items.size
    }

    fun submitList(placeResultList: List<PlaceResult>){

        items=placeResultList
    }

    class PlaceViewHolder constructor(
            itemView: View
    ): RecyclerView.ViewHolder(itemView){

        val btnBookPlaceResult= itemView.findViewById<Button>(R.id.btnDetailsEvent)
        val place_image = itemView.findViewById<ImageView>(R.id.imgPlace)
        val place_description= itemView.findViewById<TextView>(R.id.txtDateEvent)
        val place_location=itemView.findViewById<TextView>(R.id.txtLocation)
        val place_name=itemView.findViewById<TextView>(R.id.txtPlaceName)
        val place_rating=itemView.findViewById<TextView>(R.id.txtRating)

        fun bind(placeResult: PlaceResult) {


            btnBookPlaceResult.setOnClickListener(object : View.OnClickListener {

                override fun onClick(v: View?) {
                    //call here the intent for user profile
                    val place = PlaceResult(placeResult.placeName, placeResult.placeImage, placeResult.placeDescription, placeResult.placeLocation, placeResult.placeRating, placeResult.placePrice, placeResult.placeUnavailableDates)


                    val context = v?.context
                    val intent = Intent(context, BookPlaceActivity::class.java)
                    intent.putExtra("place", place)

                    // intent.putExtras(toPass)
                    // intent.putExtra("description",placeResult.placeDescription)
                    if (context != null) {
                        context.startActivity(intent)
                    }


                }
            })

            place_description.setText(placeResult.placeDescription)
            place_location.setText(placeResult.placeLocation)
            place_name.setText(placeResult.placeName)
            place_rating.setText(placeResult.placeRating)
            val requestOptions = RequestOptions()
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)

            place_image.setImageResource(placeResult.placeImage)


        }

    }
}
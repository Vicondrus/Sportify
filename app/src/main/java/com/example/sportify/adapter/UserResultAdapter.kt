package com.example.sportify.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.sportify.R
import com.example.sportify.models.UserResult

class UserResultAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var items: List<UserResult> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

    return UserViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.user_results_list_item,parent,false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){

            is UserViewHolder ->{
                holder.bind(items.get(position))
            }
        }
    }

    //how many items inside list
    override fun getItemCount(): Int {
        return items.size
    }

    fun submitList(userResultList: List<UserResult>){

        items=userResultList
    }

    class UserViewHolder constructor(
        itemView: View
    ): RecyclerView.ViewHolder(itemView){
        val arrow_image= itemView.findViewById<ImageView>(R.id.imgArrow)
        val user_image = itemView.findViewById<ImageView>(R.id.imgProfile)
        val user_name= itemView.findViewById<TextView>(R.id.txtName)
        val user_sport_image=itemView.findViewById<ImageView>(R.id.imgUserSport)
        val user_sport_name=itemView.findViewById<TextView>(R.id.txtSportName)
        val user_sport_level=itemView.findViewById<TextView>(R.id.txtSportLevel)

    fun bind(userResult: UserResult){
        arrow_image.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View?) {
             //call here the intent for user profile


            }
        })
        user_sport_level.setText(userResult.userSportLevel)
        user_sport_name.setText(userResult.userSportName)
        user_name.setText(userResult.userName)
       val requestOptions=RequestOptions()
           .placeholder(R.drawable.ic_launcher_background)
           .error(R.drawable.ic_launcher_background)
        Glide.with(itemView.context)
            .applyDefaultRequestOptions(requestOptions)
            .load(userResult.userImage)
            .into(user_image)
        Glide.with(itemView.context)
            .applyDefaultRequestOptions(requestOptions)
            .load(userResult.userSportImage)
            .into(user_sport_image)
    }



    }
}
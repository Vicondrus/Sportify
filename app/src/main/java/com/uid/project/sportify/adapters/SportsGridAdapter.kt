package com.uid.project.sportify.adapters

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.uid.project.sportify.R
import com.uid.project.sportify.models.Sport

class SportsGridAdapter(var dataList: List<Sport>, private var activity: Context) : BaseAdapter() {
    override fun getCount(): Int {
        return dataList.size
    }

    override fun getItem(position: Int): Any {
        return dataList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = View.inflate(activity, R.layout.sport_selection_grid_item, null)

        val title = view.findViewById(R.id.sportGridItemTitleTextView) as TextView
        title.text = dataList[position].name

        val image = view.findViewById<ImageView>(R.id.sportGridItemImageView)

        if (dataList[position].isSelected){
            if (dataList[position].selectedImage > -1) {
                image.setImageResource(dataList[position].selectedImage)
            }
        }else{
            if (dataList[position].notSelectedImage > -1) {
                image.setImageResource(dataList[position].notSelectedImage)
            }
        }

        return view
    }
}
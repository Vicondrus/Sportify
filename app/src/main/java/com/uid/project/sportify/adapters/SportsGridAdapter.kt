package com.uid.project.sportify.adapters

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.uid.project.sportify.R
import com.uid.project.sportify.models.Activity
import com.uid.project.sportify.models.Sport

class SportsGridAdapter(private var dataList:List<Sport>, private var activity: Context) : BaseAdapter() {
    override fun getCount(): Int {
        return dataList.size
    }

    override fun getItem(position: Int): Any {
        return dataList.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = View.inflate(activity, R.layout.sport_selection_grid_item,null)

        val title = view.findViewById<TextView>(R.id.sportGridItemTitleTextView) as TextView


        title.text= dataList.get(position).toString()+"."


        return view
    }
}
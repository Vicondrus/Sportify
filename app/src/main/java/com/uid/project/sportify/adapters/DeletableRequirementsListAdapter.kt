package com.uid.project.sportify.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.uid.project.sportify.R
import com.uid.project.sportify.holders.DeletableItemViewHolder

class DeletableRequirementsListAdapter(
    private val dataSet: MutableList<String>,
    private val context: Context
) : RecyclerView.Adapter<DeletableItemViewHolder>() {
    var listener: ((String) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeletableItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return DeletableItemViewHolder(inflater, parent, R.color.purple_sportify)
    }

    override fun onBindViewHolder(holder: DeletableItemViewHolder, position: Int) {
        val tag: String = dataSet[position]
        holder.bind(tag)
        holder.setClickListener {
            dataSet.removeAt(position)
            notifyDataSetChanged()
            Toast.makeText(context, "Requirement deleted", Toast.LENGTH_SHORT).show()
        }
    }

    fun addToDataSet(item: String) {
        dataSet.add(item)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}
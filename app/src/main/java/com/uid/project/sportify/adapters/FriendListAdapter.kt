package com.uid.project.sportify.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.uid.project.sportify.holders.FriendItemViewHolder
import com.uid.project.sportify.models.Friend
import java.util.*
import kotlin.collections.ArrayList

class FriendListAdapter(
        private val dataSet: MutableList<Friend>,
        private val otherAdapter: RecentsListAdapter
) : RecyclerView.Adapter<FriendItemViewHolder>(), Filterable {

    var friendsFilterList = ArrayList<Friend>()

    init {
        friendsFilterList = ArrayList(dataSet)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return FriendItemViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: FriendItemViewHolder, position: Int) {
        val friend: Friend = friendsFilterList[position]
        holder.bind(friend)
        holder.sendButton?.setOnClickListener {
            friend.isSent = true
            notifyDataSetChanged()
            otherAdapter.notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return friendsFilterList.size
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                friendsFilterList = if (charSearch.isEmpty()) {
                    ArrayList(dataSet)
                } else {
                    val resultList = ArrayList<Friend>()
                    for (row in dataSet) {
                        if (row.name.toLowerCase(Locale.ROOT)
                                        .contains(charSearch.toLowerCase(Locale.ROOT))
                        ) {
                            resultList.add(row)
                        }
                    }
                    resultList
                }
                val filterResults = FilterResults()
                filterResults.values = friendsFilterList
                return filterResults
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                friendsFilterList = results?.values as ArrayList<Friend>
                notifyDataSetChanged()
            }
        }
    }
}
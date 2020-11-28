package com.uid.project.sportify.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.uid.project.sportify.R
import com.uid.project.sportify.holders.SimpleItemViewHolder
import com.uid.project.sportify.models.Registry
import java.util.*
import kotlin.collections.ArrayList

class TagsSearchListAdapter(
        private var dataList: MutableList<String>,
        private var otherAdapter: DeletableTagsListAdapter,
        private var searcher: SearchView,
        private var context: Context
) : RecyclerView.Adapter<SimpleItemViewHolder>(), Filterable {

    var tagsFilterList = ArrayList<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return SimpleItemViewHolder(inflater, parent, R.color.dark_tone_sportify)
    }

    override fun onBindViewHolder(holder: SimpleItemViewHolder, position: Int) {
        val tag: String = tagsFilterList[position]
        holder.bind(tag)

        holder.title?.setOnClickListener {
            //Registry.user1Manager.tags.add(tag)
            dataList.add(tag)
            Registry.setOfTags.add(tag)
            tagsFilterList.clear()
            notifyDataSetChanged()
            otherAdapter.addToDataSet(tag)
            otherAdapter.notifyDataSetChanged()
            searcher.setQuery("", false)

            Toast.makeText(context, "Tag added successfully", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return tagsFilterList.size
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                if (charSearch.isEmpty()) {
                    tagsFilterList.clear()
                } else {
                    val resultList = ArrayList<String>()
                    resultList.add(charSearch)
                    for (row in dataList) {
                        if (row.toLowerCase(Locale.ROOT)
                                        .contains(charSearch.toLowerCase(Locale.ROOT))
                        ) {
                            resultList.add(row)
                        }
                    }
                    tagsFilterList = resultList
                }
                val filterResults = FilterResults()
                filterResults.values = tagsFilterList
                return filterResults
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                tagsFilterList = results?.values as ArrayList<String>
                notifyDataSetChanged()
            }
        }
    }
}
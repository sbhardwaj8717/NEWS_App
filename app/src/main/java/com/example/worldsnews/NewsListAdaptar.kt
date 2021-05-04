package com.example.worldsnews

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NewsListAdaptar(private val items : ArrayList<String>, private val listner :NewItemClicked)   : RecyclerView.Adapter<NewsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        val viewHolder = NewsViewHolder(view)
        view.setOnClickListener {
            listner.onItemClicked(items[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val currentItem = items[position]
        holder.titleView.text = currentItem
    }

    override fun getItemCount(): Int {
        return items.size
    }

}


class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val titleView : TextView = itemView.findViewById(R.id.title)

}


interface NewItemClicked {
    fun onItemClicked(item: String)
}
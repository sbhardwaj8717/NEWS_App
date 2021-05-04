package com.example.worldsnews

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NewsAdapter(private val items : ArrayList<String>, private val listener: ClickItem) : RecyclerView.Adapter<newsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): newsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        val holderView = newsViewHolder(view)
        view.setOnClickListener {
            listener.onEachClick(items[holderView.adapterPosition])
        }
        return holderView
    }

    override fun onBindViewHolder(holder: newsViewHolder, position: Int) {
        val currentItem= items[position]
        holder.title.text = currentItem
    }

    override fun getItemCount(): Int {
        return  items.size
    }


}

class  newsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val title :TextView = itemView.findViewById(R.id.titleBlock)
}

interface ClickItem{
    fun onEachClick(item:String)
}



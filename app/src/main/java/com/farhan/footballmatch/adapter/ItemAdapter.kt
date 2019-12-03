package com.farhan.footballmatch.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.farhan.footballmatch.R
import com.farhan.footballmatch.model.Item

class ItemAdapter(private val context: Context, private val items: List<Item>, private val listener: (Item) -> Unit) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(LayoutInflater.from(context).inflate(R.layout.league_list_item,parent,false))

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ItemAdapter.ViewHolder, position: Int) {
        holder.bindItem(items[position], listener)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val leagueName = view.findViewById<TextView>(R.id.leagueName)
        private val leagueBadge = view.findViewById<ImageView>(R.id.leagueBadge)

        fun bindItem(items: Item, listener: (Item) -> Unit){
            leagueName.text = items.leagueName
            Glide.with(itemView.context).load(items.leagueBadge).into(leagueBadge)

            itemView.setOnClickListener {
                listener(items)
            }
        }
    }

}
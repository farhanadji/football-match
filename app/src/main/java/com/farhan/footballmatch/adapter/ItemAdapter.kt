package com.farhan.footballmatch.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.farhan.footballmatch.R
import com.farhan.footballmatch.model.DetailEventItem
import com.farhan.footballmatch.model.League

class ItemAdapter(private val context: Context, private val leagues: List<League>, private val listener: (League) -> Unit) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(LayoutInflater.from(context).inflate(R.layout.event_list_item,parent,false))

    override fun getItemCount(): Int = leagues.size

    override fun onBindViewHolder(holder: ItemAdapter.ViewHolder, position: Int) {
        holder.bindItem(leagues[position], listener)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val eventName = view.findViewById<TextView>(R.id.eventName)
        private val eventDate = view.findViewById<TextView>(R.id.eventDate)
        private val homeScore = view.findViewById<TextView>(R.id.homeScore)
        private val awayScore = view.findViewById<TextView>(R.id.awayScore)

        fun bindItem(items: League, listener: (League) -> Unit){
            eventName.text = items.eventName
            eventDate.text = items.eventDate
            homeScore.text = items.homeScore.toString()
            awayScore.text = items.awayScore.toString()

            itemView.setOnClickListener {
                listener(items)
            }
        }
    }

}
package com.farhan.footballmatch

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.farhan.footballmatch.adapter.LeagueAdapter
import com.farhan.footballmatch.adapter.PagerAdapter
import com.farhan.footballmatch.model.LeagueItem
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    private var item : MutableList<LeagueItem> = mutableListOf()
    private lateinit var rv: RecyclerView
    private lateinit var adapter: LeagueAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadData()
        adapter = LeagueAdapter(this, item) {
            startActivity<DetailLeague>("item" to it)
        }
        rv = findViewById(R.id.rvHome)
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = adapter


    }

    private fun loadData(){
        val leagueId = resources.getStringArray(R.array.league_id)
        val leagueTitle = resources.getStringArray(R.array.league_name)
        val leagueBadge = resources.obtainTypedArray(R.array.league_badge)

        item.clear()
        for(i in leagueTitle.indices){
            item.add(LeagueItem(leagueId[i],leagueTitle[i], leagueBadge.getResourceId(i,0)))
        }

        leagueBadge.recycle()
    }

}

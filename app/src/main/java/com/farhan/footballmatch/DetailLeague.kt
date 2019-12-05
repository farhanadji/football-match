package com.farhan.footballmatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.farhan.footballmatch.adapter.PagerAdapter
import com.farhan.footballmatch.model.LeagueItem
import kotlinx.android.synthetic.main.activity_detail_league.*

class DetailLeague : AppCompatActivity() {
    companion object {
        var leagueId: String? = "4328"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_league)
        val league = intent.extras?.getParcelable<LeagueItem>("item")

        leagueId = league?.idLeague

        leagueName.text = league?.name
        Glide.with(this).load(league?.badge).into(leagueBadge)

        viewpagerHome.adapter = PagerAdapter(supportFragmentManager)
        tabsHome.setupWithViewPager(viewpagerHome)
    }
}

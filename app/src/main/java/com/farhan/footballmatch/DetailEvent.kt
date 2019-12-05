package com.farhan.footballmatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.farhan.footballmatch.main.DetailPresenter
import com.farhan.footballmatch.model.DetailEventItem
import com.farhan.footballmatch.model.DetailTeam
import com.farhan.footballmatch.model.League
import com.farhan.footballmatch.network.SportDBApi
import com.google.gson.Gson

class DetailEvent : AppCompatActivity() {
    private lateinit var presenter: DetailPresenter
    private lateinit var presenterHome: DetailPresenter
    private lateinit var presenterAway: DetailPresenter


    companion object {
        var leagueId: String? = "0"
        var homeId: String? = "0"
        var awayId: String? = "0"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_event)

        val league = intent.extras?.getParcelable<DetailEventItem>("match")
        leagueId = league!!.eventId
        Log.v("ID : ", leagueId.toString())


        val sportAPI = SportDBApi(leagueId)
        val api = sportAPI.matchDetail()
        val gson = Gson()
        presenter = DetailPresenter(this, api, gson)
        presenter.getDetailMatch()

//        val homeAPI = SportDBApi(homeId)
//        val apiHome = homeAPI.teamDetail()
//        presenter = DetailPresenter(this, apiHome, gson)
//        presenter.getHomeTeam()
//
//        val awayAPI = SportDBApi(homeId)
//        val apiAway = awayAPI.teamDetail()
//        presenter = DetailPresenter(this, apiAway, gson)
//        presenter.getAwayTeam()
    }

    fun showEventData(data: List<DetailEventItem?>){
//        homeId = data[0].homeId
//        awayId = data[0].awayId

        Log.v("DATA : ", data[0]!!.eventId.toString())
//        homeDefense.text = data[0]!!.homeDefense
//        awayDefense.text = data[0]!!.awayDefense
//        homeForward.text = data[0]!!.homeForward
//        awayForward.text = data[0]!!.awayForward
//        homeGoalkeeper.text = data[0].homeGoalkeeper
//        awayGoalKeeper.text = data[0].awayGoalkeeper
//        homeGoals.text = data[0].homeGoal
//        awayGoals.text = data[0].awayGoal
//        homeMidfield.text = data[0].homeMidfield
//        awayMidfield.text = data[0].awayMidfield
//        homeScoreDetail.text = data[0].homeScore.toString()
//        awayScoreDetail.text = data[0].awayScore.toString()
    }

    fun showHomeTeam(home: List<DetailTeam>){
//        Glide.with(this).load(home.teamBadge).into(homeTeamBadge)
        Log.v("data get: ", home[0].teamName)
    }

    fun showAwayTeam(away: List<DetailTeam>){
//        Glide.with(this).load(away.teamBadge).into(awayTeamBadge)
        Log.v("data get: ", away[0].teamName)

    }
}

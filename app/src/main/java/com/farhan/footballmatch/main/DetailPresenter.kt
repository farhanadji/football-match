package com.farhan.footballmatch.main

import com.farhan.footballmatch.DetailEvent
import com.farhan.footballmatch.network.ApiRepository
import com.farhan.footballmatch.network.DetailResponse
import com.farhan.footballmatch.network.TeamResponse
import com.farhan.footballmatch.util.CoroutineContextProvider
import com.google.gson.Gson
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DetailPresenter(private val view: DetailEvent, private val api:String, private val gson: Gson, private val context: CoroutineContextProvider = CoroutineContextProvider() ){

    fun getDetailMatch() {
        GlobalScope.launch(context.main){
            val matchDetail = gson.fromJson(ApiRepository().doRequestAsync(api).await(), DetailResponse::class.java)
            view.showEventData(matchDetail.detailEventItems)
        }

    }

    fun getHomeTeam(){
        GlobalScope.launch(context.main){
            val homeTeam = gson.fromJson(ApiRepository().doRequestAsync(api).await(), TeamResponse::class.java)
            view.showHomeTeam(homeTeam.team)
        }
    }

    fun getAwayTeam(){
        GlobalScope.launch(context.main){
            val awayTeam = gson.fromJson(ApiRepository().doRequestAsync(api).await(), TeamResponse::class.java)
            view.showAwayTeam(awayTeam.team)
        }
    }
}
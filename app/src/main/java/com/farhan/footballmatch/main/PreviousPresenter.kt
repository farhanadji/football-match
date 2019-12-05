package com.farhan.footballmatch.main

import com.farhan.footballmatch.PrevMatchFragment
import com.farhan.footballmatch.network.ApiRepository
import com.farhan.footballmatch.network.ApiResponse
import com.farhan.footballmatch.util.CoroutineContextProvider
import com.google.gson.Gson
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class PreviousPresenter(private val view: PrevMatchFragment, private val api:String, private val gson: Gson, private val context: CoroutineContextProvider = CoroutineContextProvider() ){

    fun getEventList() {

        GlobalScope.launch(context.main){
            val matchDetail = gson.fromJson(ApiRepository().doRequestAsync(api).await(), ApiResponse::class.java)
            view.showAllData(matchDetail.eventItems)
        }

    }
}
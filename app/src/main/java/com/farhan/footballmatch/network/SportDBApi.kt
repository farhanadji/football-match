package com.farhan.footballmatch.network

import android.net.Uri
import com.farhan.footballmatch.BuildConfig

class SportDBApi(val id: String?) {

    fun urlBuilder(path: String?) = Uri.parse(BuildConfig.BASE_URL).buildUpon()
        .appendPath("api")
        .appendPath("v1")
        .appendPath("json")
        .appendPath(BuildConfig.TSDB_API_KEY)
        .appendPath(path)
        .appendQueryParameter("id", id)
        .build().toString()


    fun matchDetail() = urlBuilder("lookupevent.php")
    fun nextSchedule() = urlBuilder("eventsnextleague.php")
    fun prevSchedule() = urlBuilder("eventspastleague.php")
    fun teamDetail() = urlBuilder("lookupteam.php")
}
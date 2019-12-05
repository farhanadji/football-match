package com.farhan.footballmatch.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class League (
    @SerializedName("idEvent")
    val eventId: String?,

    @SerializedName("strEvent")
    val eventName: String?,

    @SerializedName("strDate")
    val eventDate: String?,

    @SerializedName("intHomeScore")
    val homeScore: Int?,

    @SerializedName("intAwayScore")
    val awayScore: Int?

) : Parcelable
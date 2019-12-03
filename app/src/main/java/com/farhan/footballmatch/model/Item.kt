package com.farhan.footballmatch.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Item (
    val leagueName: String?,
    val leagueBadge: Int?
    val leagueDescription: String?
) : Parcelable
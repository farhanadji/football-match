package com.farhan.footballmatch.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LeagueItem(
    var idLeague: String?,
    var name: String?,
    var badge: Int?
) : Parcelable
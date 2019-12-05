package com.farhan.footballmatch.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DetailTeam (
    @SerializedName("idTeam")
    val teamId: String?,

    @SerializedName("strTeam")
    val teamName: String?,

    @SerializedName("strTeamBadge")
    val teamBadge: String?

    ) : Parcelable
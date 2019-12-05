package com.farhan.footballmatch.network

import com.farhan.footballmatch.model.DetailEventItem
import com.farhan.footballmatch.model.DetailTeam
import com.farhan.footballmatch.model.League
import com.farhan.footballmatch.model.LeagueItem

data class ApiResponse(
    val eventItems: List<League>,
    val detailEventItems: List<DetailEventItem>,
    val team: List<DetailTeam>
)
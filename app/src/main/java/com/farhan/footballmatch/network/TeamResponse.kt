package com.farhan.footballmatch.network

import com.farhan.footballmatch.model.DetailTeam

data class TeamResponse(
    val team: List<DetailTeam>
)
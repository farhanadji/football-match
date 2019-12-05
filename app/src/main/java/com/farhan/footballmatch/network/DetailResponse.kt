package com.farhan.footballmatch.network

import com.farhan.footballmatch.model.DetailEventItem

data class DetailResponse(
    val detailEventItems: List<DetailEventItem>
)
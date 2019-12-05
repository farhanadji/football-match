package com.farhan.footballmatch.main

import com.farhan.footballmatch.model.League

interface EventView {
    fun showLoading()
    fun hideloading()
    fun showDetail(event: League)

}
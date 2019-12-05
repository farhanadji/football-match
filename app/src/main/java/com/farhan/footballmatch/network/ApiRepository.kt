package com.farhan.footballmatch.network

import kotlinx.coroutines.Deferred
import java.net.URL
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class ApiRepository {
    fun doRequestAsync(url: String): Deferred<String> = GlobalScope.async {
        URL(url).readText()
    }
}
package com.example.beerace.data.source

import com.example.beerace.data.model.RaceDurationResponse
import retrofit2.http.GET

interface ApiDataSource {

    @GET("race/duration")
    suspend fun getRaceDuration(): RaceDurationResponse

}
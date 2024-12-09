package com.example.beerace.data.source

import com.example.beerace.data.model.RaceDurationResponse
import com.example.beerace.data.model.RaceStatusResponse
import retrofit2.http.GET

interface ApiDataSource {

    @GET("race/duration")
    suspend fun getRaceDuration(): RaceDurationResponse

    @GET("race/status")
    suspend fun getRaceStatus(): RaceStatusResponse

}
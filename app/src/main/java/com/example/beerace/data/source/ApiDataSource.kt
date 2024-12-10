package com.example.beerace.data.source

import com.example.beerace.data.model.CaptchaErrorResponse
import com.example.beerace.data.model.RaceDurationResponse
import com.example.beerace.data.model.RaceStatusResponse
import retrofit2.http.GET

interface ApiDataSource {

    @GET("bees/race/duration")
    suspend fun getRaceDuration(): RaceDurationResponse

    @GET("bees/race/status")
    suspend fun getRaceStatus(): RaceStatusResponse

    @GET("captchaTest")
    suspend fun captchaTest(): CaptchaErrorResponse
}
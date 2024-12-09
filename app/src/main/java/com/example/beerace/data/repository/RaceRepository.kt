package com.example.beerace.data.repository

import com.example.beerace.data.model.RaceDurationResponse
import com.example.beerace.data.model.RaceStatusResponse
import com.example.beerace.data.source.ApiDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RaceRepository(
    private val apiDataSource: ApiDataSource,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
) {

    fun getRaceDuration(): Flow<RaceDurationResponse> = flow {
        emit(apiDataSource.getRaceDuration())
    }.flowOn(ioDispatcher)

    fun getRaceStatus(): Flow<RaceStatusResponse> = flow {
        emit(apiDataSource.getRaceStatus())
    }.flowOn(ioDispatcher)

}
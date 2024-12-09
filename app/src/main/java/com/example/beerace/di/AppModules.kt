package com.example.beerace.di

import com.example.beerace.data.repository.RaceRepository
import com.example.beerace.data.source.ApiDataSource
import com.example.beerace.ui.screens.race.RaceViewModel
import okhttp3.OkHttpClient
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://rtest.proxy.beeceptor.com/bees/"

val viewModelModule = module {
    viewModel { RaceViewModel(get()) }
}

private val repositoryModule = module {
    factory { RaceRepository(get()) }
}

private val networkModule = module {
    factory { provideApiDataSource(get()) }
    factory { provideOkHttpClient() }
    single { provideRetrofit(get()) }
}

private fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
        .build()
}

private fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit
        .Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .build()
}

private fun provideApiDataSource(retrofit: Retrofit) =
    retrofit.create(ApiDataSource::class.java)

val koinModules = listOf(
    networkModule,
    repositoryModule,
    viewModelModule,
)
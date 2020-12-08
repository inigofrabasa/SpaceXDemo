package com.inigofrabasa.spacexdemo.core.di

import android.content.Context
import com.inigofrabasa.spacexdemo.AndroidApplication
import com.inigofrabasa.spacexdemo.features.rocketLaunches.repository.RocketLaunchesRepository
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: AndroidApplication) {

    @Provides
    @Singleton
    fun provideApplicationContext(): Context = application

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl("https://api.spacexdata.com/v4/")
                .client(createClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    private fun createClient(): OkHttpClient {
        val okHttpClientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
        return okHttpClientBuilder.build()
    }

    @Provides
    @Singleton
    fun provideRocketLaunchesRepository(dataSource: RocketLaunchesRepository.Network): RocketLaunchesRepository = dataSource
}

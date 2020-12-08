package com.inigofrabasa.spacexdemo.features.rocketLaunches.api

import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RocketLaunchesService
@Inject constructor(retrofit: Retrofit) : RocketLaunchesApi {
    private val rocketLaunchesApi by lazy { retrofit.create(RocketLaunchesApi::class.java) }

    override fun getLaunches() = rocketLaunchesApi.getLaunches()
}
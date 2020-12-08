package com.inigofrabasa.spacexdemo.features.rocketLaunches.api

import com.inigofrabasa.spacexdemo.features.rocketLaunches.model.entities.LaunchesEntity
import retrofit2.Call
import retrofit2.http.GET

internal interface RocketLaunchesApi {
    companion object {
        private const val LAUNCHES = "launches"
    }

    @GET(LAUNCHES)
    fun getLaunches(): Call<List<LaunchesEntity>>
}
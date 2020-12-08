package com.inigofrabasa.spacexdemo.features.rocketLaunches.repository

import com.inigofrabasa.spacexdemo.core.exception.Failure
import com.inigofrabasa.spacexdemo.core.exception.Failure.NetworkConnection
import com.inigofrabasa.spacexdemo.core.exception.Failure.ServerError
import com.inigofrabasa.spacexdemo.core.functional.Either
import com.inigofrabasa.spacexdemo.core.functional.Either.Left
import com.inigofrabasa.spacexdemo.core.functional.Either.Right
import com.inigofrabasa.spacexdemo.core.platform.NetworkHandler
import com.inigofrabasa.spacexdemo.features.rocketLaunches.api.RocketLaunchesService
import com.inigofrabasa.spacexdemo.features.rocketLaunches.model.entities.LaunchesEntity
import retrofit2.Call
import javax.inject.Inject

interface RocketLaunchesRepository {
    fun launches(): Either<Failure, List<LaunchesEntity>>

    class Network
    @Inject constructor(private val networkHandler: NetworkHandler,
                        private val service: RocketLaunchesService
    ) : RocketLaunchesRepository {

        override fun launches(): Either<Failure, List<LaunchesEntity>> {
            return when (networkHandler.isNetworkAvailable()) {
                true -> request(service.getLaunches(), ::handleResponse)
                false -> Left(NetworkConnection())
            }
        }

        private fun handleResponse(launchesEntity : List<LaunchesEntity>) = launchesEntity

        private fun <T, R> request(call: Call<T>, handle: (T) -> R): Either<Failure, R> {
            return try {
                val response = call.execute()
                response.body()?.let{
                    when (response.isSuccessful) {
                        true -> Right(handle(response.body()!!))
                        false -> Left(ServerError())
                    }
                } ?: run { Left(ServerError(response.message())) }
            } catch (exception: Throwable) {
                Left(ServerError())
            }
        }
    }
}
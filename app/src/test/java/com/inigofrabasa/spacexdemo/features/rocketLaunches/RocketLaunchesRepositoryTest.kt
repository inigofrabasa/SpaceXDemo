package com.inigofrabasa.spacexdemo.features.rocketLaunches

import com.inigofrabasa.spacexdemo.UnitTest
import com.inigofrabasa.spacexdemo.core.functional.Either.Right
import com.inigofrabasa.spacexdemo.core.platform.NetworkHandler
import com.inigofrabasa.spacexdemo.features.rocketLaunches.api.RocketLaunchesService
import com.inigofrabasa.spacexdemo.features.rocketLaunches.model.entities.LaunchesEntity
import com.inigofrabasa.spacexdemo.features.rocketLaunches.repository.RocketLaunchesRepository.Network
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import org.amshove.kluent.shouldEqual
import org.junit.Before
import org.junit.Test
import retrofit2.Call
import retrofit2.Response

class RocketLaunchesRepositoryTest : UnitTest() {
    private lateinit var networkRepository: Network

    @MockK private lateinit var networkHandler: NetworkHandler
    @MockK private lateinit var service: RocketLaunchesService

    @MockK private lateinit var launchesCall: Call<List<LaunchesEntity>>
    @MockK private lateinit var launchesResponse: Response<List<LaunchesEntity>>

    @Before
    fun setUp() {
        networkRepository = Network(networkHandler, service)
    }

    @Test
    fun `should get launches list from service`() {
        every { networkHandler.isNetworkAvailable() } returns true
        every { launchesResponse.body() } returns listOf(LaunchesEntity(name = "DemoSat", success= false, id = "5eb87cdaffd86e000604b32b"))
        every { launchesResponse.isSuccessful } returns true
        every { launchesCall.execute() } returns launchesResponse
        every { service.getLaunches() } returns launchesCall

        val launches = networkRepository.launches()

        launches shouldEqual Right(listOf(LaunchesEntity( name = "DemoSat", success= false, id = "5eb87cdaffd86e000604b32b")))
        verify(exactly = 1) { service.getLaunches() }
    }
}
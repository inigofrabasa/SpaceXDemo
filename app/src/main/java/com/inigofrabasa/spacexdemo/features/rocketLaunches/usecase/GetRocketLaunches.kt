package com.inigofrabasa.spacexdemo.features.rocketLaunches.usecase

import com.inigofrabasa.spacexdemo.core.interactor.UseCase
import com.inigofrabasa.spacexdemo.features.rocketLaunches.model.entities.LaunchesEntity
import com.inigofrabasa.spacexdemo.features.rocketLaunches.repository.RocketLaunchesRepository
import javax.inject.Inject

class GetRocketLaunches
@Inject constructor(private val rocketLaunchesRepository : RocketLaunchesRepository) : UseCase<List<LaunchesEntity>, UseCase.None>(){
    override suspend fun run(params: None) = rocketLaunchesRepository.launches()
}
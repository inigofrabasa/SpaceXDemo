package com.inigofrabasa.spacexdemo.features.rocketLaunches.viewmodel

import androidx.lifecycle.MutableLiveData
import com.inigofrabasa.spacexdemo.core.interactor.UseCase
import com.inigofrabasa.spacexdemo.core.platform.BaseViewModel
import com.inigofrabasa.spacexdemo.features.rocketLaunches.model.entities.LaunchesEntity
import com.inigofrabasa.spacexdemo.features.rocketLaunches.model.view.LaunchesView
import com.inigofrabasa.spacexdemo.features.rocketLaunches.usecase.GetRocketLaunches
import javax.inject.Inject

class RocketLaunchesViewModel
@Inject constructor(
    private val getRocketLaunches: GetRocketLaunches
) : BaseViewModel() {
    var rocketLaunches: MutableLiveData<List<LaunchesView>> = MutableLiveData()

    fun getRocketLaunches(){
        getRocketLaunches(UseCase.None()) { it.fold(::handleFailure, ::handleRocketLaunches) }
    }

    private fun handleRocketLaunches(launchesEntityList: List<LaunchesEntity>) {
        this.rocketLaunches.value = launchesEntityList.map{  it.toLaunchesView() }
    }
}
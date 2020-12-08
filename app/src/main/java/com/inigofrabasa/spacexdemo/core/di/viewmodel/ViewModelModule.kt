package com.inigofrabasa.spacexdemo.core.di.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.inigofrabasa.spacexdemo.features.rocketLaunches.viewmodel.RocketLaunchesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(RocketLaunchesViewModel::class)
    abstract fun bindsRocketLaunchesViewModel(rocketLaunchesViewModel: RocketLaunchesViewModel): ViewModel
}
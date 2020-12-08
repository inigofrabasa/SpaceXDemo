package com.inigofrabasa.spacexdemo.core.di

import com.inigofrabasa.spacexdemo.AndroidApplication
import com.inigofrabasa.spacexdemo.core.di.viewmodel.ViewModelModule
import com.inigofrabasa.spacexdemo.core.navigation.RouteActivity
import com.inigofrabasa.spacexdemo.features.rocketLaunches.view.RocketLaunchesFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, ViewModelModule::class])
interface ApplicationComponent {
    fun inject(application: AndroidApplication)
    fun inject(routeActivity: RouteActivity)

    fun inject(rocketLaunchesFragment: RocketLaunchesFragment)
}
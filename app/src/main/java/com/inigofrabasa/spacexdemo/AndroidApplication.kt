package com.inigofrabasa.spacexdemo

import android.app.Application
import com.inigofrabasa.spacexdemo.core.di.ApplicationComponent
import com.inigofrabasa.spacexdemo.core.di.ApplicationModule
import com.inigofrabasa.spacexdemo.core.di.DaggerApplicationComponent

class AndroidApplication : Application() {

    var appContext = this

    val appComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        this.injectMembers()
        instance = this
    }

    private fun injectMembers() = appComponent.inject(this)

    companion object {
        lateinit var instance: AndroidApplication
            private set
    }
}
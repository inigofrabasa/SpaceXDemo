package com.inigofrabasa.spacexdemo.core.navigation

import android.view.View
import androidx.fragment.app.FragmentActivity
import com.inigofrabasa.spacexdemo.features.rocketLaunches.view.RocketLaunchesActivity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Navigator
@Inject constructor() {

    fun showMain(activity: FragmentActivity) {
        activity.startActivity(RocketLaunchesActivity.callingIntent(activity))
    }

    class Extras(val transitionSharedElement: View)
}
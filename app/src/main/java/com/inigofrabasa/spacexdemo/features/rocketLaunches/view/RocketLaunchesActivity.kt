package com.inigofrabasa.spacexdemo.features.rocketLaunches.view

import android.content.Context
import android.content.Intent
import com.inigofrabasa.spacexdemo.R
import com.inigofrabasa.spacexdemo.core.platform.BaseActivity
import com.inigofrabasa.spacexdemo.databinding.ActivityBaseLayoutBinding

class RocketLaunchesActivity : BaseActivity() {

    companion object {
        fun callingIntent(context: Context) : Intent {
            return Intent(context, RocketLaunchesActivity::class.java)
        }
    }

    override fun layoutId() = R.layout.activity_base_layout
    override fun binding(): ActivityBaseLayoutBinding = baseBinding as ActivityBaseLayoutBinding
    override fun fragment() = RocketLaunchesFragment()
}
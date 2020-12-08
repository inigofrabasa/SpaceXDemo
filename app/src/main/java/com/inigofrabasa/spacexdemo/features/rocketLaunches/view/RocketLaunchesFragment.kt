package com.inigofrabasa.spacexdemo.features.rocketLaunches.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.inigofrabasa.spacexdemo.R
import com.inigofrabasa.spacexdemo.core.exception.Failure
import com.inigofrabasa.spacexdemo.core.exception.FailureUI
import com.inigofrabasa.spacexdemo.core.exception.SuccessUI
import com.inigofrabasa.spacexdemo.core.extension.*
import com.inigofrabasa.spacexdemo.core.extension.viewModel
import com.inigofrabasa.spacexdemo.core.platform.BaseFragment
import com.inigofrabasa.spacexdemo.databinding.FragmentRocketLaunchesBinding
import com.inigofrabasa.spacexdemo.features.rocketLaunches.adapter.RocketLaunchesAdapter
import com.inigofrabasa.spacexdemo.features.rocketLaunches.model.view.LaunchesView
import com.inigofrabasa.spacexdemo.features.rocketLaunches.viewmodel.RocketLaunchesViewModel
import javax.inject.Inject

class RocketLaunchesFragment : BaseFragment() {

    @Inject lateinit var rocketLaunchesAdapter: RocketLaunchesAdapter
    private lateinit var rocketLaunchesViewModel: RocketLaunchesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)

        rocketLaunchesViewModel = viewModel(viewModelFactory){
            success(rocketLaunches, ::handleRocketLaunches)
            failure(failure, ::handleFailure)
            successUI(successUI, ::handleSuccessUI)
            failureUI(failureUI, ::handleFailureUI)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rocketLaunchesViewModel.getRocketLaunches()

        binding().rocketLaunchesRecyclerView.adapter = rocketLaunchesAdapter
        binding().rocketLaunchesRecyclerView.layoutManager =
            LinearLayoutManager(activity, RecyclerView.VERTICAL, false) as RecyclerView.LayoutManager?
    }

    private fun handleRocketLaunches(any: List<LaunchesView>?){
        binding().rocketLaunchesProgressBar.gone()
        binding().rocketLaunchesRecyclerView.visible()
        rocketLaunchesAdapter.setCollection(any.orEmpty() as MutableList)
    }

    private fun handleFailure(failure: Failure?) {
        binding().rocketLaunchesProgressBar.gone()
        when(failure){
            is Failure.ServerError -> {
                Toast.makeText(activity!!, failure.message, Toast.LENGTH_SHORT).show()
            }
            is Failure.NetworkConnection -> {
                Toast.makeText(activity!!, failure.message, Toast.LENGTH_SHORT).show()
            }
            else -> { }
        }
    }

    private fun handleSuccessUI(successUI : SuccessUI?){
        //ToDo: for any UI success
    }

    private fun handleFailureUI(failureUI : FailureUI?){
        //ToDo: for any UI Failure
    }

    override fun layoutId() = R.layout.fragment_rocket_launches
    override fun binding(): FragmentRocketLaunchesBinding = baseBinding as FragmentRocketLaunchesBinding
}
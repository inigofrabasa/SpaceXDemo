package com.inigofrabasa.spacexdemo.features.rocketLaunches.model.view

data class FairingsView(
    val reused : Boolean?,
    val recovery_attempt : Boolean?,
    val recovered : Boolean?,
    val ships : List<String>?
)
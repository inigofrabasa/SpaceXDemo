package com.inigofrabasa.spacexdemo.features.rocketLaunches.model.view

data class CoresView(
    val core : String?,
    val flight : Int?,
    val gridfins : Boolean?,
    val legs : Boolean?,
    val reused : Boolean?,
    val landing_attempt : Boolean?,
    val landing_success : String?,
    val landing_type : String?,
    val landpad : String?
)

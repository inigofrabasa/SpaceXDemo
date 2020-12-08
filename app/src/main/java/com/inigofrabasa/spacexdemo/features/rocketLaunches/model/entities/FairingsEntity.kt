package com.inigofrabasa.spacexdemo.features.rocketLaunches.model.entities

import com.google.gson.annotations.SerializedName

data class FairingsEntity (
    @SerializedName("reused") val reused : Boolean,
    @SerializedName("recovery_attempt") val recovery_attempt : Boolean,
    @SerializedName("recovered") val recovered : Boolean,
    @SerializedName("ships") val ships : List<String>
)
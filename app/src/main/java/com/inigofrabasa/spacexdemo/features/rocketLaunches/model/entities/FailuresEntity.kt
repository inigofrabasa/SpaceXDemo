package com.inigofrabasa.spacexdemo.features.rocketLaunches.model.entities

import com.google.gson.annotations.SerializedName
import com.inigofrabasa.spacexdemo.features.rocketLaunches.model.view.FailuresView

data class FailuresEntity (
    @SerializedName("time") val time : Int,
    @SerializedName("altitude") val altitude : String,
    @SerializedName("reason") val reason : String
){
    fun toFailuresView() : FailuresView {
        return FailuresView(
                this.time,
                this.altitude,
                this.reason
        )
    }
}
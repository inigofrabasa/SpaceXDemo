package com.inigofrabasa.spacexdemo.features.rocketLaunches.model.entities

import com.google.gson.annotations.SerializedName
import com.inigofrabasa.spacexdemo.features.rocketLaunches.model.view.PatchView

data class PatchEntity(
    @SerializedName("small") val small : String,
    @SerializedName("large") val large : String
){
    fun toPatchView() : PatchView? {
        return PatchView(
                this.small,
                this.large
        )
    }
}
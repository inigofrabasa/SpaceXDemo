package com.inigofrabasa.spacexdemo.features.rocketLaunches.model.entities

import com.google.gson.annotations.SerializedName
import com.inigofrabasa.spacexdemo.features.rocketLaunches.model.view.CoresView

data class CoresEntity(
    @SerializedName("core") val core : String,
    @SerializedName("flight") val flight : Int,
    @SerializedName("gridfins") val gridfins : Boolean,
    @SerializedName("legs") val legs : Boolean,
    @SerializedName("reused") val reused : Boolean,
    @SerializedName("landing_attempt") val landing_attempt : Boolean,
    @SerializedName("landing_success") val landing_success : String,
    @SerializedName("landing_type") val landing_type : String,
    @SerializedName("landpad") val landpad : String
){
    fun toCoresView() : CoresView {
        return CoresView(
                this.core,
                this.flight,
                this.gridfins,
                this.legs,
                this.reused,
                this.landing_attempt,
                this.landing_success,
                this.landing_type,
                this.landpad
        )
    }
}
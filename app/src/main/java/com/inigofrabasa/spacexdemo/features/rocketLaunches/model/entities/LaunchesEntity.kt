package com.inigofrabasa.spacexdemo.features.rocketLaunches.model.entities

import com.google.gson.annotations.SerializedName
import com.inigofrabasa.spacexdemo.core.extension.empty
import com.inigofrabasa.spacexdemo.features.rocketLaunches.model.view.*

data class LaunchesEntity(
        @SerializedName("fairings") val fairingsEntity : FairingsEntity? = null,
        @SerializedName("links") val linksEntity : LinksEntity? = null,
        @SerializedName("static_fire_date_utc") val static_fire_date_utc : String = String.empty(),
        @SerializedName("static_fire_date_unix") val static_fire_date_unix : Int = 0,
        @SerializedName("tbd") val tbd : Boolean = false,
        @SerializedName("net") val net : Boolean = false,
        @SerializedName("window") val window : Int = 0,
        @SerializedName("rocket") val rocket : String = String.empty(),
        @SerializedName("success") val success : Boolean = false,
        @SerializedName("details") val details : String = String.empty(),
        @SerializedName("crew") val crew : List<String>? = null,
        @SerializedName("ships") val ships : List<String>? = null,
        @SerializedName("capsules") val capsules : List<String>? = null,
        @SerializedName("payloads") val payloads : List<String>? = null,
        @SerializedName("launchpad") val launchpad : String = String.empty(),
        @SerializedName("auto_update") val auto_update : Boolean = false,
        @SerializedName("failures") val failuresEntity : List<FailuresEntity>? = null,
        @SerializedName("flight_number") val flight_number : Int = 0,
        @SerializedName("name") val name : String = String.empty(),
        @SerializedName("date_utc") val date_utc : String  = String.empty(),
        @SerializedName("date_unix") val date_unix : Int = 0,
        @SerializedName("date_local") val date_local : String  = String.empty(),
        @SerializedName("date_precision") val date_precision : String  = String.empty(),
        @SerializedName("upcoming") val upcoming : Boolean = false,
        @SerializedName("cores") val coresEntity : List<CoresEntity>? = null,
        @SerializedName("id") val id : String = String.empty()
){
    fun toLaunchesView() : LaunchesView {
        return LaunchesView(
                this.toFairingsView(this.fairingsEntity),
                this.toLinksView(this.linksEntity),
                this.static_fire_date_utc,
                this.static_fire_date_unix,
                this.tbd,
                this.net,
                this.window,
                this.rocket,
                this.success,
                this.details,
                this.crew,
                this.ships,
                this.capsules,
                this.payloads,
                this.launchpad,
                this.auto_update,
                this.toFailuresViewList(this.failuresEntity!!),
                this.flight_number,
                this.name,
                this.date_utc,
                this.date_unix,
                this.date_local,
                this.date_precision,
                this.upcoming,
                this.toCoresViewList(this.coresEntity!!),
                this.id
        )
    }

    private fun toFairingsView(fairingsEntity : FairingsEntity?) : FairingsView?{
        return FairingsView(
                fairingsEntity?.reused,
                fairingsEntity?.recovery_attempt,
                fairingsEntity?.recovered,
                fairingsEntity?.ships
        )
    }

    private fun toLinksView(linksEntity : LinksEntity?) : LinksView?{
        return LinksView(
                linksEntity?.patchEntity?.toPatchView(),
                linksEntity?.presskit,
                linksEntity?.webcast,
                linksEntity?.youtube_id,
                linksEntity?.article,
                linksEntity?.wikipedia
        )
    }

    private fun toFailuresViewList(failuresEntity: List<FailuresEntity>) : List<FailuresView>?{
        return failuresEntity.map { it.toFailuresView() }
    }

    private fun toCoresViewList(coresEntity : List<CoresEntity>) : List<CoresView>?{
        return coresEntity.map { it.toCoresView() }
    }
}
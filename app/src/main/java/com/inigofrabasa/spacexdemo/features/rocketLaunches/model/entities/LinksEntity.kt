package com.inigofrabasa.spacexdemo.features.rocketLaunches.model.entities

import com.google.gson.annotations.SerializedName

data class LinksEntity(
        @SerializedName("patch") val patchEntity : PatchEntity,
        @SerializedName("presskit") val presskit : String,
        @SerializedName("webcast") val webcast : String,
        @SerializedName("youtube_id") val youtube_id : String,
        @SerializedName("article") val article : String,
        @SerializedName("wikipedia") val wikipedia : String
)
package com.example.data.model

import com.google.gson.annotations.SerializedName

data class RemoteGood(
    @SerializedName("adjusted_price") val adjustedPrice: Double?,
    @SerializedName("average_price") val averagePrice: Double?,
    @SerializedName("type_id") val typeId: Long?
)

package com.interndemosss.hackathon_kotlin_assignment.Model

import com.google.gson.annotations.SerializedName

data class DeskAvailabilityResponse(
    @SerializedName("desk_id")
    val deskId: Int,
    @SerializedName("availability")
    val availability: Boolean
)

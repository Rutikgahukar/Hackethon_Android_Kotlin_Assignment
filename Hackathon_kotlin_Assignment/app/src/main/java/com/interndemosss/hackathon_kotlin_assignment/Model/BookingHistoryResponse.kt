package com.interndemosss.hackathon_kotlin_assignment.Model

import com.google.gson.annotations.SerializedName

data class BookingHistoryResponse(
    @SerializedName("desk_id")
    val deskId: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("booked_on")
    val bookedOn: String
)

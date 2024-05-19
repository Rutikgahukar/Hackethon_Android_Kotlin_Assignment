package com.interndemosss.hackathon_kotlin_assignment.Model

import com.google.gson.annotations.SerializedName

data class BookingResponse(
    @SerializedName("status") val status: String,
    @SerializedName("message") val message: String,
    @SerializedName("booking_id") val bookingId: Int? = null,
    @SerializedName("date") val date: String? = null,
    @SerializedName("slot_id") val slotId: Int? = null,
    @SerializedName("workspace_id") val workspaceId: Int? = null,
    @SerializedName("type") val type: Int? = null
)

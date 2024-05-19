package com.interndemosss.hackathon_kotlin_assignment.Model

import com.google.gson.annotations.SerializedName

data class SlotsResponse(
    @SerializedName("slots")
    val slots: List<String>
)

package com.interndemosss.hackathon_kotlin_assignment.Model

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("status")
    val status: String,
    @SerializedName("message")
    val message: String,
) {
    fun getErrorMessage(): String {
        return message
    }
}


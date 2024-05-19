package com.interndemosss.hackathon_kotlin_assignment.Repository

import com.interndemosss.hackathon_kotlin_assignment.Model.BookingHistoryResponse
import com.interndemosss.hackathon_kotlin_assignment.RetrofitApi.RetrofitClient

class BookingHistoryRepository {
    suspend fun getBookingHistory(userId: Int): List<BookingHistoryResponse> {
        val response = RetrofitClient.apiService.getBookingHistory(userId).execute()
        if (response.isSuccessful) {
            return response.body() ?: emptyList()
        } else {
            throw Exception("Error fetching booking history")
        }
    }
}

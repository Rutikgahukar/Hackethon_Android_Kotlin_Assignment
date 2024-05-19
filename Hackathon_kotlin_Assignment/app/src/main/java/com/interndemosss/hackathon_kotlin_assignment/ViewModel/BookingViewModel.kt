package com.interndemosss.hackathon_kotlin_assignment.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.interndemosss.hackathon_kotlin_assignment.Model.BookingResponse
import com.interndemosss.hackathon_kotlin_assignment.RetrofitApi.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class BookingViewModel : ViewModel() {
    fun confirmBooking(date: String, slotId: Int, workspaceId: Int, type: Int, callback: (Response<BookingResponse>) -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = RetrofitClient.apiService.confirmBooking(date, slotId, workspaceId, type)
            callback(response)
        }
    }
}

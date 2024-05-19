package com.interndemosss.hackathon_kotlin_assignment.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.interndemosss.hackathon_kotlin_assignment.Model.BookingHistoryResponse
import com.interndemosss.hackathon_kotlin_assignment.Repository.BookingHistoryRepository
import kotlinx.coroutines.launch

class BookingHistoryViewModel : ViewModel() {
    private val repository = BookingHistoryRepository()

    private val _bookingHistory = MutableLiveData<List<BookingHistoryResponse>>()
    val bookingHistory: LiveData<List<BookingHistoryResponse>> get() = _bookingHistory

    fun fetchBookingHistory(userId: Int) {
        viewModelScope.launch {
            try {
                val bookings = repository.getBookingHistory(userId)
                _bookingHistory.postValue(bookings)
            } catch (e: Exception) {
                e.printStackTrace() // Handle error
            }
        }
    }
}

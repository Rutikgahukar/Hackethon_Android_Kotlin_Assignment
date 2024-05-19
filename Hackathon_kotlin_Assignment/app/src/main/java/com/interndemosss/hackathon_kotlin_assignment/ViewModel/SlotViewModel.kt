package com.interndemosss.hackathon_kotlin_assignment.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.util.Log
import com.interndemosss.hackathon_kotlin_assignment.Model.SlotsResponse
import com.interndemosss.hackathon_kotlin_assignment.RetrofitApi.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SlotViewModel : ViewModel() {
    private val _slots = MutableLiveData<List<String>>()
    val slots: LiveData<List<String>> get() = _slots

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

    fun fetchSlots(date: String) {
        val call = RetrofitClient.apiService.getSlots(date)
        call.enqueue(object : Callback<SlotsResponse> {
            override fun onResponse(call: Call<SlotsResponse>, response: Response<SlotsResponse>) {
                if (response.isSuccessful) {
                    _slots.postValue(response.body()?.slots)
                } else {
                    // Handle error
                    _errorMessage.postValue("Failed to fetch slots: ${response.code()}")
                    Log.e("SlotViewModel", "Failed to fetch slots: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<SlotsResponse>, t: Throwable) {
                // Handle failure
                _errorMessage.postValue("Failed to fetch slots: ${t.message}")
                Log.e("SlotViewModel", "Failed to fetch slots", t)
            }
        })
    }
}

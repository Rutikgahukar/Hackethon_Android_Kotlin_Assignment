package com.interndemosss.hackathon_kotlin_assignment.View

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.interndemosss.hackathon_kotlin_assignment.Model.DeskAvailabilityResponse
import com.interndemosss.hackathon_kotlin_assignment.RetrofitApi.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DeskAvailabilityRepository(private val apiService: ApiService) {

    fun fetchAvailableDesks(date: String, slotId: Int, type: Int, param: (Any) -> Unit): LiveData<List<DeskAvailabilityResponse>> {
        val data = MutableLiveData<List<DeskAvailabilityResponse>>()
        apiService.getAvailableDesks(date, slotId, type).enqueue(object :
            Callback<List<DeskAvailabilityResponse>> {
            override fun onResponse(call: Call<List<DeskAvailabilityResponse>>, response: Response<List<DeskAvailabilityResponse>>) {
                if (response.isSuccessful) {
                    data.value = response.body()
                } else {
                    // Handle error
                }
            }

            override fun onFailure(call: Call<List<DeskAvailabilityResponse>>, t: Throwable) {
                // Handle failure
            }
        })
        return data
    }
}

package com.interndemosss.hackathon_kotlin_assignment.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.interndemosss.hackathon_kotlin_assignment.Model.DeskAvailabilityResponse
import com.interndemosss.hackathon_kotlin_assignment.View.DeskAvailabilityRepository

class DeskAvailabilityViewModel(private val repository: DeskAvailabilityRepository) : ViewModel() {
    private val _availableDesks = MutableLiveData<List<DeskAvailabilityResponse>>()
    val availableDesks: LiveData<List<DeskAvailabilityResponse>> get() = _availableDesks

    fun fetchAvailableDesks(date: String, slotId: Int, type: Int) {
        _availableDesks.postValue(emptyList()) // Clear previous data
        repository.fetchAvailableDesks(date, slotId, type) { desks ->
            _availableDesks.postValue(desks as List<DeskAvailabilityResponse>?)
        }
    }
}

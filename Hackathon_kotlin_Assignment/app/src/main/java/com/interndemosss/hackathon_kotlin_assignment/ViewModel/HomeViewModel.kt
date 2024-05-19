package com.interndemosss.hackathon_kotlin_assignment.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    private val _selectedBackground = MutableLiveData<Int>()
    val selectedBackground: LiveData<Int> get() = _selectedBackground

    fun setSelectedBackground(background: Int) {
        _selectedBackground.value = background
    }
}

package com.interndemosss.hackathon_kotlin_assignment.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.interndemosss.hackathon_kotlin_assignment.Model.LoginResponse
import com.interndemosss.hackathon_kotlin_assignment.RetrofitApi.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CreateAccountViewModel : ViewModel() {
    private val _createAccountResponse = MutableLiveData<LoginResponse>()
    val createAccountResponse: LiveData<LoginResponse> = _createAccountResponse

    fun createAccount(email: String, name: String) {
        RetrofitClient.apiService.createAccount(email, name).enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful) {
                    _createAccountResponse.value = response.body()
                } else {
                    val errorMessage = "Failed to create account: ${response.code()} ${response.errorBody()?.string()}"
                    Log.e("CreateAccountViewModel", errorMessage)
                    _createAccountResponse.value = LoginResponse("Failed", errorMessage)
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                val errorMessage = "Network error: ${t.message}"
                Log.e("CreateAccountViewModel", errorMessage, t)
                _createAccountResponse.value = LoginResponse("Failure", errorMessage)
            }
        })
    }
}

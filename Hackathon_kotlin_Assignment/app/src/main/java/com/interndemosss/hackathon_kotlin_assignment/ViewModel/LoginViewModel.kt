package com.interndemosss.hackathon_kotlin_assignment.ViewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.interndemosss.hackathon_kotlin_assignment.Model.LoginResponse
import com.interndemosss.hackathon_kotlin_assignment.RetrofitApi.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel : ViewModel() {

    fun login(email: String, password: String, callback: (Boolean) -> Unit) {
        RetrofitClient.apiService.login(email, password)
            .enqueue(object : Callback<LoginResponse> {
                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                    if (response.isSuccessful) {
                        Log.d("LoginViewModel", "Login successful")
                        callback(true)
                    } else {
                        Log.d("LoginViewModel", "Login failed")
                        callback(false)
                    }
                }
                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    Log.e("LoginViewModel", "Network error occurred", t)
                    callback(false)
                }
            })
    }
}

package com.interndemosss.hackathon_kotlin_assignment.RetrofitApi

import com.interndemosss.hackathon_kotlin_assignment.SSLCertification.UnsafeSSLTrustManager
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {
    private const val BASE_URL = "https://demo0413095.mockable.io/"

    private val retrofit: Retrofit by lazy {
        val client = OkHttpClient.Builder()
            .sslSocketFactory(UnsafeSSLTrustManager.getUnsafeSSLContext().socketFactory, UnsafeSSLTrustManager())
            .hostnameVerifier { _, _ -> true }
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .build()

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}


package com.interndemosss.hackathon_kotlin_assignment.RetrofitApi

import com.interndemosss.hackathon_kotlin_assignment.Model.BookingHistoryResponse
import com.interndemosss.hackathon_kotlin_assignment.Model.BookingResponse
import com.interndemosss.hackathon_kotlin_assignment.Model.DeskAvailabilityResponse
import com.interndemosss.hackathon_kotlin_assignment.Model.LoginResponse
import com.interndemosss.hackathon_kotlin_assignment.Model.SlotsResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    @FormUrlEncoded
    @POST("digitalflake/api/login")
    fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<LoginResponse>

    @FormUrlEncoded
    @POST("digitalflake/api/create_account")
    fun createAccount(
        @Field("email") email: String,
        @Field("name") name: String
    ): Call<LoginResponse>

    @GET("digitalflake/api/get_slots")
    fun getSlots(@Query("date") date: String): Call<SlotsResponse>

    @GET("digitalflake/api/get_availability")
    fun getAvailableDesks(
        @Query("date") date: String,
        @Query("slot_id") slotId: Int,
        @Query("type") type: Int
    ): Call<List<DeskAvailabilityResponse>>

    @GET("digitalflake/api/get_bookings")
    fun getBookingHistory(@Query("user_id") userId: Int): Call<List<BookingHistoryResponse>>

    @POST("digitalflake/api/confirm_booking")
    suspend fun confirmBooking(
        @Query("date") date: String,
        @Query("slot_id") slotId: Int,
        @Query("workspace_id") workspaceId: Int,
        @Query("type") type: Int
    ): Response<BookingResponse>
}

package com.example.quizmemory.data.network

import com.example.quizmemory.data.model.QuizModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("/api.php")
    fun getApi(
        @Query("amount") amount: Int = 10,
        @Query("category") category: String,
        @Query("difficulty") difficulty: String,
        @Query("type") type: String = "multiple"
    ): Call<QuizModel>
}